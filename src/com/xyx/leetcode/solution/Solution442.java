package com.xyx.leetcode.solution;

import java.util.LinkedList;
import java.util.List;

//442. Find All Duplicates in an Array
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
    	/*int[] count = new int[nums.length + 1];
    	for (int i = 0; i < nums.length; i++) 
    		count[nums[i]]++;
    	
        List<Integer> list = new LinkedList<Integer>();
    	for (int i = 1; i < count.length; i++) {
    		if (count[i] == 2) 
    			list.add(i);
    	}
        return list;
        */
    	// 没有额外空间，且O(n)的运行时间
    	// 因为每个元素的大小都不超过数组的大小（1...n），且每个元素最多只有两个
    	// 可以将原数组中指定下标位置的数值取相反数，代表着已经出现该下标的数了。
    	// 因此就可以判断该重复的数
    	List<Integer> list = new LinkedList<Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		int pos = Math.abs(nums[i]) - 1;
    		nums[pos] = -nums[pos];
    		if (nums[pos] > 0)
    			list.add(Math.abs(nums[i]));
    	}
    	return list;
    }
}
