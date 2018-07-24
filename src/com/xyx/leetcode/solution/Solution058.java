package com.xyx.leetcode.solution;

//58. Length of Last Word
public class Solution058 {

    public int lengthOfLastWord(String s) {
        char[] sArr = s.toCharArray();
        
        int len = 0;
        
        int pos = sArr.length - 1;
        while (pos >= 0 && sArr[pos] == ' ')
        	pos--;
        while (pos >= 0 && sArr[pos] != ' ') {
        	len++;
        	pos--;
        }
        
        return len;
    }

}
