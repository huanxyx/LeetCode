package com.xyx.leetcode.solution;

//300. Longest Increasing Subsequence
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
    	return solution2(nums);
    }
    
    //二分查找
    private int solution2(int[] nums) {
    	int[] tail = new int[nums.length];
    	int len = 0;
    	
    	for (int num : nums) {
    		//返回应该插入的位置，或者存在的位置
    		int insertIndex = search(tail, num, len);
    		tail[insertIndex] = num;
    		
    		//只有当元素插入到最后面的时候才会使序列增长
    		if (insertIndex == len) len++;
    	}
    	//最后tail的长度len就是最长递增子序列
    	return len;
    }
    
    //二分查找
    private int search(int[] arr, int num, int len) {
    	int low = 0;
    	int hig = len-1;
    	while (low <= hig) {
    		int mid = (hig + low) / 2;
    		if (arr[mid] < num) 		low = mid + 1;
    		else						hig = mid - 1;
    	}
    	return low;
    }
    
    //动态规划
    private int solution1(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLen = 0;
        /*
         * dp[i]中存储着以nums[i]为子序列的最后一个元素的最长子序列
         * dp[0] = 1
         * 状态转移方程dp[i] = 1 + max(dp[j] 0<=j<i and nums[j]<nums[i])
         */
        for (int i = 0; i < dp.length; i++) {
        	int max = 0;
        	for (int j = i - 1; j >= 0; j--) {
        		if (nums[j] < nums[i] && max < dp[j])
        			max = dp[j];        			
        	}
        	dp[i] = max + 1;
        	if (dp[i] > maxLen)
        		maxLen = dp[i];
        }
        
        return maxLen;
    }
}
