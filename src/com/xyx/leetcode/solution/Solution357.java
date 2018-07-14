package com.xyx.leetcode.solution;

//357. Count Numbers with Unique Digits
public class Solution357 {

	/*
	 * 0-9中：10个
	 * 10-99中：9*9个
	 * 100-999中：9*9*8个
	 * 1000-9999中：9*9*8*7个
	 */
    public int countNumbersWithUniqueDigits(int n) {
    	if (n == 0)
    		return 1;
    	int res = 10;
    	int count = 9;
    	for (int i = 2; i <= n; i++) {
    		count *= (11 - i);
    		res += count;
    	}
        return res;
    }
}
