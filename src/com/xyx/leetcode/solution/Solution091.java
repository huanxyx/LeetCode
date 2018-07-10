package com.xyx.leetcode.solution;

//91. Decode Ways
public class Solution091 {

	/*
	 * 注意：
	 * 		0不能单独构成一个字母
	 * 		02不能构成一个字母
	 * 
	 */
    public int numDecodings(String s) {
    	if (s == null || s.length() == 0)
    		return 0;
    	
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;																		//用作dp[2] += dp[0]的初始条件
        
        if (canIndependent(s.charAt(0)))
        	dp[1] = 1;
        
        for (int i = 2; i <= s.length(); i++) {
        	if (canCombination(s.charAt(i - 2), s.charAt(i - 1)))						//2个字符能组合起来构成一个字母
        		dp[i] += dp[i - 2];
        	if (canIndependent(s.charAt(i - 1)))										//这个字符能否单独构成一个字母
        		dp[i] += dp[i - 1];
        }
        
        return dp[s.length()];
    }
    
    //判断这个字符能否单独构成一个字母
    public boolean canIndependent(char ch) {
    	return '1' <= ch && ch <= '9';
    }
    
    //判断2个字符能否组合起来构成一个字母
    public boolean canCombination(char pre, char cur) {
    	if (pre == '0')
    		return false;
    	
    	int t = translate(pre) * 10 + translate(cur);
    	return t >= 1 && t <= 26;
    }
    
    public int translate(char ch) {
    	return ch - '0';
    }

}
