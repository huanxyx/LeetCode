package com.xyx.leetcode.solution;

//137. Single Number II
public class Solution137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) != 0) sum++;
            }
            if (sum % 3 != 0) res += mask;
        }
        return res;
    }

    /*
    *   本质上就是每一位达到3个的时候就变成0，只不过是通过位运算来实现了。
    *   借助了第二个变量才能表示00,01,10，一个变量一位只能表示0,1
    *
    *   0 -> 1 -> 2 -> 0
    *   00 -> 01 -> 10 -> 00
    *   ones   twos
    *   0->1   0->0
    *   1->0   0->1
    *   0->0   1->0
    * */
    private int singleNumber_1(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
