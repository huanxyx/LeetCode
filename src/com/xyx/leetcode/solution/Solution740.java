package com.xyx.leetcode.solution;

//740.Delete and Earn
public class Solution740 {

	/*
	 * 状态：dp[x]表示只考虑小于或等于x数的最优解
	 * 见198.House Robber
	 */
    public int deleteAndEarn(int[] nums) {
        
    	int[] values = new int[10001];
    	for (int num : nums) 
    		values[num] += num;
    	int[] dp = new int[10001];
    	dp[1] = values[1];
    	
    	for (int i = 2; i <= 10000; i++) {
    		dp[i] = Math.max(dp[i - 1], dp[i - 2] + values[i]);
    	}
    	
    	return dp[10000];
    }

}
