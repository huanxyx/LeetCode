package com.xyx.leetcode.solution;

//650. 2 Keys KeyBoard
public class Solution650 {

	/*
	 * 状态：在输入为n的情况下的解
	 * 状态转移：dp[n] = dp[j] + n / j，其中j为最大能整除n的数
	 */
    public int minSteps(int n) {
    	if (n == 0)
    		return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        
        for (int i = 2; i <= n; i++) {
        	dp[i] = Integer.MAX_VALUE;
        	for (int j = i/2; j >= 1; j--) {
        		if (i % j == 0)						//能够整除
        			dp[i] = Math.min(dp[i], dp[j] + i / j);
        	}
        }
        
        return dp[n];
    }
    
    /*
     * 优化实现
     */
    public int solution_1(int n) {
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

}
