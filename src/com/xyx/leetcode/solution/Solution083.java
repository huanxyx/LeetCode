package com.xyx.leetcode.solution;

//83. Remove Duplicates from Sorted List
public class Solution083 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		
		ListNode cur = head;
		while (cur != null) {
			ListNode last = cur.next;
			while (last != null && last.val == cur.val) 
				last = last.next;
			cur.next = last;
			cur = last;
		}
		return head;
	}

}
