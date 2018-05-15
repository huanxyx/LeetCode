package com.xyx.leetcode.solution;

//121.Best Time to Buy and Sell Stock
public class Solution121 {
	/*
	 * 本质上就是求两个数的差值最大，后者减前者
	 */
    public int maxProfit(int[] prices) {
    	int minPrice = Integer.MAX_VALUE;
    	int maxProfit = 0;
    	for (int i = 0; i < prices.length; i++) {
    		maxProfit = Math.max(maxProfit, prices[i] - minPrice);
    		minPrice = Math.min(minPrice, prices[i]);
    	}
    	return maxProfit;
    } 
}
