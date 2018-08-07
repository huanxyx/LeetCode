package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//113. Path Sum II
public class Solution113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        findAllPath(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    private void findAllPath(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
        if (root == null) return ;
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> add = new ArrayList<>(tmp);
            add.add(root.val);
            res.add(add);
            return ;
        }
        tmp.add(root.val);
        findAllPath(root.left, sum - root.val, tmp, res);
        findAllPath(root.right, sum - root.val, tmp, res);
        tmp.remove(tmp.size() - 1);
    }
}
