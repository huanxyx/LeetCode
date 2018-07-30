package com.xyx.leetcode.solution;

//80. Remove Duplicates from Sorted Array II
public class Solution080 {

    public int removeDuplicates(int[] nums) {
    	int i = 0;								//应该放入的位置
    	for (int num : nums) {
    		if (i < 2 || num > nums[i - 2]) {
    			nums[i++] = num;
    		}
    	}
    	return i;
    }
}
