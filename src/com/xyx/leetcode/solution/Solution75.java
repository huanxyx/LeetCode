package com.xyx.leetcode.solution;

//75. Sort Colors
public class Solution75 {
	
	/*
	 * 荷兰国旗问题
	 */
    public void sortColors(int[] nums) {
        int whiteLeft = 0;
        int blueLeft = nums.length-1;
        int curPos = 0;
        while (curPos <= blueLeft) {
        	int curColor = nums[curPos];
        	if (curColor == 1) {
        		curPos++;
        	} else if (curColor == 0) {
        		swap(nums, whiteLeft++, curPos++);
        	} else if (curColor == 2){
        		swap(nums, curPos, blueLeft--);
        	}
        }
    }
    
    private void swap(int[] nums, int a, int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}
