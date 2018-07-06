package com.xyx.leetcode.solution;

//8. String to Integer
public class Solution008 {

	/*
	 * 溢出情况的处理方式：
	 * 			1.使用更大表示范围的类型：double，最后再判断是否溢出
	 * 			2.每次获取新的位数的时候判断是否溢出
	 */
    public int myAtoi(String str) {
    	if (str == null || str.length() == 0)
    		return 0;
    	
    	char[] strArr = str.toCharArray();
    	
    	//过滤掉前缀空格
    	int cur = 0;
    	while (cur < strArr.length && strArr[cur] == ' ')
    		cur++;
    	//获取正负
    	boolean positive = true;
    	if (cur < strArr.length) {
    		if (strArr[cur] == '+')
    			cur++;
    		else if (strArr[cur] == '-') {
    			cur++;
    			positive = false;
    		}
    	}
    	
    	int result = 0;
    	//将字符串转换为整数
		while (cur < strArr.length && isDigit(strArr[cur])) {
			int curDigit = strArr[cur++] - '0';
			//溢出情况处理
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && curDigit > Integer.MAX_VALUE % 10))
				return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			result *= 10;
			result += curDigit;
		}
		result = positive ? result : -result;

    	return result;
    }
    
    //判断一个字符是否为数字
    private static boolean isDigit(char ch) {
    	return ch >= '0' && ch <= '9';
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution008().myAtoi("9223372036854775808"));
	}

}
