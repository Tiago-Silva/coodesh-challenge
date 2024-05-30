package com.example;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class TASK3Test {


    @Test
    public void createHashSetTest() {
        TASK3 task3 = new TASK3();
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> hashSet = task3.createHashSet(list);

        // Verifica se o HashSet não é nulo
        assertNotNull(hashSet);

        // Verifica se o tamanho do HashSet é menor ou igual ao tamanho da lista
        assertTrue(hashSet.size() <= list.size());

        // Verifica se todos os elementos da lista estão no HashSet
        assertTrue(hashSet.containsAll(list));
    }

    @Test
    public void createHashSetTestDuplication() {
        TASK3 task3 = new TASK3();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add("String " + i);
        }

        HashSet<String> hashSet = task3.createHashSet(list);

        // Verifica se o HashSet não é nulo
        assertNotNull(hashSet);

        // Verifica se o tamanho do HashSet é menor ou igual ao tamanho da lista
        assertTrue(hashSet.size() <= list.size());

        // Verifica se todos os elementos da lista estão no HashSet
        assertTrue(hashSet.containsAll(list));
    }
}