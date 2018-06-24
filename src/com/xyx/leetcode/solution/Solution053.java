package com.xyx.leetcode.solution;

// 53.Maximum Subarray
public class Solution053 {
    public int maxSubArray(int[] nums) {
    	int sum = 0;
    	int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (sum > max)
        		max = sum;
        	//若是当前sum小于零时，重置为0，因为为负数的时候，
        	//只会将后面的和变小。
        	if (sum < 0)
        		sum = 0;
        }
        return max;
    }
}
