package com.xyx.leetcode.solution;

//38. Count and Say
public class Solution038 {

    public String countAndSay(int n) {
        if (n == 1)
        	return "1";
        String res = "1";
        for (int i = 2; i <= n; i++) {
        	res = next(res);
        }
        return res;
    }
    
    public String next(String str) {
    	char[] sArr = str.toCharArray();
    	int cur = 0;
    	
    	StringBuilder buffer = new StringBuilder();
    	while (cur < sArr.length) {
    		char curChar = sArr[cur];
    		int count = 1;
    		while (++cur < sArr.length && sArr[cur] == curChar) 
    			count++;
    		buffer.append ("" + count + curChar);
    	}
    	
    	return buffer.toString();
    }

}
