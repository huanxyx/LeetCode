package com.xyx.leetcode.solution;

//34. Search for a Range
public class Solution34 {
	/*
	 * 其他人的思路：
	 * 		利用二分法求出target在数组中应该在的左边界
	 * 		然后再利用二分法求出target+1应该在左边界（没有则返回应该插入的位置）
	 */
	
	
	//利用二分法求边界与二分法求值得区别:
	//		终结状态是两个位置
	//		当mid位置的值与目标值相等的时候一边变成mid（求左边界，就右边变成mid，求右边界，则反之）
	
    public int[] searchRange(int[] nums, int target) {        
        if (nums.length == 0)
        	return new int[] {-1, -1};
        int left = edge(nums, target, true);
        if (left == -1)
        	return new int[] {-1,-1};
        return new int[] { left, edge(nums, target, false)};
    }
    
    // 利用二分法求出一个数的边界
    private int edge(int[] nums, int target, boolean getLeftEdge) {
    	int left = 0;
    	int right = nums.length - 1;
    	
    	while (left + 1 < right) {
    		int mid = (left + right) / 2;
    		
    		if (nums[mid] > target) 
    			right = mid - 1;
    		else if (nums[mid] < target)
    			left = mid + 1;
    		else {
    			if (getLeftEdge)
    				right = mid;
    			else 
    				left = mid;
    		}
    	}
    	
    	//假如是求左边界，则先看左边
    	if (getLeftEdge) {
	    	if (nums[left] == target)
	    		return left;
	    	else if (nums[right] == target)
	    		return right;
	    	else 
	    		return -1;
    	} else {
    		//假如是求右边界，则先看右边
	    	if (nums[right] == target)
	    		return right;
	    	else if (nums[left] == target)
	    		return left;
	    	else 
	    		return -1;
    	}
    }
}
