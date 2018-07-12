package com.xyx.leetcode.solution;

//712. Minimum ASCII Delete Sum for Two Strings
public class Solution712 {

	/*
	 * 见583题，类似的实现原理
	 */
    public int minimumDeleteSum(String s1, String s2) {
        if (s1 == null || s2 == null)
        	return 0;
        
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for (int i = 0; i <= s1.length(); i++) {
        	for (int j = 0; j <= s2.length(); j++) {
        		if (i == 0 && j == 0)
        			dp[0][0] = 0;
        		else if (i == 0)
        			dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        		else if (j == 0)
        			dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        		else if (s1.charAt(i - 1) == s2.charAt(j - 1))			//字符相同
        			dp[i][j] = dp[i - 1][j - 1];
        		else {													//字符不相同
        			dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
        		}
        	}
        }
        return dp[s1.length()][s2.length()];
    }

}
