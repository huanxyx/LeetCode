package com.xyx.leetcode.solution;

//309. Best Time to Buy and Sell Stock with Cooldown
public class Solution309 {

    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0 || prices.length == 1)
    		return 0;
        
    	int[] hold = new int[prices.length + 1];
    	int[] notHold = new int[prices.length + 1];
    	hold[0] = Integer.MIN_VALUE;
    	notHold[0] = 0;
    	hold[1] = -prices[0];
    	notHold[1] = 0;
    	
    	for (int i = 2; i <= prices.length; i++) {
    		//今天持有:
    		//		1.前天不持有，今天购买了
    		//		2.昨天持有
    		hold[i] = Math.max(notHold[i - 2] - prices[i - 1], hold[i - 1]);
    		//今天不持有：
    		//		1.今天卖出了
    		//		2.之前就卖出了
    		notHold[i] = Math.max(hold[i - 1] + prices[i - 1], notHold[i - 1]);
    	}
    	return notHold[prices.length];
    }
}
