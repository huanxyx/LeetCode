package com.xyx.leetcode.solution;

// 45.Jump Game II
public class Solution045 {
	
	/*
	 * 贪婪算法:求出每步能够走到的最远距离
	 */
	public int jump(int[] nums) {
        int jumps = 0;
        int lastEnd = 0;
        int curEnd = 0;
        for (int i = 0; i < nums.length; ++i) {
        	//当前位置超过了jumps步能够跳到的最远位置时，jumps+1
            if (i > lastEnd) {
                lastEnd = curEnd;
                jumps++;
            }
            //存储着走到当前位置的过程中能够跳到的最远位置。
            curEnd = Math.max(curEnd, i+nums[i]);
        }
		
		return jumps;
	}
}
