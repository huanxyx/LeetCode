package com.xyx.leetcode.solution;

//81. Search in Rotated Sorted Array II
public class Solution081 {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int hig = nums.length - 1;
        
        while (low <= hig) {
        	int mid = low + ((hig - low) >> 1);
        	if (nums[mid] == target) 
        		return true;
        	
        	if (nums[mid] < nums[hig]) {						//右边为递增序列						
        		if (target <= nums[hig] && target > nums[mid])
        			low = mid + 1;
        		else 
        			hig = mid - 1;
        	} else if(nums[mid] > nums[hig]) {					//右边有转折点
        		if (target >= nums[low] && target < nums[mid])
        			hig = mid - 1;
        		else
        			low = mid + 1;
        	} else {											//减小范围
        		hig--;
        	}
        }
        return false;
    }

}
