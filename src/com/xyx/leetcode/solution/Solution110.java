package com.xyx.leetcode.solution;

public class Solution110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
