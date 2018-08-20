package com.xyx.leetcode.solution;

// 129. Sum Root to Leaf Numbers
public class Solution129 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int sumNumbers(TreeNode root) {
        return getAll(0, root);
    }

    private int getAll(int curSum, TreeNode root) {
        if (root == null) return 0;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) return curSum;
        else return getAll(curSum, root.left) + getAll(curSum, root.right);
    }

}
