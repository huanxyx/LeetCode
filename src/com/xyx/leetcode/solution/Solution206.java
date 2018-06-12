package com.xyx.leetcode.solution;

//206. Reverse Linked List
public class Solution206 {
	public ListNode reverseList(ListNode head) {
		ListNode curNode = head;
		ListNode lastNode = null;
		
		while(curNode != null) {
			ListNode tmp = curNode.next;
			curNode.next = lastNode;
			lastNode = curNode;
			curNode = tmp;
		}
		return lastNode; 
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
