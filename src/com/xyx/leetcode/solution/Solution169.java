package com.xyx.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//169. Majority Element
public class Solution169 {
    public int majorityElement(int[] nums) {
    	return solution1(nums);
    }
    
    
    /*
     * 摩尔投票法Boyer-Moore Voting
     * 		前提：一定有一个人的票数超过半数，意味着支持票-反对票>0
     * 		
     * 		算法：当出现一个不是当前候选数字的时候count-1,
     * 			   当出现一个是当前候选数字的时候count+1,
     * 			   当count == 0的时候，意味着当前候选人不为真正的候选人,
     *  		   因为他的票数不能超过半数	
     */
    private int solution1(int[] nums) {
    	int candidate = 0;		//候选人
    	int count = 0;			//票数
    	for (int num : nums) {
    		if (count == 0)
    			candidate = num;
    		count += (num == candidate) ? 1 : -1;
    	}
    	return candidate;
    }
    
    //利用Hash存储每个数出现的次数
    private int solution2(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int num : nums) {
    		if (!map.containsKey(num))
    			map.put(num, 1);
    		else 
    			map.put(num, map.get(num) + 1);
    		if (map.get(num) > nums.length / 2)
    			return num;
    	}
    	return 0;
    }
    
    //排序解法
    //另一种求法，直接求出应该在nums.length/2位置的元素是什么(partition)
    private int solution3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    //分而治之
    private int solution4(int[] nums) {
    	return majorityElement(nums, 0, nums.length-1);
    }
    
    private int majorityElement(int[] nums, int low, int hig) {
    	if (low == hig)
    		return nums[low];
    	int mid = (hig + low) / 2;
    	//计算左右两个部分各自数量最多的数
    	int left = majorityElement(nums, low, mid);
    	int right = majorityElement(nums, mid+1, hig);
    	
    	if (left == right)
    		return left;
    	
    	int leftCount = getCount(nums, low, hig, left);
    	int rightCount = getCount(nums, low, hig, right);
    	return leftCount > rightCount ? left : right;
    }
    
    private int getCount(int[] nums, int low, int hig, int m) {
    	int count = 0;
    	for (int i = low; i <= hig; i++) {
    		if (nums[i] == m)
    			count++;
    	}
    	return count;	
    }
    
    //二进制求法
    private int solution5(int[] nums) {
    	int HALF = nums.length / 2;
    	int majority = 0;
    	for (int i = 0; i < 32; i++) {
    		int mask = 1 << i;
    		int count = 0;
    		for (int num : nums)
    			if ((num & mask) != 0) count++;
    		if (count > HALF) majority ^= mask; 
    	}
    	return majority;
    }
}
