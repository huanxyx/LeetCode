package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//22. Generate Parentheses
public class Solution022 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        solver(result, "", 0, 0, n);
        return result;
    }

    /*
     * 控制两个括号的数目，确定两个括号之间的关系（在任意时刻）：
     * 			open <= total
     * 			close <= open
     */
    private void solver(List<String> result, String str, int open, int close, int total) {
    	if (str.length() == total * 2)
    		result.add(str);
    	else {
    		if (open < total)				//只要当前左括号数量没有超过上限都可以使用
    			solver(result, str + "(", open + 1, close, total);
    		if (close < open)				//只要当前右括号的数目小于左括号，都可以使用
    			solver(result, str + ")", open, close + 1, total);
    	}
    }
}
