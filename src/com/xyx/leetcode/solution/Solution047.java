package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//47. Permutations II
public class Solution047 {

	/*
	 * 1. 全排列，找到一个数，判断是否符合，符合则加入的集合中
	 * 2. 借助Set去重（费空间）
	 */
    public List<List<Integer>> permuteUnique(int[] nums) {
    	return solution_1(nums);
    }
    
    /*
     * 将结果逐一添加到中间集中（需要排序将相同的数放在一块）
     */
    private List<List<Integer>> solution_1(int[] nums) {
    	Arrays.sort(nums);
    	
    	boolean[] used = new boolean[nums.length];
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> permutations = new ArrayList<Integer>();
    	
    	findAll_1(nums, used, res, permutations);
    	return res;
    }
    
    private void findAll_1(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> permutations) {
    	if (permutations.size() == nums.length) 
    		res.add(new ArrayList<Integer>(permutations));
    	else {
    		for (int i = 0; i < nums.length; i++) {
    			if (used[i])
    				continue;
    			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])		//当前考虑的元素已经在当前位置考虑过了
    				continue;
    			permutations.add(nums[i]);
    			used[i] = true;
    			findAll_1(nums, used, res, permutations);
    			used[i] = false;
    			permutations.remove(permutations.size() - 1);
    		}
    	}
    }
    
    
    /*
     * 借助Set去重(消耗更多的空间)
     */
    private List<List<Integer>> solution_2(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
        	return res;
        findAll_2(nums, 0, res);
        return res;
    }

    
    private void findAll_2(int[] nums, int cur, List<List<Integer>> res) {
    	if (cur == nums.length)
    		res.add(generateList(nums));
    	else {
    		//使用一个Set记录当前位置是否出现过当前应该放的字符
    		HashSet<Integer> set = new HashSet<Integer>();
    		for (int i = cur; i < nums.length; i++) {
    			if (set.add(nums[i])) {
    				swap(nums, cur, i);
    				findAll_2(nums, cur + 1, res);
    				swap(nums, cur, i);
    			}
    		}
    	}
    }
    
    private List<Integer> generateList(int[] nums) {
    	ArrayList<Integer> res = new ArrayList<Integer>(nums.length);
    	for (int num : nums)
    		res.add(num);
    	return res;
    }
    
    private void swap(int[] nums, int a, int b) {
    	int t = nums[a];
    	nums[a] = nums[b];
    	nums[b] = t;
    }

}
