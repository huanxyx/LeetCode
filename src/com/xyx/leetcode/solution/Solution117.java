package com.xyx.leetcode.solution;

//117. Populating Next Right Pointers in Each Node II
public class Solution117 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        while (root != null) {
            //建立虚拟头部
            TreeLinkNode dummyNode = new TreeLinkNode(0);
            TreeLinkNode curNode = dummyNode;
            //遍历上一行的每一个节点（因为上一行是已经连接好的）
            while (root != null) {
                if (root.left != null) {
                    curNode.next = root.left;
                    curNode = curNode.next;
                }
                if (root.right != null) {
                    curNode.next = root.right;
                    curNode = curNode.next;
                }
                root = root.next;
            }
            root = dummyNode.next;
        }
    }
}
