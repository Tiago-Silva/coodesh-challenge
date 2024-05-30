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
    public void testIsPalindromeSuccess() throws Exception {
        assertTrue(TASK1.isPalindrome("arara"));
    }

    @Test
    public void testIsPalindromeError() throws Exception {
        assertFalse(TASK1.isPalindrome("senhoras"));
    }

    @Test
    public void testDefaultArgument() {
        // Passing no arguments should work.
        String[] args = {};
        TASK1.main(args);
    }

    @Test
    public void classInstanceForCodeCoverageTest() {
        new TASK1();
    }
}