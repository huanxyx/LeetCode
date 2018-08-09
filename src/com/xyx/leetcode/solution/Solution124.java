package com.xyx.leetcode.solution;

//124. Binary Tree Maximum Path Sum
public class Solution124 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    * 最长路径就是树中任意两个节点之间的距离最长的时候
    * A节点到B节点之间肯定有一个最高的节点R：
    *           那么A节点到B节点的距离就可以通过A节点到R节点的距离与B节点到R节点的距离相加得到。
    * */
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        subMaxPathSum(root);
        return max;
    }
    //将结果存在全局变量中
    int max;
    //每次返回以当前节点为根节点的最大单边的长度
    //同时找到以每个节点为最高节点的路径的最长距离
    private int subMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, subMaxPathSum(root.left));
        int right = Math.max(0, subMaxPathSum(root.right));

        //更新
        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
