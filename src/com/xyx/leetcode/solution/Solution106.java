package com.xyx.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

//106. Construct Binary Tree from Inorder and Postorder Traversal
public class Solution106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //找个map记录位置
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return construct(postorder, inorder, map,0, postorder.length - 1, 0, inorder.length - 1);
    }


    private TreeNode construct(int[] postorder, int[] inorder, Map<Integer, Integer> map,
                               int leftP, int rightP, int leftI, int rightI) {
        if (leftP > rightP) return null;
        int rootNum = postorder[rightP];
        //找到在中序遍历中的位置
        int splitPos = map.get(rootNum);

        //构建树
        TreeNode root = new TreeNode(rootNum);
        root.left = construct(postorder, inorder, map,
                leftP, leftP - 1 + (splitPos - leftI),
                leftI, splitPos - 1);
        root.right = construct(postorder, inorder, map,
                leftP + (splitPos - leftI), rightP - 1,
                splitPos + 1, rightI);
        return root;
    }
}
