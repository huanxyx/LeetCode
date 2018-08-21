package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//306. Additive Number
public class Solution401 {

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (countBit((i << 6) + j) == num)
                    res.add(String.format("%d:%02d", i, j));
            }
        }
        return res;
    }

    private int countBit(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) count++;
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution401().readBinaryWatch(2));
    }
}
