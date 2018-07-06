package com.xyx.leetcode.solution;

//12. Integer to Roman
public class Solution012 {

	/*
	 * 使用表格表示每位的数
	 * 罗马数字的规律：
	 * 		右加左减：
	 * 				在一个较大的罗马数字的右边记上一个较小的罗马数字，表示大数字加小数字。
	 * 				在一个较大的数字的左边记上一个较小的罗马数字，表示大数字减小数字。
	 * 				但是，左减不能跨越一个位数。比如，99不可以用IC表示，而是用XCIX表示。
	 * 				此外，左减数字不能超过一位，比如8写成VIII，而非IIX。
	 * 				同理，右加数字不能超过三位，比如十四写成XIV，而非XIIII。
	 */
    public String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    	return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10];
    }

}
