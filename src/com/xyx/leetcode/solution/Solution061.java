package com.xyx.leetcode.solution;

//61. Rotate List
public class Solution061 {
	/*
	 * 通过两个指针找到末尾k个节点的前一个节点，
	 * 记得考虑k==0，k>len，head==null的情况
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		int len = getLen(head);
		k = k % len;
		if (k != 0) {
			ListNode dummyHead = new ListNode(0);
			dummyHead.next = head;
			ListNode fastP = dummyHead;
			ListNode slowP = dummyHead;
			
			//fastP先走k步
			for (int i = 0; i < k; i++) 
				fastP = fastP.next;
			//slowP表示前一部分的最后一个位置
			while (fastP.next != null) {
				slowP = slowP.next;
				fastP = fastP.next;
			}
			ListNode rotateHead = slowP.next;
			slowP.next = null;
			fastP.next = dummyHead.next;
			return rotateHead;
		}
		return head;
	}
	
	private static int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		
		return len;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
