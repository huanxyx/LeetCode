package com.xyx.leetcode.solution;

import java.util.Arrays;

//16. 3Sum Closest
public class Solution016 {
	
	// 排序，固定一个值，利用2Sum算法计算剩余的数，判断是否跟目标值更加接近
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
        		int left = i + 1;
        		int right = nums.length - 1;
        		
        		while (left < right) {
        			int sum = nums[left] + nums[right] + nums[i];
        			if (sum == target)			return target;
        			else if (sum < target) 		left++;
        			else 						right--;
        			if (Math.abs(target - sum) < min) {
            			min = Math.abs(target - sum);
            			result = sum;
            		}
        		}
        	}
        }
        return result;
    }
}
