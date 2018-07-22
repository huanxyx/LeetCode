package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//49. Group Anagrams
public class Solution049 {

	/*
	 * 方法1：使用26个素数代替26个小写字母，这样不同单词计算出来的结果（每个字母对应的素数相乘）必然不相同。
	 * 方法2：对字符串中的字母进行排序，只要属于同一组的字符串，排序后的字符串必定相同
	 */
    public List<List<String>> groupAnagrams(String[] strs) {

    	
    	HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>(); 
    	for (String str : strs) {
    		int hash = hash(str);
    		if (!map.containsKey(hash)) {
    			map.put(hash, new ArrayList<String>());
    		}
    		map.get(hash).add(str);
    	}
    	
        return new ArrayList<List<String>>(map.values());
    }
    
	public int[] prime = new int[] {
    		2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103
    	};
	
    //方法1的辅助函数
    public int hash(String str) {
    	int res = 1;
    	for (int i = 0; i < str.length(); i++)
    		res *= prime[str.charAt(i) - 'a'];
    	return res;
    }
    
    //方法2的辅助函数
    public String sort(String str) {
    	char[] strArr = str.toCharArray();
    	Arrays.sort(strArr);
    	
    	return new String(strArr);
    }

}
