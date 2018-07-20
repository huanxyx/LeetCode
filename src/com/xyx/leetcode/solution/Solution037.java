package com.xyx.leetcode.solution;

//37.Sudoku Solver
public class Solution037 {
		
	int[][] rowNum;		//每一行	
	int[][] colNum;		//每一列
	int[][] boxNum;		//每一个3*3方格
    public void solveSudoku(char[][] board) {
		rowNum = new int[9][10];
		colNum = new int[9][10];
		boxNum = new int[9][10];
        
        //初始化每一行，每一列，每一个3*3方格各个数的数目
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			int num = toInt(board[i][j]); 
        			rowNum[i][num]++;					
        			colNum[j][num]++;
        			boxNum[getBoxNum(i, j)][num]++;
        		}
        	}
        }
        
        //求解问题
        solver(board, 0);
    }
    
    public boolean solver(char[][] board, int cur) {
    	if (cur == 81)			//当所有的元素都填充完毕的时候
    		return true;
    	int row = cur / 9;
    	int col = cur % 9;
    	
    	if (board[row][col] == '.') {
    		for (int i = 1; i <= 9; i++) {					//找到合适的数填充进去
    			if (isValid(i, row, col)) {
    				board[row][col] = (char) (i + '0');
    				rowNum[row][i]++;
    				colNum[col][i]++;
    				boxNum[getBoxNum(row, col)][i]++;
    				if (solver(board, cur + 1))
    					return true;
    				rowNum[row][i]--;
    				colNum[col][i]--;
    				boxNum[getBoxNum(row, col)][i]--;
    			}
    		}
    		board[row][col] = '.';
    		//当所有数都不合适的时候，返回到上一层
        	return false;
    	} else
    		return solver(board, cur + 1);
    }
    
    public boolean isValid(int num, int row, int col) {
    	return rowNum[row][num] == 0 && colNum[col][num] == 0 && boxNum[getBoxNum(row, col)][num] == 0;
    }
    
    public int getBoxNum(int row, int col) {
    	return (row / 3) * 3 + col / 3;
    }
    
    public int toInt(char ch) {
    	return ch - '0';
    }

}
