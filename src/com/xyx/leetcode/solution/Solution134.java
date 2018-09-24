package com.xyx.leetcode.solution;

//134. Gas Station
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        //用于判断是否存在该起点
        int sum = 0;
        //start表示起点，save表示从起点到当前点所存储的气体的量
        int start = 0;
        int save = 0;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            //到达下一个点所拥有的气体
            save += gas[i] - cost[i];
            //如果不能到达下一个点，则意味着从起点到当前点都不能作为起点
            if (save < 0) {
                save = 0;
                start = i + 1;
            }
        }
        if (sum < 0) return -1;
        return start;
    }
}
