package com.xyx.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;

//128. Longest Consecutive Sequence
public class Solution128 {

    //利用Map来实现，有点类似并查集
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);

            int length = left + right + 1;
            map.put(num, length);
            map.put(num - left, length);
            map.put(num + right, length);
            res = Math.max(res, length);
        }

        return res;
    }

    //利用集合来存储数，然后遍历到每一个数的时候，向两边扩散
    private int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) set.add(num);

        int res = 0;
        for (int num : nums) {
            if (set.remove(num)) { //当前存在该数
                int pre = num - 1;
                int next = num + 1;
                int length = 1;
                while (set.remove(pre)) {
                    length++;
                    pre--;
                }
                while (set.remove(next)) {
                    length++;
                    next++;
                }
                res = Math.max(res, length);
            }
        }

        return res;
    }

}
