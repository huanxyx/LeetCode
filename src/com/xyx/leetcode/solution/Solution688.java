package com.xyx.leetcode.solution;

//688. Knight Probability in Chessboard
public class Solution688 {

    public double knightProbability(int N, int K, int r, int c) {
    	if (r >= N || c >= N)
    		return 0;
    	if (K == 0)
    		return 1;
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1;
        for (int i = 1; i <= K; i++) {
        	for (int row = 0; row < N; row++) {
        		for (int col = 0; col < N; col++) {
        			if (dp[i - 1][row][col] != 0) {
        				move(dp, N, row, col, 1, 2, i);
        				move(dp, N, row, col, 1, -2, i);
        				move(dp, N, row, col, -1, 2, i);
        				move(dp, N, row, col, -1, -2, i);
        				move(dp, N, row, col, 2, 1, i);
        				move(dp, N, row, col, -2, 1, i);
        				move(dp, N, row, col, 2, -1, i);
        				move(dp, N, row, col, -2, -1, i);
        			}
        		}
        	}
        }
        
        double res = 0;
        for (int row = 0; row < N; row++) {
        	for (int col = 0; col < N; col++) {
        		res += dp[K][row][col];
        	}
        }
        
        return res;
    }
    
    public void move(double[][][] dp, int N, int lastR, int lastC, int deltR, int deltC, int mvNum) {
    	int curR = lastR + deltR;
    	int curC = lastC + deltC;
    	if (0 <= curR && curR < N && 0 <= curC && curC < N)
    		dp[mvNum][curR][curC] += dp[mvNum - 1][lastR][lastC] * (1.0 / 8);
    }

}
