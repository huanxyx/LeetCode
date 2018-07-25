package com.xyx.leetcode.solution;

//69.Sqrt(x)
public class Solution069 {

    public int mySqrt(int x) {
        int low = 1;
        int hig = x / 2 + 1;
        
        while (low <= hig) {
        	int mid = low + (hig - low) / 2;
        	long square = (long)mid * mid;		//使用long是为了避免平方溢出
        	
        	if (square == x) 
        		return mid;
        	else if (square < x)
        		low = mid + 1;
        	else
        		hig = mid - 1;
        }
        return hig;
    }
}
