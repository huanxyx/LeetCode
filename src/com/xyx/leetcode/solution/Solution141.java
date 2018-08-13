package com.xyx.leetcode.solution;

//141. Linked List Cycle
public class Solution141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
    * 设置快慢指针，有环的话则一定会相遇
    * */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        //不用考虑起始节点
        while (fast != null && fast.next != null && (fast = fast.next.next) != (slow = slow.next));
        return fast == slow;
    }
}
