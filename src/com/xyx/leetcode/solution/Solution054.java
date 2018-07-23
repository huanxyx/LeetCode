package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//54.Spiral Matrix
public class Solution054 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return res;
        
        int topRow = 0;
        int topCol = 0;
        int botRow = matrix.length - 1;
        int botCol = matrix[0].length - 1;
        
        while (topRow <= botRow && topCol <= botCol) {
        	readMatrix(matrix, topRow++, topCol++, botRow--, botCol--, res);
        }
        return res;
    }
    
    private void readMatrix(int[][] matrix, int topRow, int topCol, int botRow, int botCol, List<Integer> res) {
    	if (topRow == botRow) {
    		for (int i = topCol; i <= botCol; i++)
    			res.add(matrix[topRow][i]);
    	} else if (topCol == botCol) {
    		for (int i = topRow; i <= botRow; i++)
    			res.add(matrix[i][topCol]);
    	} else {
    		int row = topRow;
    		int col = topCol;
    		while (col < botCol)
    			res.add(matrix[row][col++]);
    		while (row < botRow)
    			res.add(matrix[row++][col]);
    		while (col > topCol)
    			res.add(matrix[row][col--]);
    		while (row > topRow)
    			res.add(matrix[row--][col]);
    	}
    }

}
