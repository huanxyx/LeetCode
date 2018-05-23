package com.xyx.leetcode.solution;

//303. Range Sum Query - Immutable
public class Solution303 {
	
	//sums[i]存储着i之前元素的和
	private int[] sums;
    public Solution303(int[] nums) {
    	sums = new int[nums.length+1];
    	for (int i = 1; i <= nums.length; i++)
    		sums[i] = sums[i-1] + nums[i-1];
    }
    
    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}
