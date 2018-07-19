package com.xyx.leetcode.solution;

//32. Longest Valid Parentheses
public class Solution032 {


    public int longestValidParentheses(String s) {
    	return dpSolver(s);
    }
    
	/*
	 * dp[i]：表示以第i个字符结尾的最长的有效括号字符串
	 */
    public int dpSolver(String s) {
    	int[] dp = new int[s.length() + 1];
    	
    	int res = 0;
    	for (int i = 2; i <= s.length(); i++) {
    		char cur = s.charAt(i - 1);
    		if (cur == ')') {											
    			char left = s.charAt(i - 2);
    			if (left == '(') {									//...()
    				dp[i] = dp[i - 2] + 2;
    			} else {
    				int leftPos = i - 1 - dp[i - 1] - 1;
    				if (leftPos >= 0 && s.charAt(leftPos) == '(')	//(...)(...)
    					dp[i] = 2 + dp[i - 1] + dp[leftPos];
    			}
    		}
    		res = Math.max(dp[i], res);
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution032().longestValidParentheses("))))((()(("));
	}
}
