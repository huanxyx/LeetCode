package com.xyx.leetcode.solution;

//96. Unique Binary Search Trees
public class Solution096 {

	/*
	 * 状态：num下能够构成不同的二叉搜索树的个数
	 * 状态转移方程：左子树能够构成的二叉搜索树的个数*右子树能够构成的二叉搜索树的个数
	 */
    public int numTrees(int n) {
    	if (n <= 1)
    		return n;
    	
    	int[] dp = new int[n + 1];
    	dp[0] = 1;
    	dp[1] = 1;
    	for (int num = 2; num <= n; num++) {
    		for (int len = 0; len < num; len++)
    			dp[num] += dp[len] * dp[num - len - 1];			//dp[len]:左边节点的个数，dp[num - len - 1]:右边节点的个数
    	}
    	
    	return dp[n];
    }
}
