package com.xyx.leetcode.solution;

// 64. Minimum Path Sum
public class Solution064 {
	
	// O(n*m)的额外空间
    public int minPathSum(int[][] grid) {
    	int rows = grid.length;
    	int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) 
        	dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int i = 1; i < cols; i++) 
        	dp[0][i] = dp[0][i-1] + grid[0][i];
        for (int i = 1; i < rows; i++) 
        	for (int j = 1; j < cols; j++) 
        		dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        	
        return dp[rows - 1][cols - 1];
    }
    
    // O(n)的额外空间
    private int solution(int[][] grid) {
    	int cols = grid[0].length;
    	int[] dp = new int[cols];
    	
    	dp[0] = grid[0][0];
    	for (int i = 1; i < cols; i++) {
    		dp[i] = dp[i - 1] + grid[0][i];
    	}
    	
    	for (int j = 1; j < grid.length; j++) {
    		int[] row = grid[j];
    		dp[0] += row[0];
    		for (int i = 1; i < cols; i++) {
    			dp[i] = Math.min(dp[i], dp[i-1]) + row[i];
    		}
    	}
    	return dp[cols - 1];
    }
    
    // 原地求解,不使用额外的空间
    private int soltuion(int[][] grid) {
    	int rows = grid.length;
    	int cols = grid[0].length;
    	
    	for (int i = 1; i < cols; i++) {
    		grid[0][i] += grid[0][i-1];
    	}
    	for (int i = 1; i < rows; i++) {
    		grid[i][0] += grid[i-1][0];
    		for (int j = 1; j < cols; j++) {
    			grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
    		}
    	}
    	return grid[rows - 1][cols - 1];
    }
}
