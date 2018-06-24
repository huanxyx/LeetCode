package com.xyx.leetcode.solution;

// 27.Remove Element
public class Solution027 {
    public int removeElement(int[] nums, int val) {
    	int cur = 0;
    	int count = 0;
    	while (cur < nums.length) {
    		if (nums[cur] != val){
    			nums[count++] = nums[cur];
    		}
    		cur++;
    	}
    	return count;
    }
}
