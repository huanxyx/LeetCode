package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//638. Shopping Offers
public class Solution638 {

	/*
	 * DFS+记忆化搜索：当前的needs为键
	 */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    	table = new HashMap<List<Integer>, Integer>();
    	return recursSolv(price, special, needs);
    }

    public HashMap<List<Integer>, Integer> table;
    public int recursSolv(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    	if (table.containsKey(needs))
    		return table.get(needs);
    	
    	int res = notUseOffer(price, needs);
    	
    	for (List<Integer> spe : special) {
        	//使用一个优惠
    		if(canBuy(spe, needs)) {
    			List<Integer> copy = new ArrayList<Integer>(needs);
    			int money = buyOrNotBuy(price, spe, copy);					//购买的金额
    			money += recursSolv(price, special, copy);					//剩余的情况下
    			res = Math.min(res, money);
    		}
    	}
    	
    	table.put(needs, res);
    	return res;
    }
    
    //计算不使用优惠花费的money
    public int notUseOffer(List<Integer> price, List<Integer> needs) {
    	int sum = 0;
    	for (int i = 0; i < needs.size(); i++) 
    		sum += price.get(i) * needs.get(i);
    	return sum;
    }
    
    //使用当前优惠之后的需求数量
    public int buyOrNotBuy(List<Integer> price, List<Integer> special, List<Integer> needs) {
    	for (int i = 0; i < needs.size(); i++) 
    		needs.set(i, needs.get(i) - special.get(i));
    	return special.get(special.size() - 1);
    }
    
    //判断是否能够购买当前的优惠
    public boolean canBuy(List<Integer> special, List<Integer> needs) {
    	for (int i = 0; i < needs.size(); i++) {
    		if (special.get(i) > needs.get(i))
    			return false;
    	}
    	return true;
    }
}
