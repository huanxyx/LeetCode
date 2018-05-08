package com.xyx.leetcode.solution;

//7.Reverse Integer 
public class Solution7 {

    public int reverse(int x) {
    	//通过使用long来存储，可以表示有符号32位所有的数，然后通过判断是否处于Integer所在范围来确定返回值
		long ans = 0;
    	
    	while (x != 0) {
    		ans = ans * 10 + (x % 10);
    		x /= 10;
    		if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
    			return 0;
    	}
    	
    	return (int) ans;
    	
/*		//通过逆运算，判断是否越界
     	int ans = 0;
    	
    	while (x != 0) {
    		int current = x % 10;
    		int newNum = (ans * 10) + current;
    		if ((newNum - current) / 10 != ans)
    			return 0;
    		ans = newNum;
        	x /= 10;
    	}
    	
    	return ans;*/
    }
}
