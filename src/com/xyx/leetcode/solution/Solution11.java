package com.xyx.leetcode.solution;

// Container With Most Water
public class Solution11 {
    public int maxArea(int[] height) {
    	int max = 0;						//最大的容量
    	int area;							//当前的容量
        
    	int left = 0;						//最左边的边
    	int right = height.length - 1;		//最右边的边
    	
    	while(left < right) {
    		
    		int lHeight = height[left];
    		int rHeight = height[right];
    		
    		// 固定高边，移动小边
    		// 只有保留最高的边，才有可能使下次的容量增加。
    		// 若是保留最小的边，只会使容量越来越小。（底边减小，而最小边的高并不会增加）
    		// 移动小边，直到找到第一个比大边大的边
    		if (lHeight < rHeight) {
    			area = (right - left) * lHeight;
    			// 因为左边的肯定比右边的小，所以肯定有个终止点，不会越界
    			while (height[++left] <= lHeight);
    		} else {
    			area = (right - left) * rHeight;
    			// 因为右边的与左边的有可能相等，所以不能使用小于等于
    			while (height[--right] < rHeight);
    		}
    		
    		max = Math.max(max, area);
    	}
    	
        return max;
    }
}
