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
    
    /*
     * 动态规划实现
     */
    public boolean isMatch_2(String s, String p) {
    	if (s == null || p == null)
    		return false;
    	
    	//状态
    	boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    	//初始状态
    	//边界赋值
    	dp[0][0] = true;
    	//
    	for (int i = 1; i < p.length(); i++) {
    		if (p.charAt(i) == '*')
    			dp[0][i+1] = dp[0][i-1]; 
    	}
    	//状态转移，由于每一层的某个状态能够通过上一层和这一层的状态得到，所以可以将空间复杂度降低为2*N，其中N表示正则匹配字符串的长度
    	for (int sCur = 0; sCur < s.length(); sCur++) {								//控制字符串的长度
    		for (int pCur = 0; pCur < p.length(); pCur++) {							//控制匹配字符串的长度
    			if (p.charAt(pCur) == '*') {
    				if (s.charAt(sCur) == p.charAt(pCur - 1) || p.charAt(pCur - 1) == '.')
    					dp[sCur + 1][pCur + 1] = dp[sCur][pCur - 1] || 				//一个*号换一个
    										dp[sCur][pCur + 1] ||					//一个*号换多个
    											dp[sCur + 1][pCur - 1];				//一个*号不换
    				else
    					dp[sCur + 1][pCur + 1] = dp[sCur + 1][pCur - 1];
    			} else if (p.charAt(pCur) == '.' || p.charAt(pCur) == s.charAt(sCur))
    				dp[sCur + 1][pCur + 1] = dp[sCur][pCur];
    		}
    	}
    	
    	return dp[s.length()][p.length()];
    }
}
