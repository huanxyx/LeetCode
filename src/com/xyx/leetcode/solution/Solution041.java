package com.xyx.leetcode.solution;

//41. First Missing Positive
public class Solution041 {
	/*
	 * 题意：在乱序的数组中寻找第一个未曾出现的正整数
	 * 不能开辟另外的存储空间，则可以在原数组上进行操作。
	 * 
	 * 
	 * 解题思路：
	 * 		遍历每一个元素value，若是value属于[1, n]，
	 * 		且value-1位置的元素不为value
	 * 		则将该元素与value-1位置的元素进行交换。
	 * 
	 * 原理：
	 * 		1.对于k个正数，缺失的最小正数必定在[1, k+1]之内。
	 * 		2.这样操作会将范围在[1,n]的所有元素都放到对应的位置（重复的不考虑）。
	 * 		
	 */
    public int firstMissingPositive(int[] nums) {
    	int N = nums.length;
    	int i = 0;
    	while (i < N) {
    		//当还未标记。交换两个数进行标记
    		if (1 <= nums[i] && nums[i] <= N && nums[nums[i]-1] != nums[i])
    			swap(nums, i, nums[i]-1);
    		else 
    			i++;
    	}

    	i = 0;
    	while (i < N && nums[i] == i+1) i++;
    	//i==N的时候，意味着缺失的最小正整数为N+1，也就是i+1
    	//当i<N的时候，意味着nums[i] != i+1，所以缺失的就是i+1
    	return i+1;
    }
    
    private void swap(int[] nums, int a, int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}
