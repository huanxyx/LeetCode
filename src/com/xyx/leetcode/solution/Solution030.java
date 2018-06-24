package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//30. Substring with Concatenation of All Words
public class Solution030 {
	
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (words.length == 0)
            return result;
        int wordLen = words[0].length();
        int wordNum = words.length;
        int windowLen = wordLen * wordNum;
        int strLen = s.length();
        int lastWordStart = strLen - wordLen;

        
        //将word的数量存入HashMap中
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for (String word : words) {
        	wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        for (int begin = 0; begin < wordLen; begin++) {
        	Map<String, Integer> existWordNum = new HashMap<String, Integer>();
        	int strStart = begin;
        	int count = 0;
        	for (int wordStart = begin; wordStart <= lastWordStart; wordStart += wordLen) {
        		if (strStart + windowLen > strLen)	break;
        		String word = s.substring(wordStart, wordStart + wordLen);
        		if (!wordMap.containsKey(word)) {
        			existWordNum.clear();
        			strStart = wordStart + wordLen;
        			count = 0;
        		} else {
        			if (wordStart == strStart + windowLen) {
        				String preWord = s.substring(strStart, strStart + wordLen);
        				strStart += wordLen;
        				existWordNum.put(preWord, existWordNum.get(preWord) - 1);
        				if (existWordNum.get(preWord) >= wordMap.get(preWord)) 
        					count--;
        			}
        			existWordNum.put(word, existWordNum.getOrDefault(word, 0) + 1);
        			
        			if (existWordNum.get(word) > wordMap.get(word)) 
        				count++;
        			if (count == 0 && strStart + windowLen == wordStart + wordLen)
        				result.add(strStart);
        		}
        	}
        }
        
        return result;
    }
    
    //O(n)的时间复杂度
    private List<Integer> solution1(String s, String[] words) {
    	List<Integer> result = new ArrayList<Integer>();
    	if (words.length == 0)
    		return result;
    	
    	int wordLen = words[0].length();
    	int wordCount = words.length;
    	int windowLen = wordLen * wordCount;											//能够形成满足条件的字符串长度（窗口）
    	int strLen = s.length();
    	int lastStart = strLen - wordLen;
											
    	
    	//计算每个单词出现的次数
    	Map<String, Integer> wordNums = new HashMap<String, Integer>();
    	for (String word : words) 
    		wordNums.put(word, wordNums.getOrDefault(word, 0) + 1);
    	
    	//遍历的起始位置
    	for (int offset = 0; offset < wordLen; offset++) {
    		Map<String, Integer> curWordNums = new HashMap<String, Integer>();			//当前已经有的word的数量
    		int count = 0;																//匹配的数量
    		int start = offset;
    		for (int j = offset; j <= lastStart; j += wordLen) {
    			//当以当前start开始的字串不足以满足条件，则直接终止循环。
    			if (start + windowLen > strLen) break;		
    			String curWord = s.substring(j, j + wordLen);
    			//重置（新出现的不是匹配的单词）
    			if (!wordNums.containsKey(curWord)) {
    				start = j + wordLen;
    				count = 0;
    				curWordNums.clear();
    			} else {
    				//移动窗口
    				if (j == start + windowLen) {
    					String lastFirstWord = s.substring(start, start + wordLen);
    					start += wordLen;
    					int num = curWordNums.get(lastFirstWord);
    					if (num <= wordNums.get(lastFirstWord)) 	count--;			//当去掉一个匹配单词时，count--
    					curWordNums.put(lastFirstWord, num-1);
    				}
    				
    				int num = curWordNums.getOrDefault(curWord, 0);
    				if (num < wordNums.get(curWord))				count++;			//当多了一个匹配单词时，count++
    				curWordNums.put(curWord, num+1);
    				
    				if (count == wordCount && start + windowLen == j + wordLen)			//当完全匹配成功的时候，添加当前符合条件的start 	
    					result.add(start);
    			}
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		String s = "barfoofoobarthefoobarman";
		String[] words = new String[] {"bar","foo","the"};
		new Solution030().solution1(s, words);
	}
    
    //常规解决方案：
    //遍历每一组长度为wordNum * wordLen的字符串，查看是否符合要求
    private List<Integer> solution2(String s, String[] words) {
    	List<Integer> result = new ArrayList<Integer>();
    	if (words.length == 0)
    		return result;
    	int wordNum = words.length;
    	int wordLen = words[0].length();
    	int strLen = s.length();
    	
    	int lastStartIndex = strLen - wordNum*wordLen;
    	
    	HashMap<String, Integer> dict = new HashMap<String, Integer>();
    	for (String word : words) 
    		dict.put(word, dict.getOrDefault(word, 0) + 1);
    	
    	for (int start = 0; start <= lastStartIndex; start++) {
    		HashMap<String, Integer> lastWords = new HashMap<>(dict);
    		boolean flag = true;
    		for (int i = 0; i < wordNum; i++) {
    			String word = 
    					s.substring(start + i*wordLen, start + (i+1)*wordLen);
    			int curWordLastCount = lastWords.getOrDefault(word, 0) - 1;
    			if (curWordLastCount < 0) {
    				flag = false;
    				break;
    			}
    			else {
    				lastWords.put(word, curWordLastCount);
    			}
    		}
    		if (flag)
    			result.add(start);
    	}
    	return result;
    }
}
