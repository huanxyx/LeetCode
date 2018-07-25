package com.xyx.leetcode.solution;

import java.util.LinkedList;

//60. Permutation Sequence
public class Solution060 {

	/*
	 * 第n位为1的情况有(n-1)!种，第n位为2的情况也有(n-1)!...
	 * 在第n位的数已经确定的情况下来考虑剩余的数以及第n-1位
	 */
    public String getPermutation(int n, int k) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	StringBuilder builder = new StringBuilder();
    	
    	//构建阶乘表，减少运算
    	int[] sum = new int[n + 1];
    	sum[0] = 1;
    	for (int i = 1; i <= n; i++) {
    		sum[i] = sum[i - 1] * i;
    		list.add(i);
    	}
    	//注意
    	k--;

    	while (list.size() != 0) {
    		//找到当前位置应该放的数，若是为0，则意味着放剩余最小的数
    		int num = k / sum[list.size() - 1];
    		k = k % sum[list.size() - 1];
    		builder.append(list.remove(num));
    	}
    	
    	return builder.toString();
    }
}
