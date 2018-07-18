package com.xyx.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

//20. Valid Parentheses
public class Solution020 {
	
	/*
	 * 一种独特的用法：
	 * 			只保存每个开括号对应的闭括号，
	 * 			当出现闭括号的时候，判断是否
	 * 			与应该出现的闭括号相同。
	 */
	public boolean isValid_1(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '[')
				stack.push(']');
			else if (cur == '{') 
				stack.push('}');
			else if (cur == '(')
				stack.push(')');
			else {
				if (stack.isEmpty() || stack.pop() != cur)
					return false;
			}
		}
		
		return stack.isEmpty();
	}

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        
        for (int traPos = 0; traPos < s.length(); traPos++) {
        	char cur = s.charAt(traPos);
    		if (')' == cur) {
    			if (!stack.isEmpty() && stack.peek() == '(')
    				stack.pop();
    			else 
    				return false;
    		} else if (']' == cur) {
    			if (!stack.isEmpty() && stack.peek() == '[')
    				stack.pop();
    			else 
    				return false;
    		} else if ('}' == cur) {
    			if (!stack.isEmpty() && stack.peek() == '{')
    				stack.pop();
    			else 
    				return false;
    		} else 
    			stack.push(cur);
        }
        
        if (stack.isEmpty())
        	return true;
        return false;
    }

}
