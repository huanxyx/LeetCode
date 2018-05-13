package com.xyx.leetcode.solution;

//33. Search in Rotated Sorted Array
public class Solution33 {
	
	//直接找
    public int search(int[] nums, int target) {
    	int low = 0, hig = nums.length - 1;
        
    	while (low <= hig) {
    		int mid = low + (hig - low) / 2;
    		if (target == nums[mid])
    			return mid;
    		
    		if (nums[low] <= nums[mid]) {
    			if (nums[low] <= target && target <= nums[mid])
    				hig = mid - 1;
    			else
    				low = mid + 1;
    		} else {
    			if (nums[mid] <= target && target <= nums[hig] )
    				low = mid + 1;
    			else
    				hig = mid - 1;
    		}
    	}
    	return -1;
    }
    
    // 先找出转换点的位置，然后再利用二分查找求target的位置
    public int search1(int[] nums, int target) {
    	int low = 0, hig = nums.length - 1;
    	
    	while (low < hig) {
    		int mid = (hig + low) / 2;
    		if (nums[mid] < nums[hig])
    			hig = mid;
    		else
    			low = mid + 1;
    	}
    	int realStart = low;
    	low = 0;
    	hig = nums.length - 1;
    	
    	while (low <= hig) {
    		int mid = (low + hig) / 2;
    		int realMid = (mid + realStart) % nums.length;
    		if (nums[realMid] == target)
    			return realMid;
    		else if (nums[realMid] < target)
    			low = mid + 1;
    		else 
    			hig = mid - 1;
    	}
    	return -1;
    }
}
