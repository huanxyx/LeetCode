package com.xyx.leetcode.solution;

//557. Reverse Words in a String III
public class Solution557 {
    public String reverseWords(String s) {
    	char[] buffer = s.toCharArray();
        int wordStart = 0;
        for (int j = 0; j < buffer.length; j++) {
        	if (buffer[j] == ' ') {
        		reverse(buffer, wordStart, j - 1);
        		wordStart = j + 1;
        	}
        }
        reverse(buffer, wordStart, buffer.length-1);
        return new String(buffer);
    }
    
    private void reverse(char[] buffer, int start, int end) {
    	while (start < end) {
    		char temp = buffer[start];
    		buffer[start] = buffer[end];
    		buffer[end] = temp;
    		start++;
    		end--;
    	}
    }
}
