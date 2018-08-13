package com.xyx.leetcode.solution;

//136. Single Number
public class Solution136 {
    public int singleNumber(int[] nums) {
        int target = 0;
        for (int num : nums)
            target = target ^ num;
        return target;
    }
}
