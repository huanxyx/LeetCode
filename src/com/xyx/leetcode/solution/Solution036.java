package com.xyx.leetcode.solution;

//36.Valid Sudoku
public class Solution036 {

    public boolean isValidSudoku(char[][] board) {
    	
    	//每一行
    	for (int i = 0; i < 9; i++) {
    		int[] map = new int[10];
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] == '.')
    				continue;
    			if (map[board[i][j] - '0'] > 0)
    				return false;
    			map[board[i][j] - '0']++;
    		} 
    	}
    	
    	//每一列
    	for (int i = 0; i < 9; i++) {
    		int[] map = new int[10];
    		for (int j = 0; j < 9; j++) {
    			if (board[j][i] == '.')
    				continue;
    			if (map[board[j][i] - '0'] > 0)
    				return false;
    			map[board[j][i] - '0']++;
    		} 
    	}
    	
    	//每个3*3的子模块
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			int leftTopX = 3 * i;
    			int leftTopY = 3 * j;
    			int[] map = new int[10];
    			for (int l = leftTopX; l < leftTopX + 3; l++) {
    				for (int w = leftTopY; w < leftTopY + 3; w++) {
    	    			if (board[l][w] == '.')
    	    				continue;
    					if (map[board[l][w] - '0'] > 0)
    						return false;
    					map[board[l][w] - '0']++;
    				}
    			}
    		}
    	}
    	
    	return true;
    	
    }

}
