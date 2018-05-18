package com.xyx.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

//824. Goat Latin
public class Solution824 {
    public String toGoatLatin(String S) {
        StringBuilder buffer = new StringBuilder();
        
        String[] words = S.split(" ");
        int count = 1;
        for (String word : words) {
        	if (beginWithVowel(word)) {
        		buffer.append(word);
        	} else {
        		buffer.append(word.substring(1));
        		buffer.append(word.substring(0, 1));
        	}
    		buffer.append("ma");
    		for (int i = 0; i < count; i++) 
    			buffer.append('a');
    		if (count != words.length)
    			buffer.append(' ');
    		count++;
        }
        return buffer.toString();
    }
    
    private Set<Character> vowel = new HashSet();
    {
    	for (char ch : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
    			vowel.add(ch);
    }

    
    private boolean beginWithVowel(String word) {
    	if (vowel.contains(word.charAt(0))) 
    		return true;
    	else 
    		return false;
    }
}
