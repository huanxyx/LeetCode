package com.xyx.leetcode.solution;

//122. Best Time to Buy and Sell Stock II
public class Solution122 {
	
	//峰谷买进，峰顶卖出。
	//若是相邻峰谷峰顶之间存在多日，两者的差值=中间相邻每一天的差值和
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] > prices[i - 1]) {
        		maxProfit += prices[i] - prices[i - 1];
        	}
        }
        return maxProfit;
    }
    
    //山谷山峰，求差值
    private int solution(int[] prices) {
    	int maxProfit = 0;
    	int cur = 0;
    	while (cur < prices.length) {
    		int valley = prices[cur];		//山谷值
    		//找到山谷对应的右侧山峰
    		while (cur < prices.length-1 && prices[cur] <= prices[cur+1])
    			cur++;
    		int peek = prices[cur];			//山峰值
    		maxProfit += peek - valley;
    		cur++;
    	}
    	return maxProfit;
    }
}
