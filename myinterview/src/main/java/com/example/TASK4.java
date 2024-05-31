package com.example;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */
public class TASK4 {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String ACCESS_KEY = dotenv.get("AWS_ACCESS_KEY");
    private static final String SECRET_KEY = dotenv.get("AWS_SECRET_KEY");
    private static final String API_ENDPOINT = dotenv.get("AWS_API_ENDPOINT");
    private static final String BUCKET_NAME = dotenv.get("AWS_BUCKET_NAME");

    private static BasicAWSCredentials awsCreds = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    private static final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .withRegion(Regions.DEFAULT_REGION)
            .build();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = createHttpClient();
        String responseBody = executeRequest(httpClient);
        JSONArray records = parseResponse(responseBody);
        Map<String, Integer> genderCount = countGenders(records);
        printGenderCount(genderCount);

        File file = createFile("genderCount", (HashMap<String, Integer>) genderCount);
        String objectName = saveFileToS3("genderCount", file);
        boolean isFileInS3 = isFileInS3(objectName);
        System.out.println("File saved to S3: " + isFileInS3);
    }

    public static CloseableHttpClient createHttpClient() {
        return HttpClients.createDefault();
    }

    public static String executeRequest(CloseableHttpClient httpClient) throws IOException {
        HttpGet request = new HttpGet(API_ENDPOINT);
        HttpResponse response = httpClient.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    public static JSONArray parseResponse(String responseBody) {
        return new JSONArray(responseBody);
    }

    public static Map<String, Integer> countGenders(JSONArray records) {
        Map<String, Integer> genderCount = new HashMap<>();
        for (int i = 0; i < records.length(); i++) {
            JSONObject record = records.getJSONObject(i);
            String gender = record.getString("gender");
            genderCount.put(gender, genderCount.getOrDefault(gender, 0) + 1);
        }
        return genderCount;
    }

    public static void printGenderCount(Map<String, Integer> genderCount) {
        genderCount.forEach((gender, count) -> {
            System.out.println(gender + ": " + count);
        });
    }

    public static File createFile(String fileName, HashMap<String, Integer> genderCount) throws IOException {
        File file = File.createTempFile(fileName, ".txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (Map.Entry<String, Integer> entry : genderCount.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
        return file;
    }

    public static String saveFileToS3(String fileName, File file) {
        try {
            s3.putObject(new PutObjectRequest(BUCKET_NAME, fileName, file));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        return fileName;
    }
    public static boolean isFileInS3(String objectName) {
        return s3.doesObjectExist(BUCKET_NAME, objectName);
    }
}