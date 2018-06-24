package com.xyx.leetcode.solution;

//82. Remove Duplicates from Sorted List II
public class Solution082 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode lastNode = dummy;
		
		while (lastNode.next != null) {
			ListNode curNode = lastNode.next;
			int curValue = curNode.val;
			ListNode end = curNode; 
			//找到最后一个与curNode值相同的元素
			while (end.next != null && end.next.val == curValue) 
				end = end.next;
			//判断是否只有一个相同的值
			if (end == curNode)
				lastNode = curNode;
			else
				lastNode.next = end.next;
		}
		return dummy.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
