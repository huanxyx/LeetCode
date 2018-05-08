package com.xyx.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

//560.Subarray Sum Equals K
public class Solution560 {
	public int subarraySum(int[] sums, int k) {
		// 优化求法
		//map存储总和的频率
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		
		int count = 0;
		int sum = 0;		
		//i..j的和为k，那么0..j的和sum 减去 k就为0到i-1的和
		for (int pos = 0; pos < sums.length; pos++) {
			sum += sums[pos];
			if (map.containsKey(sum-k))
				count += map.get(sum-k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		
		return count;
		
/*		// 简单求法
		//sum数组用来存储前i-1项的和
		int[] sum = new int[sums.length+1];
		sum[0] = 0;
		for (int i = 1; i <= sums.length; i++) {
			sum[i] = sum[i-1] + sums[i-1];
		}
		
		int count = 0;
		for (int start = 0; start < sums.length; start++) {
			for (int end = start; end < sums.length; end++) {
				// 获取start到end的和
				if (sum[end+1] - sum[start] == k) {	
					count++;
				}
			}
		}
		return count;*/
	}
}	
