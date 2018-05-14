package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
 
// 39.Combination Sum
public class Solution39 {
	//利用回溯法求解该问题
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	getResult(candidates, result, new ArrayList<>(), target, 0);
    	return result;
    }

    //start的作用：确定遍历开始的位置，可以缩小遍历范围，以及避免重复解。
    //remain的作用：存储剩余多少数。若是正好等于0，则表示当前temp里面的数满足条件。
	private void getResult(int[] candidates, List<List<Integer>> result, List<Integer> temp, int remain, int start) {
		if (remain < 0)
			return ;
		else if (remain == 0)
			result.add(new ArrayList<>(temp));
		else {
			for (int i = start; i < candidates.length; i++) {
				temp.add(candidates[i]);
				getResult(candidates, result, temp, remain-candidates[i], i);
				temp.remove(temp.size()-1);
			}
		}
	}
}
