package com.xyx.leetcode.solution;

//76. Minimum Window Substring 
public class Solution076 {
	
	/*
	 * 先利用一个hash表记录当前状态下各个字符缺失的个数，为负数则表示是由多余的
	 * 同时利用一个变量记录总的缺失个数
	 * 再遍历目标字符串，当确实的字符为0的时候，从start到当前能够包含t
	 * 再从start往end遍历，直到不能包含t的时候，
	 * 不断地重复以上动作，记录能够包含t地最小长度的位置
	 */
    public String minWindow(String s, String t) {

    	int[] needMap = new int[128];
    	for (int i = 0; i < t.length(); i++) needMap[t.charAt(i)]++;
    	int allNeed = t.length();
    	
    	//遍历s字符串，直到不再缺失字符
    	int end = 0;
    	int start = 0;
    	int minLen = Integer.MAX_VALUE;
    	int minHead = 0;
    	while (end < s.length()) {
    		//当当前字符是必要的，则总的需要字符数减一
    		if (--needMap[s.charAt(end)] >= 0)
    			allNeed--;
    		
    		//若是不需要新的字符，已经能够构成包含t的子字符串的时候,从
    		while (allNeed == 0) {
    			//更新window
    			if (end - start + 1 < minLen) {
    				minLen = end - start + 1;
    				minHead = start;
    			}
    			if (++needMap[s.charAt(start)] == 1)
    				allNeed++;
    			start++;
    		}
    		end++;
    	}
    	
    	return minLen == Integer.MAX_VALUE ? "" : s.substring(minHead, minHead + minLen);
    }

}
