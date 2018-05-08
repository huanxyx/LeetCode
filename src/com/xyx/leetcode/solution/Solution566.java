package com.xyx.leetcode.solution;

//566. Reshape the Matrix
public class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int O_COLS = nums[0].length;
        int O_ROWS = nums.length;
    	//判断是否合法
        if (O_COLS * O_ROWS != r * c)
        	return nums;
        
        int pos = 0;
        int[][] newMatrix = new int[r][];
        for (int i = 0; i < newMatrix.length; i++) {
        	int[] cols = new int[c];
        	for (int j = 0; j < c; j++) {
        		cols[j] = nums[pos/O_COLS][pos%O_COLS];
        		pos++;
        	}
        	newMatrix[i] = cols;
        }
    	return newMatrix;
    }
}
