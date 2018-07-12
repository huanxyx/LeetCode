package com.xyx.leetcode.solution;

//583. Delete Operation for Two Strings
public class Solution583 {

	/*
	 * 状态：dp[i][j]表示word1的前i个字符和word2的前j个字符的解
	 * 状态转移方程：
	 * 		dp[i][j] = i + j			   								if i == 0 || j == 0
	 * 		dp[i][j] = dp[i - 1][j - 1]    								if word1[i] == word2[j]
	 * 		dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1			if word1[i] != word2[j]
	 */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
        	return 0;
        
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i <= word1.length(); i++) {
        	for (int j = 0; j <= word2.length(); j++) {
        		if (i == 0 || j == 0)
        			dp[i][j] = i + j;
        		else if (word1.charAt(i - 1) == word2.charAt(j - 1)) 
        			dp[i][j] = dp[i - 1][j - 1];
        		else {
        			dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
        		}
        	}
        }
    	return dp[word1.length()][word2.length()];
    }
}
