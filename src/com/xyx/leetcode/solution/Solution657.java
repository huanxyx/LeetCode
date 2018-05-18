package com.xyx.leetcode.solution;

//657. Judge Route Circle
public class Solution657 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char op : moves.toCharArray()) {
        	if (op == 'U')			y++;
        	else if (op == 'D')		y--;
        	else if (op == 'L')		x--;        		
        	else if (op == 'R')		x++;
        }
        return x == 0 && y == 0;
    }
}
