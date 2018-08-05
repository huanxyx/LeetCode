package com.xyx.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

//105. Construct Binary Tree from Preorder and Inorder Traversal
public class Solution105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
    * 前提条件：没有重复的数
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //找个map记录位置
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return construct(preorder, inorder, map,0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] inorder, Map<Integer, Integer> map,
                               int leftP, int rightP, int leftI, int rightI) {
        if (leftP > rightP) return null;
        int rootNum = preorder[leftP];
        //找到在中序遍历中的位置
        int splitPos = map.get(rootNum);

        //构建树
        TreeNode root = new TreeNode(rootNum);
        root.left = construct(preorder, inorder, map,
                leftP + 1, leftP + splitPos - leftI,
                leftI, splitPos - 1);
        root.right = construct(preorder, inorder, map,
                rightP - (rightI - splitPos) + 1, rightP,
                splitPos + 1, rightI);
        return root;
    }
}
