package com.xyx.leetcode.solution;

//516.Longest Palindromic Subsequence
public class Solution516 {

	/*
	 * 状态：dp[i][j]：求解i到j之间字符串的最长回文子序列
	 */
    public int longestPalindromeSubseq(String s) { 
    	int N = s.length();
    	int[][] dp = new int[N][N];
    	
    	for (int off = 0; off < N; off++) {
    		for (int start = 0; start +  off < N; start++) {
    			if (off == 0)
    				dp[start][start] = 1;
    			else if (off == 1) {
    				if (s.charAt(start) == s.charAt(start + off))
    					dp[start][start + off] = 2;
    				else
    					dp[start][start + off] = 1;
    			} else {
    				dp[start][start + off] = Math.max(dp[start][start + off - 1], dp[start + 1][start + off]);
    				if (s.charAt(start) == s.charAt(start + off))
    					dp[start][start + off] = Math.max(dp[start][start + off], dp[start + 1][start + off - 1] + 2);
    			}
    		}
    	}
    	return dp[0][N - 1];
    }

}
