package com.xyx.leetcode.solution;

//338. Counting Bits
public class Solution338 {
    public int[] countBits(int num) {
    	int[] result = new int[num + 1];
    	// 若是i = b10101011
    	// 则i/2 = b01010101
    	// 而i&1 = 1表示的是i的第一位
    	// 而其他位1的个数之前就已经求解出来了为result[i/2]
    	for (int i = 1; i <= num; i++)
    		result[i] = result[i/2] + (i & 1);
    	return result;
    }
    
    private int[] solution1(int num) {
    	int[] result = new int[num + 1];
    	for (int i = 1; i <= num; i++)
    		/*
    		 * 若是i-1到i没有发生进位也就是类似：1000到1001则答
    		 * 案是result[i] = result[i-1] + 1
    		 * 若是i-1到i发生了进位也就是类似：1001到1010则答案
    		 * 是result[i] = result[i - 2] + 1，其中2=b10
    		 * 也就有result[i] = result[i&(i-1)] + 1
    		 *  
    		 */
    		result[i] = result[i & (i-1)] + 1;
    	return result;
    }
}
