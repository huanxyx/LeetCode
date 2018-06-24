package com.xyx.leetcode.solution;

//24. Swap Nodes in Pairs
public class Solution024 {
	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		ListNode prev = dummyHead;
		dummyHead.next = head;
		
		ListNode cur = head;
		
		while (cur != null && cur.next != null) {
			prev.next = cur.next;
			cur.next = prev.next.next;
			prev.next.next = cur;
			prev = cur;
			cur = cur.next;
		}
		return dummyHead.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
