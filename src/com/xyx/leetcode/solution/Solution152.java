package com.xyx.leetcode.solution;

//152. Maximum Product Subarray
public class Solution152 {

	/*
	 * max[i]：表示以i位置数字结尾的子数组的最大乘积
	 * min[i]：表示以i位置数字结尾的子数组的最小乘积
	 * res：用以记录以每个位置结尾的子数组的最大乘积的最大值
	 */
	/*
	 * 另一种实现方式：从左往右一遍，再从右往左一遍，记录子数组的最大乘积
	 */
    public int maxProduct(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	int res = nums[0];
    	int max = nums[0];
    	int min = nums[0];
    	
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] >= 0) {
    			max = Math.max(nums[i], max * nums[i]);
    			min = Math.min(nums[i], min * nums[i]);
    		} else {
    			int tmp = max;
    			max = Math.max(nums[i], nums[i] * min);
    			min = Math.min(nums[i], tmp * nums[i]);
    		}
    		res = Math.max(max, res);
    	}
    	
        return res;
    }
}
