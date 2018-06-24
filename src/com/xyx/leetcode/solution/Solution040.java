package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 40.Combination Sum II
public class Solution040 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		getResult(candidates, target, 0, list, new ArrayList<>());
		return list;
	}
	
	private void getResult(int[] candidates, 
			int target, int start, List<List<Integer>> list, List<Integer> temp) {
		 if (target == 0) {
			 list.add(new ArrayList<>(temp));
		 } else if (target > 0) {
			 //因为是已经排好序的序列
			 //所以当放入当前值不符合要求的时候，就无需考虑之后的部分了。
			 for (int i = start; i < candidates.length && target-candidates[i] >= 0; i++) {
				 //考虑过当前元素了之后就不用再考虑相同的元素了，为了避免重复解
				 if (i > start && candidates[i] == candidates[i-1])
					 continue;
				 temp.add(candidates[i]);
				 getResult(candidates, target - candidates[i], i+1, list, temp);
				 temp.remove(temp.size()-1);
			 }
		 }
	}
}
