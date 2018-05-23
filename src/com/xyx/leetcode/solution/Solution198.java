package com.xyx.leetcode.solution;

//198. House Robber
public class Solution198 {
    public int rob(int[] nums) {
    	int prevNo = 0;				//用于代表着上一个房子不被盗窃的最高金额
    	int prevYes = 0;			//用于代表着上一个房子被盗窃的最高金额
    	for (int n : nums) {
    		int temp = prevNo;
    		prevNo = Math.max(prevNo, prevYes);
    		prevYes = n + temp;
    	}
    	return Math.max(prevNo, prevYes);
    }
    
    private int solution(int[] nums) {
        int[] dp = new int[nums.length];
        
        if (nums.length == 0)
        	return 0;
        else if (nums.length == 1)
        	return nums[0];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}
