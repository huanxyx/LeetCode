package com.xyx.leetcode.solution;

//44. Wildcard Matching
public class Solution044 {

    public boolean isMatch(String s, String p) {
    	return isMatch_1(s, p);
    }
    
    /*
     * dp实现：
     */
    public boolean isMatch_1(String s, String p) {
    	char[] sArr = s.toCharArray();
    	char[] pArr = p.toCharArray();
    	int sLen = sArr.length;
    	int pLen = pArr.length;
    	
    	boolean[][] dp = new boolean[sLen + 1][pLen + 1];
    	dp[0][0] = true;
    	for (int i = 1; i <= pLen && pArr[i - 1] == '*'; i++) {
    		dp[0][i] = true;
    	}
    	
    	for (int i = 1; i <= sLen; i++) {
    		for (int j = 1; j <= pLen; j++) {
    			if (sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '?')
    				dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
    			if (pArr[j - 1] == '*')
    				dp[i][j] = dp[i][j] || dp[i - 1][j] || dp[i][j - 1];
    		}
    	}
    	
    	return dp[sLen][pLen];
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution044().isMatch("cb", "?a"));
	}

}
