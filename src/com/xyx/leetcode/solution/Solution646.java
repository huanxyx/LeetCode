package com.xyx.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

//646. Maximum Length of Pair Chain
public class Solution646 {


    public int findLongestChain(int[][] pairs) {
    	return solution_2(pairs);
    }
    
	/*
	 * 状态：dp[i]表示到第i个tuple为止最长数链的长度
	 */
    public int solution_1(int[][] pairs) {
        if (pairs == null)
        	return 0;
        Arrays.sort(pairs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
        
        int[] dp = new int[pairs.length];
    	int res = 0;
        for (int i = 0; i < pairs.length; i++) {
       		dp[i] = 1;
        	for (int j = 0; j < i; j++) {
        		if (pairs[j][1] < pairs[i][0])
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        	}
        	res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    /*
     * 贪心：按照结束时间排序，后面结束的不可能在前面的前面
     */
    public int solution_2(int[][] pairs) {
    	if (pairs == null || pairs.length == 0)
    		return 0;
    	
    	Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
    	
    	int cur = pairs[0][1];
    	int len = 1;
    	for (int i = 1; i < pairs.length; i++) {
    		if (cur < pairs[i][0]) {
    			cur = pairs[i][1];
    			len++;
    		}
    	}
    	return len;
    }

}
