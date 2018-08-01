package com.xyx.leetcode.solution;

//92. Reverse Linked List II
public class Solution092 {
    /*
    * 若是考虑非法情况，则需要判断
    *           1. m <= n
    *           2. len(list) >= n：因此不能一次性逆转，需要先获取链表的长度，判断它的长度是否满足要求
    * */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) return head;

        //虚拟头部
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode preNode = dummy;

        //找到第m-1个的位置
        for (int i = 0; i < m - 1; i++)
            preNode = preNode.next;
        ListNode tail = preNode.next;          //存储着逆转后尾部
        ListNode then = tail.next;             //存储着当前应该逆转的元素
        //preNode.next存储着逆转后的头部
        for (int i = 0; i < n - m; i++) {
            //核心代码
            {
                tail.next = then.next;
                then.next = preNode.next;
                preNode.next = then;
            }
            then = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Solution092().reverseBetween(head, 2, 4);
    }
}
