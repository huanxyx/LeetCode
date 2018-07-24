package com.xyx.leetcode.solution;

//59. Spiral Matrix II
public class Solution059 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int x1 = 0;
        int y1 = 0;
        int x2 = n - 1;
        int y2 = n - 1;
        num = 1;
        
        while (x1 <= x2 && y1 <= y2) {
        	fillMatrix(x1++, y1++, x2--, y2--, matrix);
        }
        return matrix;
    }
    private int num;
    
    private void fillMatrix(int x1, int y1, int x2, int y2, int[][] matrix) {
    	if (x1 == x2) {
    		for (int i = y1; i <= y2; i++) 
    			matrix[i][x1] = num++;
    	} else if (y1 == y2) {
    		for (int i = x1; i <= x2; i++)
    			matrix[y1][i] = num++;
    	} else {
    		int x = x1;
    		int y = y1;
    		while (x < x2)
    			matrix[y][x++] = num++;
    		while (y < y2)
    			matrix[y++][x] = num++;
    		while (x > x1)
    			matrix[y][x--] = num++;
    		while (y > y1)
    			matrix[y--][x] = num++;
    	}
    }

}
