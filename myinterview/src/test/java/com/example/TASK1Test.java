package com.example;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TASK1Test {

    @Test
    public void testMain() {
        String[] args = {"arara"};
        TASK1.main(args);
    }

    @Test
    public void testIsPalindromeSuccess() {
        assertTrue(TASK1.isPalindrome("arara"));
    }

    @Test
    public void testIsPalindromeError() {
        assertFalse(TASK1.isPalindrome("senhoras"));
    }

    @Test
    public void testDefaultArgument() {
        String[] args = {};
        TASK1.main(args);
    }

    @Test
    public void classInstanceForCodeCoverageTest() {
        new TASK1();
    }
}