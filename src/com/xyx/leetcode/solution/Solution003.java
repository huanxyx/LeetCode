package com.xyx.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

//3.Longest Substring Without Repeating Characters
public class Solution003 {
	public int lengthOfLongestSubstring(String s) {
    	//因为字符只有256种可能，所以可以直接用大小为256的数组代替HashMap。
    	//...
    	
    	//使用Map记录着上一次该字符所在的位置，当遇到Map存在该字符的时候，将begin的位置移动到那个字符的后一个
    	int ans = 0;
    	int strLength = s.length();
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	for (int end = 0, begin = 0; end < strLength; end++) {
    		//若是存在该元素，就将begin的位置移动到与end位置元素相同的上一个元素的后面，这样就能保证窗口还是满足条件的
    		if (map.containsKey(s.charAt(end))) 
    			//因为存在end位置的字符上次出现是在begin的前面，所以需要判断两者的较大值
    			begin = Math.max(map.get(s.charAt(end)) + 1, begin);
    	
			ans = Math.max(ans, end - begin + 1);
			//更新窗口中出现元素的位置。
			map.put(s.charAt(end), end);
    	}
    	
    	return ans;
    	
/*    	//引入滑动窗口的概念
    	//窗口是数组，字符串中由开始到结束索引定义的一系列元素。
    	int strLength = s.length();
    	//定义left为窗口的索引，right为窗口的结束索引
    	int left = 0, right = 0, ans = 0;
    	//定义一个Set集合，用来表示当前窗口已经存在的元素
    	Set<Character> set = new HashSet<Character>();
    	
    	while(left < strLength && right < strLength) {
    		//当存在该字符的时候，将left往右移动一位，然后从Set中删除原来left位置的字符
    		if (set.contains(s.charAt(right))) {
    			set.remove(s.charAt(left++));
    		} else {
    			//当不存在该字符的时候，将right往右移动一位，然后向Set中添加right新的字符，同时更新最大值
    			set.add(s.charAt(right++));
    			ans = Math.max(ans, right - left);
    		}
    	}
 
    	return ans;*/
    	
/*    	
    	int max = 0;
    	int end = 0;
    	//假如begin到end之间有重复的字符，而begin到end-1之间没有重复的字符，
    	//那么begin+1到end-1之间也没有重复的字符，那么下一次遍历就可以直接从end开始
    	for (int begin = 0; begin < s.length(); begin++) {
    		//begin到end之间字符的数量
    		int count = end - begin;
    		//遍历begin到end，直到begin到end之间存在相同的元素
    		for (; end < s.length(); end++) {
    			char endChar = s.charAt(end);
    			boolean isSuitable = true;
    			//判断start到end之间是否有相同的元素，有的话终止循环
    			for (int k = begin; k < end; k++) {
    				if (endChar == s.charAt(k)) {
    					isSuitable = false;
    					break;
    				}	
    			}
    			if (isSuitable) count++;
    			else break;
    		}
    		if (count > max) max = count;
    	}
    	
        return max;*/
    }
}
