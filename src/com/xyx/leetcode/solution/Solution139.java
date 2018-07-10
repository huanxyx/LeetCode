package com.xyx.leetcode.solution;

import java.util.HashSet;
import java.util.List;

//139. Word Break
public class Solution139 {

	/*
	 * 状态：dp[i]记录着字符串0-i-1是否符合条件
	 * 状态转移：dp[i] = dp[j] && s.substring(j, i)
	 * 前j个字符满足条件，而且，j到i的子字符串又是单词字典中的一部分，则0...i的子字符串就满足条件
	 * 
	 */
    public boolean wordBreak(String s, List<String> wordDict) {
    	
    	HashSet<String> set = new HashSet<String>(wordDict);
    	boolean[] dp = new boolean[s.length() + 1];
    	dp[0] = true;
    	
    	for (int end = 1; end <= s.length(); end++) {
    		for (int start = end-1; start >= 0; start--) {					
    			//从尾到头，因为只要找到一个子字符串满足构成单词的条件就行了
    			if (dp[start] && set.contains(s.substring(start, end))) {
    				dp[end] = true;
    				break;
    			}
    		} 
    	}
    	return dp[s.length()];
    }

}
