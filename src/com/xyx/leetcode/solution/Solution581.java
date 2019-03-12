package com.xyx.leetcode.solution;

//581. Shortest Unsorted Continuous Subarray
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        //避免一直是递增的情况。
        int end = -2, begin = -1;
        int leftMax = nums[0], rightMin = nums[nums.length - 1];

        //从左往右，找到最右边的小于左边最大值的位置
        for (int i = 1; i < nums.length; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if (nums[i] < leftMax)
                end = i;
        }
        //从右往左，找到最左边的大于右边最小值的位置
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMin = Math.min(rightMin, nums[i]);
            if (nums[i] > rightMin)
                begin = i;
        }
        return end - begin + 1;
    }
}
