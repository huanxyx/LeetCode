package com.xyx.leetcode.solution;

//279. Perfect Squares
public class Solution279 {
	
	/*
	 * 状态：输入为n时的解
	 * 状态转移方程：{当前数n减去所有能够减去的完全平方数}中结果的最小值
	 */
    public int numSquares(int n) {
    	
    	int[] dp = new int[n + 1];
    	
    	for (int i = 1; i <= n; i++) {
    		int k = (int) Math.sqrt(i);
    		dp[i] = Integer.MAX_VALUE;
    		for (int j = 1; j <= k; j++) {
    			dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    		}
    	}
    	
        return dp[n];
    }

}
