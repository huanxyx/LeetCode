package com.xyx.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 18. 4Sum
public class Solution018 {
	List<List<Integer>> result = new LinkedList();
	
	// 优化方式：固定一个值之后，先判断在当前固定值的情况是否可能有解，避免不必要的计算
    public List<List<Integer>> fourSum(int[] nums, int target) {	
    	Arrays.sort(nums);
    	
    	for (int i = 0; i < nums.length - 3; i++) {
    		threeSum(nums, i, target - nums[i]);
    		// 避免重复
    		while (i < nums.length - 3 && nums[i] == nums[i+1]) i++;
    	}
    	
        return result;
    }
    
    // curPos 第一个固定值的位置
    private void threeSum(int[] nums, int curPos, int target) {
    	int startPos = curPos + 1;
    	for (int i = startPos; i < nums.length - 2; i++) {
    		twoSum(nums, i, target - nums[i], nums[curPos]);
    		// 避免重复
    		while (i < nums.length - 2 && nums[i] == nums[i+1]) i++;
    	}
    }
    
    // curPos 第二个固定值的位置, x1固定第一个的值
    private void twoSum(int[] nums, int curPos, int target, int x1) {					
		int left = curPos + 1;							
		int right = nums.length - 1;									
		
    	while (left < right) {
    		int sum = nums[left] + nums[right];
    		if (sum == target) {
    			result.add(Arrays.asList( x1, nums[curPos], nums[left], nums[right]));
    			// 当值相同的时候避免重复
    			while (left < right && nums[left] == nums[left+1]) left++;
    			while (left < right && nums[right] == nums[right-1]) right--;
    			left++;
    			right--;
    		} else if (sum < target) {
    			left++;
    		} else {
    			right--;
    		}
     	}
    }
}
