package com.xyx.leetcode.solution;

//413. Arithmetic Slices
public class Solution413 {

	/*
	 * 状态：以第n个位置的数字结束的序列能够构成的算术序列的数目
	 * 状态转移：若是当前位置，前一个位置，前前一个位置能够构成算术序列，那么dp[i] = dp[i-1] + 1
	 */
    public int numberOfArithmeticSlices(int[] A) {
    	if (A == null || A.length < 3)
    		return 0;
        
    	int sum = 0;
    	int cur = 0;
    	for (int i = 2; i < A.length; i++) {
    		if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
    			cur += 1;
    			sum += cur;
    		} else 
    			cur = 0;
    	}
    	return sum;
    }

}
