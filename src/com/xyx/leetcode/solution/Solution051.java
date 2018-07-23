package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//51. N-Queens
public class Solution051 {
	
	private boolean[] rowUsed;
	private boolean[] colUsed;
	private boolean[] topToBotUsed;
	private boolean[] botToTopUsed;

    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> res = new ArrayList<List<String>>();    	
    	if (n <= 0)
    		return res;
    	
    	char[][] board = construct(n);
    	findAllDis(board, 0, res, n);
    	
    	return res;
    }
    
	private void findAllDis(char[][] board, int rowNum, List<List<String>> res, int N) {
    	if (rowNum == N) {
    		ArrayList<String> list = new ArrayList<String>();
    		for (char[] strArr : board) {
    			list.add(new String(strArr));
    		}
    		res.add(list);
    	} else {
    		for (int colNum = 0; colNum < N; colNum++) {
    			if (isValid(rowNum, colNum, N)) {
    				useOrN(rowNum, colNum, N, true);
    				board[rowNum][colNum] = 'Q';
    				findAllDis(board, rowNum + 1, res, N);
    				board[rowNum][colNum] = '.';
    				useOrN(rowNum, colNum, N, false);
    			}
    		}
    	}
    }
	
	//构建表
	private char[][] construct(int n) {
    	//初始化表格
    	char[][] board = new char[n][n];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++)
    			board[i][j] = '.';
    	}
    	
    	rowUsed = new boolean[n];
    	colUsed = new boolean[n];
    	topToBotUsed = new boolean[2 * n - 1];
    	botToTopUsed = new boolean[2 * n - 1];
    	
    	return board;
	}
    
    //判断当前位置是否能用
	private boolean isValid(int row, int col, int N) {
		if (rowUsed[row])
			return false;
		if (colUsed[col])
			return false;
		if (botToTopUsed[row + col])
			return false;
		if (topToBotUsed[N - 1 - row + col])
			return false;
		return true;
    }
	
	//使用或者不使用当前位置
	private void useOrN(int row, int col, int N, boolean use) {
		rowUsed[row] = use;
		colUsed[col] = use;
		botToTopUsed[row + col] = use;
		topToBotUsed[N - 1 - row + col] = use;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution051().solveNQueens(8));
	}
}
