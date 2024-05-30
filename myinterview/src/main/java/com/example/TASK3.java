package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
     * Write a list and add an aleatory number of Strings. In the end, print out how
     * many distinct itens exists on the list.
     *
     */
public class TASK3 {

    public HashSet<String> createHashSet(ArrayList<String> list) {
        Random random = new Random();

        int numStrings = random.nextInt(100);

        for (int i = 0; i < numStrings; i++) {
            list.add("String " + i);
        }
        // Cria um HashSet a partir da lista para remover duplicatas
        return new HashSet<>(list);
    }

    public static void main(String[] args) {
        TASK3 task3 = new TASK3();
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> hashSet = task3.createHashSet(list);
        for (String s : hashSet) {
            System.out.println(s);
        }
        System.out.println("Quantidade de itens distintos: " + hashSet.size());
    }

}
