package com.xyx.leetcode.solution;

//114. Flatten Binary Tree to Linked List
public class Solution114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        helper(root, null);
    }

    /**
     *
     * @param root  当前树的根节点
     * @param pre   前一个节点
     * @return      调整完整颗树之后最后的节点
     */
    private TreeNode helper(TreeNode root, TreeNode pre) {
        if (root == null) return pre;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        if (pre != null)
            pre.right = root;

        pre = helper(left, root);
        return helper(right, pre);
    }
}
