package com.xyx.leetcode.solution;

//714. Best Time to Buy and Sell Stock with Transaction Fee
public class Solution714 {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1)
        	return 0;
    	int[] sell = new int[prices.length];				//第i天没有持有股
    	int[] hold = new int[prices.length];				//第i天持有股
    	sell[0] = 0;
    	hold[0] = -prices[0];
    	
    	for (int i = 1; i < prices.length; i++) {
    		sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i] - fee);
    		hold[i] = Math.max(hold[i - 1], sell[i - 1] - prices[i]);
    	}
    	return sell[prices.length - 1];
    }

}
