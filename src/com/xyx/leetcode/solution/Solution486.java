package com.xyx.leetcode.solution;

//486. Predict the Winner
public class Solution486 {

	/*
	 * 假设所有分数的总和为sum，那么最后一定时玩家1选择了一部分，玩家2选择了一部分。
	 * 当玩家一选择了一个数则加上分数，玩家二选择了一个数则减去分数
	 * 状态dp[i][j]：在i到j的范围内第一个人能够获取的相对于第二个人的最高分数
	 * 状态转移：		
	 * 			dp[start][end] = nums[start]		if start == end
	 * 			dp[start][end] = max(nums[start] - dp[start + 1][end], nums[end] - dp[start][end - 1])  if start != end
	 */
    public boolean PredictTheWinner(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return true;
    	
    	int[][] dp = new int[nums.length][nums.length];
    	
    	for (int len = 0; len < nums.length; len++) {					//从小范围到大范围
    		for (int start = 0; start < nums.length - len; start++) {
    			if (len == 0)
    				dp[start][start] = nums[start];
    			else {
    				int left = nums[start] - dp[start + 1][start + len];
    				int right = nums[start + len] - dp[start][start + len - 1];
    				dp[start][start + len] = Math.max(left, right); 
    			}
    		}
    	}
    	return dp[0][nums.length - 1] >= 0;
    }

    /*
     * 递归实现
     */
    public int getMaxScore(int[] nums, int low, int hig) {
    	if (low == hig) 
    		return nums[low];
    	else {
    		int first = nums[low] - getMaxScore(nums, low + 1, hig);
    		int last = nums[hig] - getMaxScore(nums, low, hig - 1);
    		return Math.max(first, last);
    	}
    }
}
