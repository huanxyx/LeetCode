package com.xyx.leetcode.solution;

import java.util.Arrays;

//738. Monotone Increasing Digits
public class Solution738 {
	public int monotoneIncreasingDigits(int N) {
	    //转变成字符数组
	    char[] digits = (N + "").toCharArray();

	    //找到最后一个逆序点
	    int flag = digits.length;
	    for (int i = digits.length-2; i >= 0; i--) {
	        if (digits[i] > digits[i+1]) {
	            digits[i]--;
	            flag = i + 1;
	        }
	    }
		
	    //将最后一个逆序点右边的数都变成9
	    Arrays.fill(digits, flag, digits.length, '9');
	    return Integer.parseInt(new String(digits));
	}
	
	//更加容易理解的解法
	public int solution(int N) {
		char[] digits = (N + "").toCharArray();
		int last2 = digits.length - 2;
		
		int flag = digits.length;
		int left = 0;											//当前元素最左边的位置
		int cur = 0;											//遍历的当前位置
		while (cur <= last2) {
			if (digits[cur] < digits[cur+1]) {
				left = cur + 1;
				cur++;
			} else if (digits[cur] == digits[cur+1]) {
				left = cur;
				while (cur <= last2 && digits[cur] == digits[cur+1])
					cur++;
			} else {											
				//若是当前元素大于下一个元素，那么则将当前元素在序列中的第一个位置右边的数全变成9
				flag = left + 1;
				digits[left]--;
				break;
			}
		}
		Arrays.fill(digits, flag, digits.length, '9');
		return Integer.parseInt(new String(digits));
	}
}
