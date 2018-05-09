package com.xyx.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//15. 3Sum
public class Solution15 {

	// 1.先对数组进行排序
	// 2.从小到大固定一个值value，然后再在剩余的数中利用求2Sum的算法求两个数的和为-value。
	// 3.避免重复
	// 		3.1.不固定同一个值
	// 		3.2.当求2Sum的时候，跳过重复的值
	// 		3.3.求2Sum的之后，左边的起始位置为固定值位置的后一个，因为固定值左边的值已经检测过了。
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new LinkedList();
    	// 排序
    	Arrays.sort(nums);
    	
    	for (int i = 0; i < nums.length - 2; i++) {
    		// 避免固定重复的一个值
    		if (i == 0 || (i > 0 && nums[i-1] != nums[i])) {
	    		int fixNum = nums[i];						// 固定的一个值
	    		int left = i + 1;							// 避免重复，所以需要从i+1开始
	    		int right = nums.length - 1;				
	    		int target = -fixNum;						// 求2sum的目标值
	    		
	        	while (left < right) {
	        		if (nums[left] + nums[right] == target) {
	        			result.add(Arrays.asList(nums[i], nums[left], nums[right]));
	        			// 当值相同的时候避免重复
	        			while (left < right && nums[left] == nums[left+1]) left++;
	        			while (left < right && nums[right] == nums[right-1]) right--;
	        			left++;
	        			right--;
	        		} else if (nums[left] + nums[right] < target) {
	        			left++;
	        		} else {
	        			right--;
	        		}
	         	}
    		}
    	}
    	
    	return result;
    }

}
