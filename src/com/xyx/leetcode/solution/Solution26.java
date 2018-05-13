package com.xyx.leetcode.solution;

// 26.Remove Duplicates from Sorted Array
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int cur = 0;
        while (cur < nums.length) {
        	int num = nums[cur];
        	while (cur < nums.length && nums[cur] == num)
        		cur++;
        	nums[count++] = num;
        }
        return count;
    }
}
