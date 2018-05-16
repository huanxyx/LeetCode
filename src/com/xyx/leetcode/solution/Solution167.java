package com.xyx.leetcode.solution;

//167. Two Sum II - Input array is sorted
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        
        while (left < right) {
        	int total = numbers[left] + numbers[right];
        	if (total < target) 
        		left++;
        	else if (total > target)
        		right--;
        	else 
        		return new int[] {left+1, right+1};
        }
        return null;
    }
}
