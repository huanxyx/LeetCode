package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//17.Letter Combinations of a Phone Number
public class Solution017 {

	/*
	 * 回溯
	 */
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
    	if (digits == null || "".equals(digits))
    		return result;
    	char[] digArr = digits.toCharArray();
    	StringBuilder buffer = new StringBuilder();
    	
        recursHelper(digArr, 0, buffer, result);
    	return result;
    }
    
    public static String[] map = new String[] {
    		"",
    		"",
    		"abc",
    		"def",
    		"ghi",
    		"jkl",
    		"mno",
    		"pqrs",
    		"tuv",
    		"wxyz"
    };
    public static void recursHelper(char[] str, int cur, StringBuilder buffer, List<String> result) {
    	if (cur == str.length) {
    		if (buffer.length() != 0)
    			result.add(buffer.toString());
    		return ;
    	}
    	
    	int len = map[str[cur] - '0'].length();
    	
    	if (len == 0)
    		recursHelper(str, cur + 1, buffer, result);
    	else
	    	for (int i = 0; i < len; i++) {
	    		char ch = map[str[cur] - '0'].charAt(i);
	    		buffer.append(ch);
	    		recursHelper(str, cur + 1, buffer, result);
	    		buffer.deleteCharAt(buffer.length() - 1);
	    	}
    }

}
