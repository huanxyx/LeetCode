package com.xyx.leetcode.solution;

//188. Best Time to Buy and Sell Stock IV
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
    	if (prices.length == 0)
    		return 0;
    	
    	//假如k大于天数N的一半，那么相当于122. Best Time to Buy and Sell Stock II无限次购买的情况
    	//因为每次交易可以在第一天买进一次，第二天卖出一次，交易次数不会超过天数N的一半
    	if (k >= prices.length/2) {
    		int maxProfit = 0;
    		for (int i = 1; i < prices.length; i++) {
    			if (prices[i] > prices[i-1])
    				maxProfit += prices[i] - prices[i-1];
    		}
    		return maxProfit;
    	}
    	
    	//dp[i][j]表示前j天交易次数不超过i的最大利润
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
        	int minPrice = prices[0];									//最低购买价格
        	for (int j = 1; j < prices.length; j++) {
        		minPrice = Math.min(minPrice, prices[j] - dp[i - 1][j]);
        		dp[i][j] = Math.max(dp[i][j - 1], prices[j] - minPrice);
        	}
        }
        return dp[k][prices.length - 1];
    }
}
