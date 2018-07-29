package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//78. Subsets
public class Solution078 {

    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	subsetsSub(nums, 0, new ArrayList<Integer>(), res);
        
    	return res;
    }
    
    private void subsetsSub(int[] nums, int cur, List<Integer> tmp, List<List<Integer>> res) {
    	res.add(new ArrayList<Integer>(tmp));

		//选择一个放入，当没有可以放入的时候终止
		for (int i = cur; i < nums.length; i++) {
			tmp.add(nums[i]);
			subsetsSub(nums, i + 1, tmp, res);
			tmp.remove(tmp.size() - 1);
		}
    }

}
