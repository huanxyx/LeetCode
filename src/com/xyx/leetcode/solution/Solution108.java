package com.xyx.leetcode.solution;

//108. Convert Sorted Array to Binary Search Tree
public class Solution108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int low, int hig) {
        if (low > hig) return null;

        int mid = low + ((hig - low) >> 1);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, low, mid - 1);
        root.right = construct(nums,mid + 1, hig);

        return root;
    }
}
