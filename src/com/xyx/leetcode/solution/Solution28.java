package com.xyx.leetcode.solution;

//28. Implement strStr()
public class Solution28 {
	/*
	 * KMP算法
	 * 还有简单的BF（Brute Force）算法
	 */
    public int strStr(String haystack, String needle) {
    	if (needle.length() == 0)
    		return 0;
    	int[] nextTable = getNextTable(needle);
    	return match(haystack, needle, nextTable);
    }
    
    //匹配方法
    private int match(String str, String pattern, int[] next) {
    	int originP = 0;
    	int patternP = 0;
    	
    	while (originP < str.length() && patternP < next.length) {
    		if (patternP == -1 || str.charAt(originP) == pattern.charAt(patternP)) {
    			patternP++;
    			originP++;
    		} else {
    			patternP = next[patternP];
    		}
    	}
    	
    	if (patternP == next.length)
    		return originP - pattern.length();
    	
    	return -1;
    }
    
    //获取KMP算法的Next表
    private int[] getNextTable(String str) {
    	int len = str.length();
    	int[] next = new int[len];
    	char[] pattern = str.toCharArray();
    	
    	//当next表中的值为-1代表着向后移动一位
    	next[0] = -1;
    	int front = -1;
    	int tail = 0;
    	while (tail < len-1) {
    		if (front == -1 || pattern[tail] == pattern[front]) {
    			tail++;
    			front++;
    			if (pattern[tail] == pattern[front])
        			//优化
    				next[tail] = next[front];
    			else
    				next[tail] = front;
    		} else {
    			front = next[front];
    		}
    	}
    	return next;
    }
}
