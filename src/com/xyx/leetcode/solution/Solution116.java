package com.xyx.leetcode.solution;

//116. Populating Next Right Pointers in Each Node
public class Solution116 {


    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        subConnect(root, null);
    }

    /**
     * 递归实现
     * @param left   上一个节点
     * @param right  下一个节点
     */
    private void subConnect(TreeLinkNode left, TreeLinkNode right) {
        if (left == null) return ;
        left.next = right;
        subConnect(left.left, left.right);
        //等于空的情况下不用考虑了，因为next初始化为Null
        if (right != null) {
            subConnect(left.right, right.left);
            subConnect(right.left, right.right);
        }
    }

    /**
     * 循环实现：每次连接一行节点
     * @param root
     */
    private void connectNoRecur(TreeLinkNode root) {
        if (root == null) return ;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while (pre.left != null) {
            cur = pre;
            //基于上一次已经连接起来的节点
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}
