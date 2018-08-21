package com.xyx.leetcode.solution;

// 132.Palindrome Partitioning II
public class Solution132 {
    public int minCut(String s) {
        //维护两个dp数组：
        //      1.用来表示第i...j是否构成回文串
        //      2.用来表示0...j的最小切割次数
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] res = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    min = j == 0 ? 0 : Math.min(res[j - 1] + 1, min);
                }
            }
            res[i] = min;
        }
        return res[s.length() - 1];
    }
}
