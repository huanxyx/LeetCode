package com.xyx.leetcode.solution;

import java.util.List;

// 120.Triangle
public class Solution120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
		int[] dp = new int[size + 1];		//大小需要更大一些，避免最后一行越界
		
        for (int i = size - 1; i >= 0; i--) {
        	List<Integer> line = triangle.get(i);
        	for (int j = 0; j < line.size(); j++)
        		dp[j] = Math.min(dp[j], dp[j+1]) + line.get(j);
        }
        return dp[0];
    }
}
