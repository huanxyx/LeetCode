package com.xyx.leetcode.solution;

//10.Regular Expression Matching
public class Solution010 {
	
	/*
	 * 方法一：递归实现
	 */
    public boolean isMatch(String s, String p) {
    	return isMatch_1(s, p);
    }
    
    /*
     * 递归实现
     */
    public boolean isMatch_1(String s, String p) {
    	if (s == null || p == null)
    		return false;
    	
        char[] strArr = s.toCharArray();
        char[] patArr = p.toCharArray();
    	
    	return matcher(strArr, 0, patArr, 0);
    }

    private static boolean matcher(char[] strArr, int strCur, char[] patArr, int patCur) {
    	if (strCur == strArr.length && patCur == patArr.length)			//同时遍历完了
    		return true;
    	if (strCur != strArr.length && patCur == patArr.length)			//匹配模式遍历完了，字符串还没有遍历完
    		return false;
    	
    	if (patCur + 1 < patArr.length && patArr[patCur + 1] == '*') {
    		if (strCur < strArr.length && (patArr[patCur] == '.' || patArr[patCur] == strArr[strCur])) {
    			return matcher(strArr, strCur, patArr, patCur + 2) || 
    					matcher(strArr, strCur + 1, patArr, patCur) ||
    					matcher(strArr, strCur + 1, patArr, patCur + 2);
    		} else
    			return matcher(strArr, strCur, patArr, patCur + 2);
    	} 
    	
    	if (strCur < strArr.length && (patArr[patCur] == '.' || patArr[patCur] == strArr[strCur]))
   			return matcher(strArr, strCur + 1, patArr, patCur + 1);
    	
    	return false;
    }
}
