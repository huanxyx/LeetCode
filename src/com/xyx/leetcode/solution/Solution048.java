package com.xyx.leetcode.solution;

// 48.Rotate Image
public class Solution048 {
	//顺时针转动90度
    public void rotate(int[][] matrix) {
    	solution(matrix);
    }
    
    //第一种求法：
    private void solution(int[][] matrix) {
    	//先垂直镜像交换
        verticalMirror(matrix);
        //再对角线镜像交换
    	diagonalMirror(matrix);
    }
    
    /*
     * 另一种求法：
     * 		i代表着深度，每一轮外层循环都会将从外到里的第i层的数置换到指定位置
     * 		j代表着四轮循环交换需要的次数。（为该层的边长-1）
     */    
    private void solution1(int[][] matrix) {
    	int N = matrix.length-1;
    	for (int i = 0; i <= N/2; i++) {
    		int start = i;
    		int end = N - i;
    		for (int j = start; j < end; j++) {
    			int temp = matrix[start][j];
    			matrix[start][j] = matrix[N-j][start];
    			matrix[N-j][start] = matrix[end][N-j];
    			matrix[end][N-j] = matrix[j][end];
    			matrix[j][end] = temp;
    		}
    	}
    }
    
    //对角线镜像交换
    private void diagonalMirror(int[][] matrix) {
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = i; j < matrix.length; j++) {
    			swap(matrix, i, j, j, i);
    		}
    	}
    }
    
    //垂直镜像交换
    private void verticalMirror(int[][] matrix) {
    	int N = matrix.length / 2;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < matrix.length; j++) {
    			swap(matrix, i, j, matrix.length-1-i, j);
    		}
    	} 
    }
    
    //交换二位数组两个元素的位置
    private void swap(int[][] matrix, int rowA, int colA, int rowB, int colB) {
    	int temp = matrix[rowA][colA];
    	matrix[rowA][colA] = matrix[rowB][colB];
    	matrix[rowB][colB] = temp;
    }
}
