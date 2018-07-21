package com.xyx.leetcode.solution;

//43.Multiply Strings
public class Solution043 {

	/*
	 * 求解两个字符串数相乘：
	 * 第i位与第j位相乘的结果在i+j位上，
	 * 2个不超过9的数相乘的结果肯定小于2位，
	 */
    public String multiply(String num1, String num2) {
    	if ("0".equals(num1) || "0".equals(num2))
    		return "0";
    	
    	int[] number1 = convert(num1);
    	int[] number2 = convert(num2);
    	int n1 = number1.length;
    	int n2 = number2.length;
    	
    	int n = n1 + n2 - 1;
    	int[] res = new int[n];
    	for (int i = 0; i < n1; i++) {
    		for (int j = 0; j < n2; j++) {
    			res[i + j] += number1[i] * number2[j];
    		}
    	}
    	
    	StringBuilder buf = new StringBuilder();
    	for (int i = 0; i < n - 1; i++) {
    		if (res[i] > 9) {
    			res[i + 1] += res[i] / 10;
    			res[i] = res[i] % 10;
    		}
    		buf.append(res[i]);
    	}
    	
    	return res[n - 1] + buf.reverse().toString();
    }
    
    /*
     * 将字符串表示的数利用逆序的数组表示
     */
    public int[] convert(String str) {
    	int len = str.length();
    	int[] res = new int[len];
    	
    	for (int i = 0; i < len; i++) {
    		res[len - i - 1] = str.charAt(i) - '0';
    	}
    	return res;
    }
 
    
    public static void main(String[] args) {
		System.out.println(new Solution043().multiply("123", "456"));
	}
}
