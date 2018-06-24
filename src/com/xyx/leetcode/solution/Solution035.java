package com.xyx.leetcode.solution;

// 35.Search Insert Position
public class Solution035 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
        	int mid = (right + left) >> 1;
        	if (nums[mid] == target) 
        		return mid;
        	else if (nums[mid] < target)
        		left = mid + 1;
        	else 
        		right = mid - 1;
        }
        return left;
    }
}
