package com.xyx.leetcode.solution;

//28. Implement strStr()
public class Solution28 {
    public int strStr(String haystack, String needle) {
    	int lastBeginPos = haystack.length() - needle.length();
    	for (int i = 0; i <= lastBeginPos; i++) {
    		int endPos = i + needle.length() - 1;
    		boolean validate = true;
    		for (int j = i; j <= endPos; j++) {
    			if (!(haystack.charAt(j) == needle.charAt(j-i))) {
    				validate = false;
    				break;
    			}
    		}
    		if (validate)
    			return i;
    	}
        
        return -1;
    }
}
