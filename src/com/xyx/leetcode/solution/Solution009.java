package com.xyx.leetcode.solution;

//9. Palindrome Number
public class Solution009 {

    public boolean isPalindrome(int x) {
        if (x < 0)
        	return false;
        int origin = x;
        int reverse = 0;
        
        while (origin != 0) {
        	reverse *= 10;
        	reverse += origin % 10;
        	origin /= 10;
        }
        
        return reverse == x;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution009().isPalindrome(101));
	}

}
