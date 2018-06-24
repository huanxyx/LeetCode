package com.xyx.leetcode.solution;

//4.Median of Two Sorted Arrays
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalNum = nums1.length + nums2.length;
        int[] totalArr = new int[nums1.length+nums2.length];
        
        int currentPos = 0;
        int n = 0;
        int m = 0;

        while(n < nums1.length && m < nums2.length) {
            if (nums1[n] < nums2[m]){
                totalArr[currentPos++] = nums1[n++];
            } else {
                totalArr[currentPos++] = nums2[m++];
            }
        }
        while (n < nums1.length) {
            totalArr[currentPos++] = nums1[n++];

        }
        while (m < nums2.length) {
            totalArr[currentPos++] = nums2[m++];
        }
        
        if (totalNum % 2 == 0) 
            return (totalArr[totalNum/2 - 1] + totalArr[totalNum/2]) / 2.0;
        return totalArr[totalNum/2];
        
    }
}
