package com.xyx.leetcode.solution;

//130. Surrounded Regions
public class Solution130 {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return ;
        //遍历边上所有的点，然后对这些点进行递归找到所有与他们相连的点
        for (int i = 0; i < board[0].length; i++) {
            handler(board, 0, i);
            handler(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            handler(board, i, 0);
            handler(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'R') board[i][j] = 'X';
                else board[i][j] = 'O';
            }
        }
    }

    private void handler(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return ;
        if (board[row][col] == 'R') return ;
        if (board[row][col] == 'X') return ;

        board[row][col] = 'R';

        handler(board, row - 1, col);
        handler(board, row + 1, col);
        handler(board, row, col + 1);
        handler(board, row, col - 1);
    }
}
