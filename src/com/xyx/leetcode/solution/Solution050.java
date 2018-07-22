package com.xyx.leetcode.solution;

//50. Pow(x, n)
public class Solution050 {

	/*
	 * 或者利用递归，将n规模变成n/2的规模
	 */
    public double myPow(double x, int n) {
    	//转换为长整型，是因为MIN变成正数会溢出
    	long absN = Math.abs((long)n);
        
    	double res = 1.0;
    	
    	//absN表示剩余的数
    	//x表示当前的系数
    	while (absN > 0) {
    		if ( (absN & 1) == 1 ) 
    			res *= x;
    		absN >>= 1;
    		x *= x;						//进位之后的系数
    	}
    	
        return n < 0 ? 1.0 / res : res;
    }	
}
