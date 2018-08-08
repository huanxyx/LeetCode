package com.xyx.leetcode.solution;

//115. Distinct Subsequences
public class Solution115 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = 1;

        for (int i = 1; i <= t.length(); i++) {
            char lastCh = t.charAt(i - 1);
            for (int j = 1; j <= s.length(); j++) {
                dp[j][i] = dp[j - 1][i];
                if (lastCh == s.charAt(j - 1))
                    dp[j][i] += dp[j - 1][i - 1];
            }
        }

        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution115().numDistinct("babgbag", "bag"));
    }
}
