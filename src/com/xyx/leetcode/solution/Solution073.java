package com.xyx.leetcode.solution;

//73. Set Matrix Zeroes
public class Solution073 {

	/*
	 * 要求：	
	 * 		空间复杂度为：O(n*m) => O(m + n) => O(1)
	 * 只是用常数额外空间的方法就是使用原来矩阵中的原始位置作为标识：第一行与第一列
	 */
    public void setZeroes(int[][] matrix) {
    	//计算第一行是否有0，
    	//计算第一列是否有0
    	boolean zeroRowIsZero = false;
    	boolean zeroColIsZero = false;
        
    	//将每个为0的位置对应的行的第一个元素和列的第一个元素设置为0，用来标记这行是否为0
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == 0) {
        			if (i == 0) zeroRowIsZero = true;
        			if (j == 0) zeroColIsZero = true;
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        //对除开第一列与第一行的其他列与行进行操作
        for (int i = 1; i < matrix.length; i++) {
	        for (int j = 1; j < matrix[0].length; j++) {
	        	if (matrix[0][j] == 0 || matrix[i][0] == 0)
	        		matrix[i][j] = 0;
        	}
        }
        //判断第一行与第一列是否能被置为0
        if (zeroRowIsZero) {
        	for (int i = 0; i < matrix[0].length; i++)
        		matrix[0][i] = 0;
        }
        if (zeroColIsZero) {
        	for (int i = 0; i < matrix.length; i++)
        		matrix[i][0] = 0;
        }
    }

}
