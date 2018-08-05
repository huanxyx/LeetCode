package com.xyx.leetcode.solution;

import java.util.*;

//107. Binary Tree Level Order Traversal II
public class Solution107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                if (tn.left != null) queue.offer(tn.left);
                if (tn.right != null) queue.offer(tn.right);
                tmp.add(tn.val);
            }
            res.add(tmp);
        }
        Collections.reverse(res);
        return res;
    }
}
