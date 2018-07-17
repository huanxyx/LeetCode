package com.xyx.leetcode.solution;

//813. Largest Sum of Averages
public class Solution813 {

	/*
	 * 状态：dp[i][j]表示将前j个数分成i组的最优解
	 * 状态转移：将k...j分成一组
	 * 			dp[i][j] = max(dp[i - 1][k - 1] + avg(k, j))		其中avg(k, j)表示k到j之间数的平均数，其中k从第一个数到第j个数。
	 */
    public double largestSumOfAverages(int[] A, int K) {
        
    	//求出前n个数的和，并保存起来
    	double[] sums = new double[A.length + 1];
    	for (int i = 1; i <= A.length; i++) 
    		sums[i] += sums[i - 1] + A[i - 1];
        
    	double[][] dp = new double[K + 1][A.length + 1];
    	
    	for (int groups = 1; groups <= K; groups++) {
    		for (int end = 1; end <= A.length; end++) {
    			if (groups == 1)
    				dp[groups][end] = sums[end] / end;
    			else if (groups > end)
    				dp[groups][end] = sums[end];
    			else if (groups >= 2) {
    				for (int start = end; start >= 1; start--) {
    					dp[groups][end] = Math.max((sums[end] - sums[start - 1]) / (end - start + 1) + dp[groups - 1][start - 1],
    							dp[groups][end]);
    				}
    			}
    		}
    	}
    	
    	return dp[K][A.length];
    }

}
