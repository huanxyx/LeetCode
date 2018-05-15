package com.xyx.leetcode.solution;

import java.util.Stack;

// 42.Trapping Rain Water
public class Solution42 {
    
	/*
	 * 解决问题的核心：
	 * 		如何判断一个位置是否能容纳水，则需要判断他左右边的最大值中
	 * 		小的那个边是否大于当前位置的高度。
	 */
	public int trap(int[] height) {
    	return solution1(height);
    }
    
    
    //1.暴力求解（O(n^2)）
    private int solution1(int[] height) {
    	int sum = 0;
    	for (int i = 1; i < height.length-1; i++) {
    		//求出左边最高的边
    		int leftMax = 0;
    		for (int left = i-1; left >= 0; left--) {
    			if (height[left] > leftMax)
    				leftMax = Math.max(leftMax, height[left]);
    		}
    		//求出右边最高的边
    		int rightMax = 0;
    		for (int right = i+1; right < height.length; right++) {
    				rightMax = Math.max(rightMax, height[right]);
    		}
            int h = Math.min(rightMax, leftMax);
            //该坐标的高度在三者中不是最小的，则不能形成坑。
            if (h > height[i])
    		    sum += h - height[i];
    	}
    	return sum;
    }
    
    //2.动态规划
    private int solution2(int[] height) {
    	if (height == null || height.length == 0)
    		return 0;
    	//计算每个位置左边最大和右边最大
    	int[] leftMax = new int[height.length];
	    int[] rightMax = new int[height.length];
    	leftMax[0] = height[0];
    	rightMax[height.length-1] = height[height.length-1];
    	for (int i = 1; i < height.length; i++) {
    		leftMax[i] = Math.max(leftMax[i-1], height[i]);
    	}
    	for (int i = height.length-2; i >= 0; i--) {
    		rightMax[i] = Math.max(rightMax[i+1], height[i]);
    	}
    	
    	//计算每个位置的容量
    	int sum = 0;
    	for (int i = 1; i < height.length-1; i++) {
    		sum += Math.min(rightMax[i], leftMax[i]) - height[i];
    	}
    	return sum;
    }
    
    //3.双指针
    private int solution3(int[] height) {
    	int leftMax = 0;			//存储着左边的最高边
    	int rightMax = 0;			//存储着右边的最高边
    	int left = 0;
    	int right = height.length-1;
    	int sum = 0;
    	/*
    	 * left和right最后的位置肯定是最高的边。
    	 * 所以无需对最后进行判断
    	 */
    	while (left < right) {
    		/*
    		 * 左边的边界小于或等于右边的时候
    		 * 意味着中间的部分假如小于左边的最大边界，那么肯定可以容纳。
    		 */
    		if (height[left] <= height[right]) {
    			leftMax = Math.max(leftMax, height[left]);
    			sum += leftMax - height[left];
    			left++;
    			//产生的结果：找到比右边大的。
    		} else {
        		/*
        		 * 同样的道理，右边的边界小于左边的时候
        		 * 意味着中间的部分假如小于右边的最大边界，那么肯定可以容纳。
        		 */
    			rightMax = Math.max(rightMax, height[right]);
    			sum += rightMax - height[right];
    			right--;
    			//产生的结果：找到比左边大的。
    		}
    	}

    	return sum;
    }
    
    /*
     * 遍历数组，遇到一个元素时，将其与栈顶元素进行比较
     * 		若是小于或等于，则进行压栈操作。（栈里面是递减的）
     * 		若是大于，则形成了两高夹一矮，可以弹出栈顶，并计算栈顶位置的储水量
     */
    private int solution4(int[] height) {
    	int sum = 0;
    	int current = 0;
    	Stack<Integer> stack = new Stack<>();
    	while (current < height.length) {	
    		//当为空或者递减时，进行压栈
    		if (stack.isEmpty() || height[stack.peek()] >= height[current]) {
    			stack.push(current++);
    		} else {
    			//当递增时，进行出栈，计算储水量
    			int top = stack.pop();
    			//没有左边界的情况
    			if (stack.isEmpty())	continue;
    			sum += (Math.min(height[current], height[stack.peek()]) - height[top]) * 
    					(current - stack.peek() - 1);
    		}
    	}
    	return sum;
    }
}
