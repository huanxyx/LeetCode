package com.xyx.leetcode.solution;

//19. Remove Nth Node From End of List
public class Solution019 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		return solution1(head, n);
	}
	
	//一遍遍历（双指针）
	private ListNode solution1(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		//初始化两个指针的距离为n+1，即倒数第n+1个数。
		for (int i = 0; i <= n; i++)
			second = second.next;
		
		while (second != null) {
			first = first.next;
			second = second.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}
	
	//两遍遍历
	private ListNode solution2(ListNode head, int n) {
		int totalLen = getLen(head);
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curNode = dummy;
		int count = totalLen - n;
		while(count > 0) {
			curNode = curNode.next;
			count--;
		}
		curNode.next = curNode.next.next;		
		return dummy.next;
	}
	
	private int getLen(ListNode head) {
		ListNode curNode = head;
		int totalLen = 0;
		while (curNode != null) {
			totalLen++;
			curNode = curNode.next;
		}
		return totalLen;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}