package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//46. Permutations
public class Solution046 {

	/*
	 * 注意：利用Arrays.asList转换的得到的List会随着原数组内容的改变而改变
	 */
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	permuteSub(nums, 0, res);
    	return res;
    }
    
    private void permuteSub(int[] nums, int n, List<List<Integer>> res) {
    	if (n == nums.length) { 
    		res.add(cloneToList(nums));
    	} else {
    		for (int i = n; i < nums.length; i++) {
    			swap(nums, n, i);
    			permuteSub(nums, n + 1, res);
    			swap(nums, n, i);
    		}
    	}
    }
    
    private List<Integer> cloneToList(int[] nums) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	for (int num : nums)
    		res.add(num);
    	return res;
    }
    
    private void swap(int[] nums, int a, int b) {
    	int tmp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = tmp;
    }
    
    public static void main(String[] args) {
		new Solution046().permute(new int[] {1, 2, 3});
	}

}
