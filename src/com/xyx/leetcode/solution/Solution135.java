package com.xyx.leetcode.solution;

//135. Candy
public class Solution135 {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        //从左到右
        for (int i = 0; i < ratings.length; i++) {
            left[i] = 1;
            if (i > 0 && ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }
        //从右到左
        for (int i = ratings.length - 1; i >= 0; i--) {
            right[i] = 1;
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
        }
        int res = 0;
        for (int i = 0; i < ratings.length; i++)
            res += Math.max(right[i], left[i]);
        return res;
    }
}
