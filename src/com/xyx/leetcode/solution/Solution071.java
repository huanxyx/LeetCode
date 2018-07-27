package com.xyx.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

//71.Simplify Path
public class Solution071 {

    public String simplifyPath(String path) {
        String[] p = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        
        for (String dir : p) {
        	if ("..".equals(dir)) {
        		if (!stack.isEmpty())
        			stack.removeLast();			//删除栈后面的元素
        	} else if (".".equals(dir)) {
        		continue;
        	} else if ("".equals(dir)) {
        		continue;
        	} else {
        		stack.addLast(dir);				//从后往前往栈中添加元素
        	}
        }
        
        if (stack.isEmpty())
        	return "/";
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
        	res.append("/" + stack.removeFirst());
        }
        
        return res.toString();
    }
    
    public static void main(String[] args) {
		new Solution071().simplifyPath("/home/");
	}

}
