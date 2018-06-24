package com.xyx.leetcode.solution;

//6.ZigZag Conversion
public class Solution006 {
	
	/*
	 * 简洁明了的实现方式
	 */
	public String convert(String s, int numRows) {
		if (numRows < 1)
			throw new IllegalArgumentException();
		
		//初始化buffer，buffers[i]用来存储i+1行的数据
		StringBuilder[] buffers = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) 
			buffers[i] = new StringBuilder();
		
		char[] strArr = s.toCharArray();
		int len = strArr.length;
		int cur = 0;
		
		while (cur < len) {
			for (int line = 0; line < numRows && cur < len; line++)			//从上往下遍历
				buffers[line].append(strArr[cur++]);		
			for (int line = numRows-2; line >= 1 && cur < len; line--)		//从下网上遍历
				buffers[line].append(strArr[cur++]);
		}
		
		for (int i = 1; i < numRows; i++) 
			buffers[0].append(buffers[i]);
		
		return buffers[0].toString();
	}

	/*
	 * 找规律通过找规律实现
	 */
    public String convert2(String s, int numRows) {
    	if (numRows < 1)
    		throw new IllegalArgumentException();
        if (numRows == 1)
        	return s;
        
        int len = s.length();
        StringBuilder buffer = new StringBuilder();
        for (int line = 1; line <= numRows; line++) {
        	int cur = line - 1;
        	while (cur < len) {
        		buffer.append(s.charAt(cur));
        		int next = cur + (numRows - line) * 2;
        		if (line != 1 && line != numRows && next < len){
        			buffer.append(s.charAt(next));
        		}
        		cur += (numRows - 1) * 2;
        	}
        }
        return buffer.toString();
    }

}
