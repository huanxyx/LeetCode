package com.xyx.leetcode.solution;

//647. Palindromic Substrings
public class Solution647 {

	/*
	 * 状态：dp[i][j]表示第i个到第j个构成的子字符串是否为回文字符串
	 * 初始状态：字符串长度为1和2的时候
	 * 状态转移方程（字符串长度为3或者以上的时候）：dp[i][j]为true仅当dp[i+1][j-1]为字符串，并且str[i]==str[j]
	 */
	/*
	 * 另一种实现方式：确定字符串的中心（奇数长度和偶数长度）
	 */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
        	return 0;
        int N = s.length();
    	boolean[][] dp = new boolean[N][N];
    	int res = 0;
    	
    	for (int start = N - 1; start >= 0; start--) {
    		for (int end = start; end < N; end++) {
    			dp[start][end] = s.charAt(end) == s.charAt(start) && (end - start < 2 || dp[start + 1][end - 1]);
    			if (dp[start][end])
    				res++;
    		}
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution647().countSubstrings("aaaaa"));
	}

}
