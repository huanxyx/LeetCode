package com.xyx.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//95. Unique Binary Search Trees II
public class Solution095 {
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	 /*
	  * 状态：在num=n的情况下的解
	  * 状态转移：以任意一个节点构成根节点，其不同左子树*不同右子树
	  */
    public List<TreeNode> generateTrees(int n) {
    	
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        //初始状态
        if (n == 0)
        	return dp[0];
        
        dp[0].add(null);
        
        for (int i = 1; i <= n; i++) {
        	dp[i] = new ArrayList<TreeNode>();
        	for (int root = 1; root <= i; root++) {										//根节点
        		for (int left = 0; left < dp[root-1].size(); left++)					//左边节点的情况
        			for (int right = 0; right < dp[i-root].size(); right++) {			//右边节点的情况 
        				TreeNode rootNode = new TreeNode(root);
    					rootNode.left = cloneTree(dp[root-1].get(left), 0);
    					rootNode.right = cloneTree(dp[i-root].get(right), root);
        				dp[i].add(rootNode);
        			}
        	}
        }
        
        return dp[n];
    }
    
    //克隆一颗树
    public TreeNode cloneTree(TreeNode tree, int offset) {
    	if (tree == null)
    		return null;
    	TreeNode cTree = new TreeNode(tree.val + offset);
    	cTree.left = cloneTree(tree.left, offset);
    	cTree.right = cloneTree(tree.right, offset);
    	return cTree;
    }

}
