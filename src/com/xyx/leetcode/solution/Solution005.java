package com.xyx.leetcode.solution;

//5. Longest Palindromic Substring
public class Solution005 {
	
	//动态规划
    public String longestPalindrome(String s) {
    	//dp[i][j]用于存储i...j的字符串是否满足会问字符串
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	int maxLen = 0;
    	int startIndex = 0;
    	//递推过程
    	for (int start = dp.length-1; start >= 0; start--) {
    		for (int end = start; end < dp.length; end++) {
    			dp[start][end] = s.charAt(start) == s.charAt(end) && 
    					(end - start < 3 || dp[start+1][end-1]);
    			if (dp[start][end]) {
    				int len = end - start + 1;
    				if (len >= maxLen) {
    					maxLen = len;
    					startIndex = start;
    				}
    			}
    		}
    	}
    		
    	return s.substring(startIndex, startIndex + maxLen);
    }
    
    public static void main(String[] args) {
		System.out.print(new Solution005().longestPalindrome("babad"));
	}
}
