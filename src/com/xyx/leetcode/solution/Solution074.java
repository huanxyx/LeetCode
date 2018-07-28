package com.xyx.leetcode.solution;

//74. Search a 2D Matrix
public class Solution074 {

	/*
	 * 因为矩阵是排好序的，所以可以借助二分查找找到指定的值
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0 || matrix[0].length == 0)
    		return false;
    	int cols = matrix[0].length;
    	int rows = matrix.length;
    	
        int low = 0;
        int hig = rows * cols - 1;
        
        while (low <= hig) {
        	int mid = low + ((hig - low) >> 1);
        	int value = matrix[mid / cols][mid % cols];
        	if (value == target) 
        		return true;
        	else if (value < target) 
        		low = mid + 1;
        	else 
        		hig = mid - 1;
        }
        
        return false;
    }


}
