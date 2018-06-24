package com.xyx.leetcode.solution;

//88.Merge Sorted Array
public class Solution088 {
	
	/*
	 * 从大往小遍历，因为只有位置大的空间没有被使用，
	 * 所以就需要先使用后面的空间，就是从大到小排。
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int point1 = m - 1;
    	int point2 = n - 1;
    	int cur = m + n - 1;
    	while (point1 >= 0 && point2 >= 0) {
    		if (nums1[point1] > nums2[point2]) {
    			nums1[cur--] = nums1[point1--];
    		} else {
    			nums1[cur--] = nums2[point2--];
    		}
    	}
    	//不用管nums1里面剩下的数，因为他们已经是排好序的。
        while (point2 >= 0)
        	nums1[cur--] = nums2[point2--];
        
    }
}
