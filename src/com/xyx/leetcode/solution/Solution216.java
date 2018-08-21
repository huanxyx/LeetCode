package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//216. Combination Sum II
public class Solution216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, 1, n, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> buf, int k, int cur, int target, int sum) {
        if (k == 0 && sum == target) {
            res.add(new ArrayList<>(buf));
        } else if (k > 0 && sum < target) {
            for (int i = cur; i <= 9; i++) {
                buf.add(i);
                helper(res, buf, k - 1, i + 1, target, sum + i);
                buf.remove(buf.size() - 1);
            }
        }
    }
}
