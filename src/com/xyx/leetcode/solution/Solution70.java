package com.xyx.leetcode.solution;

//70. Climbing Stairs
public class Solution70 {
    public int climbStairs(int n) {
    	//dp[i]存储着到达i位置不同跳法的数量
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
