package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//93. Restore IP Addresses
public class Solution093 {

    /*
    * 基本的思路就是每次考虑一个部分，长度为1，2，3三种情况，然后遍历下一个部分
    *       1. 若是四个部分都考虑完了还没有遍历完遍历完了，四个部分还没有得出来。那么这意味着当前情况不合法
    *       2. 四个部分都得出来了，而且字符串也遍历完了，则添加当前情况下的结果
    *
    * */
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<String>();
        if (len > 12)
            return res;
        int[] splitPos = new int[4];
        helper(res, splitPos, 0, s, 0);

        return res;
    }

    public void helper(List<String> res, int[] splitPos, int curIndex, String s, int sIndex) {
        if (sIndex == s.length() && curIndex == 4) {
            res.add(createIpStr(splitPos, s));
            return ;
        }
        if (sIndex == s.length() || curIndex == 4)
            return ;

        if (sIndex + 2 < s.length() ) {
            String subStr = s.substring(sIndex, sIndex + 3);
            int i = Integer.parseInt(subStr);
            if (i <= 255 && i >= 100) {
                splitPos[curIndex] = sIndex + 3;
                helper(res, splitPos, curIndex + 1, s, sIndex + 3);
            }
        }
        if (sIndex + 1 < s.length()) {
            String subStr = s.substring(sIndex, sIndex + 2);
            int i = Integer.parseInt(subStr);
            if (i >= 10) {
                splitPos[curIndex] = sIndex + 2;
                helper(res, splitPos, curIndex + 1, s, sIndex + 2);
            }
        }
        if (sIndex < s.length()) {
            splitPos[curIndex] = sIndex + 1;
            helper(res, splitPos, curIndex + 1, s, sIndex + 1);
        }
    }

    private String createIpStr(int[] splitPos, String s) {
        String ip = "";
        ip += s.substring(0, splitPos[0]) + ".";
        ip += s.substring(splitPos[0], splitPos[1]) + ".";
        ip += s.substring(splitPos[1] ,splitPos[2]) + ".";
        ip += s.substring(splitPos[2]);

        return ip;
    }
}
