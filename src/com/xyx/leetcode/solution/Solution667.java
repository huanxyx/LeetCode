package com.xyx.leetcode.solution;

//667. Beautiful Arrangement II
public class Solution667 {
	// 当n个数的时候，k最大只能为n-1，
	// k=n-1的情况为 1 (n) 2 (n-1) 3 (n-2) .....
	// k=1的情况为 1 2 3 4 5 6 7
	// 可以将数分为两个部分，一个部分（n-k-1）个数，满足从小到大（1 2 3 4 5...），序列相差1
	// 另一个部分（k+1）个数，（n-k n n-k+1 n-1 n-k+2 n-2... ）
    public int[] constructArray(int n, int k) {
    	int[] result = new int[n];
    	
    	int left = 1;
    	int right = n;

    	int leftTotal = n - k - 1;
    	for (int index = 0; index < n; index++) {
    		if (index < leftTotal) 
    			result[index] = left++;
    		else 
    			result[index] = ((index-leftTotal) % 2 == 0) ? left++ : right--;
    	}
    	
        return result;
    }
}
