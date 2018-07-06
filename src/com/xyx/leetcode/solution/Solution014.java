package com.xyx.leetcode.solution;

import java.util.Arrays;

//14.Longest Common Prefix
public class Solution014 {

	/*
	 * 常规解法
	 */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
        	return "";
        
        //最短的字符串长度
        int len = Integer.MAX_VALUE;
        for (String str : strs)
        	len = Math.min(len, str.length());
        
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < len; i++) {
        	char curCh = strs[0].charAt(i);
        	for (int j = 1; j < strs.length; j++) {
        		if (curCh != strs[j].charAt(i))
        			return buffer.toString();
        	}
        	buffer.append(curCh);
        }
        return buffer.toString();
    }
    
    /*
     * 先排序
     */
    public String method_2(String[] strs) {
    	if (strs == null || strs.length == 0)
    		return "";
    	
    	Arrays.sort(strs);
    	StringBuilder buffer = new StringBuilder();
    	
    	char[] a = strs[0].toCharArray();
    	char[] b = strs[strs.length - 1].toCharArray();
    	
    	for (int i = 0; i < a.length; i++) {
    		if (i < b.length && a[i] == b[i])
    			buffer.append(a[i]);
    		else
    			break;
    	}
    	return buffer.toString();
    }

}
