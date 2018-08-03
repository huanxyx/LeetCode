package com.xyx.leetcode.solution;

// 99.Recover Binary Search Tree
public class Solution099 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode bigNode = null;
    TreeNode bigNextNode = null;
    TreeNode smallNode = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        if (smallNode == null) {
            swap(bigNextNode, bigNode);
        } else {
            swap(bigNode, smallNode);
        }
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return ;
        traverse(root.left);
        if (pre != null && root.val < pre.val) {
            if (bigNode == null) {
                bigNode = pre;
                bigNextNode = root;
            } else {
                smallNode = root;
                return ;
            }
        }
        pre = root;
        traverse(root.right);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
