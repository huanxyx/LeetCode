package com.xyx.leetcode.solution;

//13. Roman to Integer
public class Solution013 {
    public int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        
        /*
         * 右边的和若是比当前值大，意味着当前值为右边那个数的辅助数。
         */
        for (int i = len - 1; i >= 0; i--) {
        	char cur = s.charAt(i);
        	if (cur == 'I')			result += (result >= 5) ? -1 : 1;
        	else if (cur == 'V')	result += 5;
        	else if (cur == 'X') 	result += (result >= 50 ? -10 : 10);
        	else if (cur == 'L')	result += 50;
        	else if (cur == 'C')	result += (result >= 500 ? -100 : 100);
        	else if (cur == 'D')	result += 500;
        	else if (cur == 'M')	result += 1000;
        }

        return result;
    }
}
