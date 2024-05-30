package com.example;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TASK4Test {

    @Test
    public void testExecuteRequest() throws IOException {
        CloseableHttpClient httpClient = TASK4.createHttpClient();
        String responseBody = TASK4.executeRequest(httpClient);
        assertNotNull(responseBody);
    }

    @Test
    public void testParseResponse() {
        String responseBody = "[{\"gender\": \"male\"}, {\"gender\": \"female\"}]";
        JSONArray records = TASK4.parseResponse(responseBody);
        assertNotNull(records);
        assertEquals(2, records.length());
    }

    @Test
    public void testCountGenders() {
        JSONArray records = new JSONArray("[{\"gender\": \"male\"}, {\"gender\": \"female\"}, {\"gender\": \"male\"}]");
        Map<String, Integer> genderCount = TASK4.countGenders(records);
        assertNotNull(genderCount);
        assertEquals(2, genderCount.size());
        assertEquals(2, genderCount.get("male"));
        assertEquals(1, genderCount.get("female"));
    }

    @Test
    public void testCreateFile() throws IOException {
        HashMap<String, Integer> genderCount = new HashMap<>();
        genderCount.put("male", 2);
        genderCount.put("female", 1);

        File file = TASK4.createFile("testFile", genderCount);

        assertTrue(file.exists());

        BufferedReader reader = new BufferedReader(new FileReader(file));
        assertEquals("female: 1", reader.readLine());
        assertEquals("male: 2", reader.readLine());
    }
}