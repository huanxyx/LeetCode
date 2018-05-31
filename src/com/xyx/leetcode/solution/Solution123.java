package com.xyx.leetcode.solution;

// 123.Best Time to Buy and Sell Stock III
public class Solution123 {
	
	/*
	 * 存储买进的最小金额
	 */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;			//第一次买所话的钱（取最小）
        int maxProfit1 = 0;						//第一次卖出所赚的最大利润
        int buy2 = Integer.MAX_VALUE;			//在第一个卖出的基础上第二买所花的钱（取最小）
        int maxProfit2 = 0;						//第二次卖出所赚的最大利润（包括了第一次卖出所赚的）
        
        for (int price : prices) {
        	 if (price < buy1) buy1 = price;
        	 if (price - buy1 > maxProfit1) maxProfit1 = price - buy1;
        	 if (price - maxProfit1 < buy2) buy2 = price - maxProfit1;
        	 if (price - buy2 > maxProfit2) maxProfit2 = price - buy2;
        }
        
        return maxProfit2;
    }
    
    /*
     *  更好理解：
     *  	假设一开始没有任何现金，购买会使本金减少，卖出会使本金增加
     */
    private int solution1(int[] prices) {
    	int buy1 = Integer.MIN_VALUE;			//第一次购买后所拥有的最大本金
    	int buy2 = Integer.MIN_VALUE;			//第二次购买后所拥有的最大本金
    	int sell1 = 0;							//第一次卖出后所拥用的最大本金
    	int sell2 = 0;							//第二次卖出后所拥有的最大本金
    	for (int price : prices) {
    		buy1 = Math.max(buy1, -price);					//购买当前的股票会使本金减少（第一次交易：买进）
    		sell1 = Math.max(sell1, price + buy1);			//卖出当前的股票会使本金增减（第一次交易：卖出）
    		buy2 = Math.max(buy2, sell1 - price);			//购买当前的股票会使本金减少（第二次交易：买进）
    		sell2 = Math.max(sell2, buy2 + price);			//卖出当前的股票会使本金增加（第二次交易：卖出）
    	}
    	return sell2;
    }
    
    /*
     * 数组表示，状态矩阵
     */
    private int solution2(int[] prices) {
    	if (prices.length == 0)
    		return 0;
    	//dp[i][j]前j天最多交易i次获取的最大利润
    	int[][] dp = new int[2][prices.length];		
    	
    	int minPrice = prices[0];
    	for (int i = 1; i < prices.length; i++) {
    		minPrice = Math.min(minPrice, prices[i]);
    		dp[0][i] = Math.max(dp[0][i - 1], prices[i] - minPrice);		
    	}
    	
    	minPrice = prices[0] - dp[0][0];							//代表最低购买价格
    	for (int i = 1; i < prices.length; i++) {
    		minPrice = Math.min(minPrice, prices[i] - dp[0][i]);	//买进的最低价格，因为是计算第二次的交易，所以需要减去第一次交易的最大利润
    		dp[1][i] = Math.max(dp[1][i - 1], prices[i] - minPrice);	
    	}
    	return dp[1][prices.length-1];
    }
}
