package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//77. Combinations
public class Solution077 {

    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	
    	combineSub(n, k, 1, tmp, res);
        return res;
    }
    
    /*
     * n表示最大的数
     * k表示还需要k个数
     * cur表示当前位置
     * tmp表示之前的序列
     * res表示存储结果的容器
     */
    private void combineSub(int n, int k, int cur, List<Integer> tmp, List<List<Integer>> res) {
    	if (k == 0) 
    		res.add(new ArrayList<Integer>(tmp));
    	else {
    		int end = 1 + n - k;
    		for (int i = cur; i <= end; i++) {
    			tmp.add(i);
    			combineSub(n, k - 1, i + 1, tmp, res);
    			tmp.remove(tmp.size() - 1);
    		}
    	}
    }

}
