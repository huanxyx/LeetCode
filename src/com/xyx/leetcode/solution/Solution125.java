package com.xyx.leetcode.solution;

//125. Valid Palindrome
public class Solution125 {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String revActual = new StringBuilder(actual).reverse().toString();
        return actual.equals(revActual);
    }
}
