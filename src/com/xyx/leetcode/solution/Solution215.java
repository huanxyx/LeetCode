package com.xyx.leetcode.solution;

import java.util.PriorityQueue;

// 215.Kth Largest Element in an Array
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        //保证优先队列中只有k个数，每次超过k个数的时候，将最小的删除
        for (int i = 0; i < nums.length; i++) {
        	pQueue.offer(nums[i]);
        	if (pQueue.size() > k)
        		pQueue.poll();
        }
        return pQueue.peek();
    }
}
