package com.xyx.leetcode.solution;

//55.Jump Game	
public class Solution055 {

	/*
	 * 反过来贪心
	 */
    public boolean canJump(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return false;
        
    	int first = nums.length - 1;
    	for (int i = first; i >= 0; i--) {
    		if (nums[i] + i >= first)
    			first = i;
    	}
    	
    	return first == 0;
    }

}
