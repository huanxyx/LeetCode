package com.xyx.leetcode.solution;

//838. Push Dominoes
public class Solution838 {
	
	/*
	 * 以下几种情况:
	 * 			1. R...R	
	 * 			2. R...
	 * 			3. L...L
	 * 			4. ...L
	 * 			5. R...L
	 */
    public String pushDominoes(String dominoes) {
        char[] domArr = dominoes.toCharArray();
        
        int lastToRight = -1;
        int lastToLeft = -1;
        
        for (int i = 0; i <= domArr.length; i++) {
        	if (i == domArr.length || domArr[i] == 'R') {						
        		if (lastToRight > lastToLeft) {			//R...R或者R...
        			while (lastToRight < i)
        				domArr[lastToRight++] = 'R';
        		}
        		lastToRight = i;
        	} else if (domArr[i] == 'L') {
        		if (lastToLeft > lastToRight || (lastToLeft == -1 && lastToRight == -1)) {			//L...L或者...L
        			while (++lastToLeft < i)
        				domArr[lastToLeft] = 'L';
        		} else {								//R...L
        			lastToLeft = i;
        			int low = lastToRight + 1;
        			int hig = lastToLeft - 1;
        			while (low < hig) {
        				domArr[low++] = 'R';
        				domArr[hig--] = 'L';
        			}
        		}
        	}
        }

        return new String(domArr);
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution838().pushDominoes("RR.L"));
	}

}
