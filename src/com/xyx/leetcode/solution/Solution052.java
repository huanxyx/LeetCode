package com.xyx.leetcode.solution;

//52. N-Queens II
public class Solution052 {

	private boolean[] rowUsed;
	private boolean[] colUsed;
	private boolean[] topToBotUsed;
	private boolean[] botToTopUsed;
	private int count;

    public int totalNQueens(int n) {	
    	if (n <= 0)
    		return 0;
    	
    	construct(n);
    	findAllDis(0, n);
    	return count;
    }
    
	private void findAllDis(int rowNum, int N) {
    	if (rowNum == N) {
    		count++;
    	} else {
    		for (int colNum = 0; colNum < N; colNum++) {
    			if (isValid(rowNum, colNum, N)) {
    				useOrN(rowNum, colNum, N, true);
    				findAllDis(rowNum + 1, N);
    				useOrN(rowNum, colNum, N, false);
    			}
    		}
    	}
    }
	
	//构建表
	private void construct(int n) {
    	rowUsed = new boolean[n];
    	colUsed = new boolean[n];
    	topToBotUsed = new boolean[2 * n - 1];
    	botToTopUsed = new boolean[2 * n - 1];
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

}
