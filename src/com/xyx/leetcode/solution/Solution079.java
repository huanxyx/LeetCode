package com.xyx.leetcode.solution;

//79. Word Search
public class Solution079 {

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        char[] wordArr = word.toCharArray();
        
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++)
        		if (helper(i, j, 0, wordArr, used, board))
        			return true;
        }
        return false;
    }
    
    private boolean helper (int curX, int curY, int curChPos, char[] word, boolean[][] used, char[][] board) {
    	if (curChPos == word.length)
    		return true;
    	if (curX < 0 || curY < 0 || curX >= board.length || curY >= board[0].length)
    		return false;
    	if (used[curX][curY])
    		return false;
    	if (word[curChPos] != board[curX][curY])
    		return false;
    	
    	used[curX][curY] = true;
    	boolean result = helper(curX - 1, curY, curChPos + 1, word, used, board) ||
    					 helper(curX, curY - 1, curChPos + 1, word, used, board) ||
    					 helper(curX + 1, curY, curChPos + 1, word, used, board) ||
    					 helper(curX, curY + 1, curChPos + 1, word, used, board);
    	used[curX][curY] = false;
    	return result;
    }

}
