package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

// 315. Count of Smaller Numbers After Self
public class Solution315 {
	
	private static int[] helpMap;
    public List<Integer> countSmaller(int[] nums) {
    	List<Integer> resList = new ArrayList<Integer>();
    	
    	helpMap = new int[nums.length];
    	//map[i]表示排序后数组中第i个元素表示原数组的第几个元素，用来代替操作原数组
    	int[] map = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) 			map[i] = i;
    	int[] res = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, res, map);
        
        for (int i = 0; i < nums.length; i++) 
        	resList.add(res[i]);
        return resList;
    }
	
	private static void mergeSort(int[] nums, int low, int hig, int[] res, int[] map) {
		if (low >= hig)
			return ;
		int mid = low + ((hig - low) >> 1);
		mergeSort(nums, low, mid, res, map);
		mergeSort(nums, mid+1, hig, res, map);
		merge(nums, low, mid, hig, res, map);
	}
	
	private static void merge(int[] nums, int low, int mid, int hig, int[] res, int[] map) {
		int left = low;
		int right = mid + 1;
		int pos = low;
		
		//记录右边小于左边的数目
		int smallerRightCount = 0;
		while (left <= mid && right <= hig) {
			if (nums[map[left]] > nums[map[right]]) {
				helpMap[pos++] = map[right++];
				smallerRightCount++;
			} else if (nums[map[left]] <= nums[map[right]]) {
				res[map[left]] += smallerRightCount;
				helpMap[pos++] = map[left++];
			}
		}
		while (left <= mid) {
			res[map[left]] += smallerRightCount;
			helpMap[pos++] = map[left++];
		}
		while (right <= hig) {
			helpMap[pos++] = map[right++];
		}
		for (int i = low; i <= hig; i++)
			map[i] = helpMap[i];
	}	
	
	public static void printArr(int[] arr) {
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}
	
	public static void printArr(int[] arr, int[] map) {
		for (int index : map) {
			System.out.print(arr[index] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
		new Solution315().countSmaller(arr);
	}
}
