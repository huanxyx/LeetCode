package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

// 118.Pascal's Triangle
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> con = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
        	//往尾部添加一个1
        	con.add(1);
        	//更新1...倒数第二数。
        	for (int j = con.size()-2; j > 0; j--) {
        		con.set(j, con.get(j) + con.get(j-1));
        	}
        	result.add(new ArrayList<>(con));
        }
        return result;
    }
}
