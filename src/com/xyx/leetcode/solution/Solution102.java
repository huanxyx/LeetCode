package com.xyx.leetcode.solution;

import java.util.*;

//102. Binary Tree Level Order Traversal
public class Solution102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    * 还可以使用先序遍历实现：利用一个参数记录当前遍历的深度
    * 然后当遍历到一个节点的时候，就将它添加到指定深度的那个容器中。
    * 因为是先序遍历，所有每层的节点都是从左往右添加的
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                tmp.add(tn.val);
                if (tn.left != null) queue.offer(tn.left);
                if (tn.right != null) queue.offer(tn.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
