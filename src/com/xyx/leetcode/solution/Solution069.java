package com.xyx.leetcode.solution;

//69.Sqrt(x)
public class Solution069 {

    public int mySqrt(int x) {
        int low = 1;
        int hig = x / 2 + 1;
        
        while (low <= hig) {
        	int mid = low + (hig - low) / 2;
        	int div = x / mid;
        	
        	if (div == mid) 
        		return mid;
        	else if (div < mid)
        		hig = mid - 1;
        	else
        		low = mid + 1;
        }
        return hig;
    }
}
