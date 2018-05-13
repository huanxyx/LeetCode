package com.xyx.leetcode.solution;

// 31.Next Permutation
public class Solution31 {
	
	//字典序：
	//		先比较第一个，若是第一个相同就比较第二个，之后类推，直到出现不同的，然后字母小的字符串小。
    public void nextPermutation(int[] nums) {
    	// 从右往左找到第一个顺序的数（nums[a] < nums[a+1]）
    	int left = nums.length - 2;
    	while (left >= 0 && nums[left] >= nums[left+1])
    		left--;
    	
    	// 从右往左找到第一个比首先找到顺序的数大的值，然后与之进行交换
    	if (left >= 0) {
    		int right = nums.length - 1;
    		while (nums[right] <= nums[left])
    			right--;
    		swap(nums, left, right);
    	} 
    	
    	// 将交换位置右边的数进行逆序（原本是逆序的），现在变成了从小到大
    	reverse(nums, left+1);
    }
    
    // 对数组的指定范围逆序
    public void reverse(int[] nums, int start) {
    	int left = start;
    	int right = nums.length - 1;
    	while (left < right) {
    		swap(nums, left, right);
    		left++;
    		right--;
    	}
    }
    
    // 交换数组两个位置的数
    public void swap(int[] nums, int a, int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}
