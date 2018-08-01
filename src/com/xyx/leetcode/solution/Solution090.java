package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 90. Subsets II
public class Solution090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);                          //来用将相同的数排在一起
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int cur) {
        res.add(new ArrayList<Integer>(list));

        //对于任何一个数，只存在包含与不包含的区别，当选中了第i个数，那么第cur到第i-1个数都不再进行考虑
        //若是 nums[i] == nums[i-1]，那么在i-1被包含进行的情况下，已经考虑过任何包含i的情况：
        //nums[i - 1]被包含，而nums[i]不被包含，与nums[i]被包含，nums[i - 1]不被包含的情况一样。
        //所以无需考虑nums[i]被包含，nums[i - 1]不被包含的情况
        for (int i = cur; i < nums.length; i++) {
            if (i != cur && nums[i] == nums[i - 1])  continue;      //关键位置
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
