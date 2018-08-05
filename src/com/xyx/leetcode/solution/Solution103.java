package com.xyx.leetcode.solution;

import java.util.*;

//103. Binary Tree Zigzag Level Order Traversal
public class Solution103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean toRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                if (tn.left != null) queue.offer(tn.left);
                if (tn.right != null) queue.offer(tn.right);
                tmp.add(tn.val);
            }
            if (!toRight) {
                Collections.reverse(tmp);
            }
            toRight = !toRight;
            res.add(tmp);
        }
        return res;
    }
}
