package com.xyx.leetcode.solution;

//485. Max Consecutive Ones
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int len = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == 1) {
    			len++;
    		} else {
    			if (len > max)
    				max = len;
    			len = 0;
    		}
    	}
    	//判断最后一个子序列
		if (len > max)
			max = len;
    	return max;
    }
}
