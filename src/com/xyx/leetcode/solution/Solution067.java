package com.xyx.leetcode.solution;

//67.Add Binary
public class Solution067 {

    public String addBinary(String a, String b) {
        StringBuilder buf = new StringBuilder();
        
        int carry = 0;
        int aIndex = a.length() - 1;			//a字符串的位置		
        int bIndex = b.length() - 1;			//b字符串的位置
        while (aIndex >= 0 || bIndex >= 0){
            int sum = carry;
        	if (aIndex >= 0) sum += a.charAt(aIndex--) - '0';
        	if (bIndex >= 0) sum += b.charAt(bIndex--) - '0';
        	buf.append(sum % 2);
        	carry = sum >> 1;
        }
        if (carry == 1)
        	buf.append(1);
        return buf.reverse().toString();
    }
}
