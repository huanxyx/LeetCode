package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

// 131. Palindrome Partitioning
public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();

        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = true;
        for (int len = 3; len <= s.length(); len++) {
            for (int start = 0; start <= s.length() - len; start++) {
                int end = start + len - 1;
                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1])
                    dp[start][end] = true;
            }
        }
        helper(s, dp, new ArrayList<String>(), res, 0);
        return res;
    }

    private void helper(String s, boolean[][] dp, List<String> tmp, List<List<String>> res, int curPos) {
        if (curPos >= s.length()) res.add(new ArrayList<>(tmp));
        else {
            for (int i = curPos; i < s.length(); i++) {
                if (dp[curPos][i]) {
                    tmp.add(s.substring(curPos, i + 1));
                    helper(s, dp, tmp, res, i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution131().partition("efe"));
    }
}
