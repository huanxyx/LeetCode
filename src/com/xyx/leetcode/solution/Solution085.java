package com.xyx.leetcode.solution;

import java.util.Arrays;

//85***. Maximal Rectangle
public class Solution085 {

	/*
	 * 借助84题的思考方式
	 */
    public int maximalRectangle(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return 0;
    	int M = matrix.length;
    	int N = matrix[0].length;
    	
    	int[] height = new int[N];						//以第i个位置为底的直方的高
    	int[] leftEdge = new int[N];					//以第i个位置为底的高度为height[i]的左边界
    	int[] rightEdge = new int[N];					//以第i个位置为底的高度为height[i]的右边界
    	Arrays.fill(leftEdge, 0);
    	Arrays.fill(rightEdge, N - 1);
    	
    	int res = 0;
    	
    	for (int row = 0; row < M; row++) {
    		
    		//高度
    		for (int col = 0; col < N; col++) {
    			if (matrix[row][col] == '1')
    				height[col] += 1;
    			else
    				height[col] = 0;
    		}
    		
    		//左边界
    		int lEdge = 0;
    		for (int col = 0; col < N; col++) {
    			if (matrix[row][col] == '1') 
    				leftEdge[col] = Math.max(leftEdge[col], lEdge);
    			else {
    				leftEdge[col] = 0;
    				lEdge = col + 1;
    			}
    		}
    		
    		//右边界
    		int rEdge = N - 1;
    		for (int col = N - 1; col >= 0; col--) {
    			if (matrix[row][col] == '1')
    				rightEdge[col] = Math.min(rightEdge[col], rEdge);
    			else {
    				rightEdge[col] = N - 1;
    				rEdge = col - 1;
    			}
    		}
    		
    		//面积
    		for (int col = 0; col < N; col++) {
    			res = Math.max(res, (rightEdge[col] - leftEdge[col] + 1) * height[col]);
    		}
    	}
    	
        return res;
    }

}
