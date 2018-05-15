package com.xyx.leetcode.solution;

// 66.Plus One
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int curBit = digits.length-1;
        int carry = 1;
        while (curBit >= 0 && carry == 1) {
        	if (digits[curBit] != 9) {
        		digits[curBit]++;
        		return digits;
        	} else {
	        	digits[curBit] = 0;
	        	curBit--;
        	}
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
    	return result;
    }
}
