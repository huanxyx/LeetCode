package com.xyx.leetcode.solution;

//29. Divide Two Integers
public class Solution029 {

	/*
	 * 	1.若是可以使用乘法的时候，利用二分搜索
	 * 	2.若是使用减法来逼近值的话，那么时间复杂度很高
	 * 	3.当前实现为：dividend = divisor*2^k1 + divisor*2^k2 + ... + divisor*2^kn。找到k1到kn的所有值
	 */
    public int divide(int dividend, int divisor) {
        
    	//获取结果的符号
    	boolean positive = true; 
    	if (dividend < 0 && divisor > 0)
    		positive = false;
    	if (dividend > 0 && divisor < 0)
    		positive = false;
    	//除数为0的时候
    	if (divisor == 0)
    		return Integer.MAX_VALUE;
    	long dividendL = Math.abs((long)dividend);			//注意：-MIN_INTEGER越界了
    	long divisorL = Math.abs((long)divisor);
    	
    	long res = cal(dividendL, divisorL);
    	res = positive ? res : -res;
    	if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
    		return Integer.MAX_VALUE;
    	return (int) res;
    }
    
    public long cal(long dividend, long divisor) {
    	
    	long[] sum = new long[32];				//存储着divisor*2^(i)的结果
    	long[] mul = new long[32];				//存储着2^(i)的结果
    	sum[0] = divisor;
    	mul[0] = 1;
    	
    	//初始化表格，同时找到指数逼近的最大值max
    	int max = 1;
    	for (int i = 1; i < 32; i++) {
    		sum[i] = sum[i - 1] << 1;
    		mul[i] = mul[i - 1] << 1;
    		if (sum[i] >= dividend) {
    			max = i;
    			break;
    		}
    	}
    	
    	//求解
    	long res = 0;
    	for (int i = max; i >= 0 && dividend > 0; i--) {
    		if (dividend >= sum[i]) {
    			res += mul[i];
    			dividend -= sum[i];
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
		new Solution029().divide(-2147483648, -1);
	}
}
