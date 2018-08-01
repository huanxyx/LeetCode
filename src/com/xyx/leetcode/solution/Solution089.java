package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//89. Gray Code
public class Solution089 {

    /*
    * 找规律：n = 3
    *          000, 001, 011, 010, 110, 111, 101, 100
    *         n = 2
    *           00, 01, 11, 10
    *         n = 1
    *           0, 1
    *
    *         f(n) = f(n - 1) + 逆序(f(n - 1) + 代表最高位的数)
    * */
    public List<Integer> grayCode(int n) {
        if (n == 0)
            return new ArrayList<Integer>(Arrays.asList(new Integer[] {0}));
        if (n == 1)
            return new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 1}));
        int add = 1 << (n - 1);
        List<Integer> res = grayCode(n - 1);
        int size = res.size();

        for (int i = size - 1; i >= 0; i--) {
            res.add(res.get(i) | add);
        }
        return res;
    }
}
