package com.xyx.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

//1.Two Sum(complement:补数)
public class Solution1 {

	public int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement))
				return new int[] {i, map.get(complement)};
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
}
