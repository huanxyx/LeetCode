package com.xyx.leetcode.solution;

//494. Target Sum
public class Solution494 {

	/*
	 * 状态：dp[i][j]：表示只考虑前i个数的时候，能够构成j-1000的不同组合方式
	 * 状态转移：
	 * 			if dp[i - 1][target] != 0
	 * 				dp[i][target + nums[i - 1]] += dp[i - 1][target]
	 * 				dp[i][target - nums[i - 1]] += dp[i - 1][target]
	 */
    public int findTargetSumWays(int[] nums, int S) {
        if (mapping(S) > 2000 || mapping(S) < 0)
        	return 0;
        
    	int[][] dp = new int[nums.length + 1][2001];
    	
    	dp[0][mapping(0)] = 1;
        for (int i = 1; i <= nums.length; i++) {
        	for (int target = -1000; target <= 1000; target++) {
        		//由前面的数往后推（目标值不为0意味着能够通过变化得到目标值）
        		if (dp[i - 1][mapping(target)] != 0) {
        			dp[i][mapping(target + nums[i - 1])] += dp[i - 1][mapping(target)];
        			dp[i][mapping(target - nums[i - 1])] += dp[i - 1][mapping(target)];
        		}
        	} 
        }
  
    	return dp[nums.length][mapping(S)];
    }
    
    //映射转换
    public int mapping(int num) {
    	return num + 1000;
    }
}
