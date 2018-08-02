package com.xyx.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

// 98.Validate Binary Search Tree
public class Solution098 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                if (pre != null && node.val <= pre.val)
                    return false;
                pre = node;
                cur = node.right;
            }
        }
        return true;
    }
}
