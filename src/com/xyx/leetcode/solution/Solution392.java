package com.xyx.leetcode.solution;

//392. Is Subsequence
public class Solution392 {

    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        int sInd = 0;
        int tInd = 0;
        
        while (sInd < sArr.length && tInd < tArr.length) {
        	if (sArr[sInd] == tArr[tInd]) 
        		sInd++;
        	tInd++;
        }
        
        return sInd == s.length();
    }

}
