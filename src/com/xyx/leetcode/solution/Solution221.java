package com.xyx.leetcode.solution;

//221. Maximal Square
public class Solution221 {

	/*
	 * 状态：dp[i][j]表示以i,j坐标为右下角的正方形的最长边长
	 * 状态转移方程：(i - 1,j - 1)和(i - 1, j)和(i, j - 1)中最小的那个 + 1
	 */
    public int maximalSquare(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
    	
    	int[][] dp = new int[rows + 1][cols + 1];
    	int res = 0;

    	for (int i = 1; i <= rows; i++) {
    		for (int j = 1; j <= cols; j++) {
    			if (matrix[i - 1][j - 1] == '1') {
    				dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
    				res = Math.max(dp[i][j], res);
    			}
    		}
    	}
    	return res * res;
    }

}
