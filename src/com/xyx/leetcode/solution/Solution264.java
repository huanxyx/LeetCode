package com.xyx.leetcode.solution;

//264. Ugly Number II
public class Solution264 {

	/*
	 * 每个丑数都是在另一个丑数的基础上乘2(或者3或者5)，
	 * 所有第n个丑数依赖于前面所有丑数中*2或者*3或者*5中最小的那个。
	 */
    public int nthUglyNumber(int n) {
        if (n == 1)
        	return 1;
    	int[] dp = new int[n];
    	dp[0] = 1;
    	
    	int mul2 = 0;
    	int mul3 = 0;
    	int mul5 = 0;
    	for (int i = 1; i < n; i++) {
    		while (dp[mul2] * 2 <= dp[i - 1])
    			mul2++;
    		while (dp[mul3] * 3 <= dp[i - 1])
    			mul3++;
    		while (dp[mul5] * 5 <= dp[i - 1])
    			mul5++;
    		dp[i] = Math.min(dp[mul2] * 2, Math.min(dp[mul3] * 3, dp[mul5] * 5));
    	}
    	return dp[n - 1];
    }
}
