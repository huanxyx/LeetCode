package com.xyx.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

//84***. Largest Rectangle in Histogram
public class Solution084 {

	/*
	 * 实现原理：
	 * 		结果中最大面积的直方的高度，肯定是某个直方的高度，
	 * 		所以我们只需要求以每个直方的高度为高的直方的最大面积（找到左边界与右边界）
	 * 
	 * 
	 * 实现思路(栈)：存的时候，从左往右存，算的时候从右往左算 
	 * 		1.创建一个栈，用来存储每个直方的下标（以升序的方式存储）
	 * 		2.从左往右遍历每一个直方
	 * 				2.1若是当前矩形矮于栈顶直方，那么则一直弹出栈顶的直方，直到栈顶的直方不再高于当前直方。
	 * 				2.2若是当前矩形高于栈顶直方，那么则将当前直方压入栈中
	 */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
    	Deque<Integer> stack = new ArrayDeque<Integer>();
    	
    	for (int i = 0; i <= heights.length; i++) {
    		//产生一个高度为-1的直方，帮助我们处理完所有的直方
    		int curNum = (i == heights.length) ? -1 : heights[i];

    		//关键：每次遇到小于的，则将之前大于当前高度的直方进行处理
    		while (!stack.isEmpty() && heights[stack.peek()] >= curNum) {
    			int h = heights[stack.pop()];
    			//其中stack.peek()为左边界，i为右边界
    			int start = stack.isEmpty() ? -1 : stack.peek();
    			int end = i;
    			int w = end - start - 1;
    			res = Math.max(res, h * w);
    		}
    		stack.push(i);
    	}    	
        
        return res;
    }
    
    
    /*
     * 容易理解的方式：使用了动态规划
     */
    public int largestRectangleArea_1(int[] heights) {
    	if (heights.length == 0)
    		return 0;
    	int[] left = new int[heights.length];
    	int[] right = new int[heights.length];
    	
    	//找到每一个直方能延伸到的左边界
    	left[0] = -1;
    	for (int i = 1; i < heights.length; i++) {
    		int p = i - 1;
    		 
    		while (p >= 0 && heights[p] >= heights[i])
    			p = left[p];
    		left[i] = p; 
    	}
    	
    	//找到每一个直方能延伸到的右边界
    	right[heights.length - 1] = heights.length;
    	for (int i = heights.length - 2; i >= 0; i--) {
    		int p = i + 1;
    		
    		while (p < heights.length && heights[p] >= heights[i])
    			p = right[p];
    		
    		right[i] = p;
    	}
    	
    	//计算面积
    	int res = 0;
    	for (int i = 0; i < heights.length; i++) {
    		res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution084().largestRectangleArea_1(new int[] {2, 1, 5, 6, 2, 3}));	
	}

}
