package com.xyx.leetcode.solution;

//63. Unqiue Paths II
public class Solution63 {
	
	// 二维数组的dp实现
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int row = obstacleGrid.length;
    	int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        
        for (int i = 0; i < row; i++) {
        	if (obstacleGrid[i][0] != 1)		dp[i][0] = 1;
	        else 								break;
        }
        // 不能改为1，需要开头就被阻塞的情况
        for (int j = 0; j < col; j++) {
        	if (obstacleGrid[0][j] != 1)		dp[0][j] = 1;
	        else 								break;
        }
        
        for (int i = 1; i < row; i++) {
        	for (int j = 1; j < col; j++) {
        		if (obstacleGrid[i][j] == 0)
        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        return dp[row - 1][col - 1];
    }
    
    //一维数组的dp实现
    private int solution(int[][] obstacleGrid) {
    	int cols = obstacleGrid[0].length;
    	int[] dp = new int[cols];
    	//考虑第一行第一个不是阻碍物的情况，若是阻碍物的话会在循环中重新赋值。
    	dp[0] = 1;
    	for(int[] row : obstacleGrid) {
    		for (int i = 0; i < cols; i++) {
    			if (row[i] == 1)
    				dp[i] = 0;
    			else if (i > 0)
    				dp[i] += dp[i-1];
    		}
    	}
    	return dp[cols - 1];
    }
}
