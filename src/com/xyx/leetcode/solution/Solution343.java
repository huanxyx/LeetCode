package com.xyx.leetcode.solution;

//343. Integer Break
public class Solution343 {

	/*
	 * 状态：dp[i]表示在n下的解
	 * 状态转移：
	 * 			dp[i] = max(max(dp{1..i-1}, j) * (i - j))
	 */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	for (int j = 1; j < i; j++) {
        		dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
        	}
        }
        return dp[n];
    }

}
