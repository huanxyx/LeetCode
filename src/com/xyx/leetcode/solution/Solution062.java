package com.xyx.leetcode.solution;

// 62. Unique Paths
public class Solution062 {
	
	//Dynamic Programming
    public int uniquePaths(int m, int n) {
    	if (m == 0 || n == 0)
    		return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i == 0 || j == 0)	
        			dp[i][j] = 1;
        		else 
        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        return dp[m - 1][n - 1];
    }
    
    /*
     * 排列组合解决该问题：
     * 		将往右移动看作1，
     * 		将往下移动看作0，
     * 		肯定为移动(m + n - 2)次，向下移动m-1次，向右移动n-1次，
     * 	问题转变成：
     * 		将其看作(m + n - 2)位数，其中1有n-1个，0有m-1个，
     * 		求其能够表达不的不同数的个数？
     * 		从(m + n - 2)中选择(m-1)个位置的不同方式
     * 		 C(m-1)(m+n-2)
     */
    private int solution(int m, int n) {
    	long result = 1;
    	for (int i = 0; i < Math.min(n-1, m-1); i++) {
    		result = result * (m + n - 2 - i) / (i + 1);
    	}
    	return (int) result;
    }
}
