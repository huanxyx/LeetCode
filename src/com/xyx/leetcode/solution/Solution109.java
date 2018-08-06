package com.xyx.leetcode.solution;

//109. Convert Sorted List to Binary Search Tree
public class Solution109 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        return construct(head, null);
    }

    //范围包含头部，不包含尾部
    private TreeNode construct(ListNode head, ListNode tail) {
        if (tail == head) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        root.left = construct(head, slow);
        root.right = construct(slow.next, tail);
        return root;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);

        new Solution109().sortedListToBST(l);
    }
}
