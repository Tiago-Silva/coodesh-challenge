package com.example;
/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 *
 *
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
     public static boolean isPalindrome(String str) {
         int i = 0, j = str.length() - 1;
         while (i < j) {
             if (str.charAt(i) != str.charAt(j)) {
                 return false;
             }
             i++;
             j--;
         }
         return true;
     }

     public static void main(String[] args) {
         System.out.println(isPalindrome("senhoras")); // false
         System.out.println(isPalindrome("arara")); // true
     }
}