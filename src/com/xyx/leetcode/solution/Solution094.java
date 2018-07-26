package com.xyx.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//94. Binary Tree Inorder Traversal
public class Solution094 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
        	//压入最左边所有的节点
        	while (cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	//当为空的时候，意味着已经到了边界位置，然后依次弹出最上面的那个节点并将右节点重复同样的操作
    		cur = stack.pop();
    		res.add(cur.val);
    		cur = cur.right;
        }
        return res;
    }
}
