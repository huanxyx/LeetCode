package com.xyx.leetcode.solution;

//474. Ones and Zeros
public class Solution474 {
	/*
	 * 状态：dp[i][j][k]：只考虑前i个字符串下j个0，k个1的最优解
	 * 状态转移：
	 * 			dp[i][j][k] = max(dp[i - 1][j - zero][k - one] + 1, dp[i - 1][j][k])	if j >= zero && k >= one
	 */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (String str : strs) {
        	int[] num = getOneAndZeroNum(str);
        	for (int i = m; i >= num[0]; i--) {
        		for (int j = n; j >= num[1]; j--) {
        			//包含，不包含
        			dp[i][j] = Math.max(dp[i - num[0]][j - num[1]] + 1, dp[i][j]);
        		}
        	}
        }
        
        return dp[m][n];
    }
    
    public int[] getOneAndZeroNum(String str) {
    	int zero = 0;
    	int one = 0;
    	for (int i = 0; i < str.length(); i++) {
    		if (str.charAt(i) == '0')
    			zero++;
    		else if (str.charAt(i) == '1')
    			one++;
    	}
    	return new int[] {zero, one};
    }
}
