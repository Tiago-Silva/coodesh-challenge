package com.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TASK2Test {

    @Test
    public void testAddAndPrint() {
        TASK2 list = new TASK2();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // Capture the output of the print method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.print();

        // Reset the System.out
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        String expectedOutput  = "A B C D E \n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testRemoveMiddle() {
        TASK2 list = new TASK2();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        list.print();
        list.removeMiddle();

        // Capture the output of the print method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.print();

        // Reset the System.out
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        String expectedOutput  = "A B D E \n";
        assertEquals(expectedOutput, outContent.toString());
    }
}