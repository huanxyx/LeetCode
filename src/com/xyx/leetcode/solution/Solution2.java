package com.xyx.leetcode.solution;

//2.Add Two Numbers
public class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		//虚拟头部
		ListNode resultList = new ListNode(0);		
		ListNode currentNode1 = l1, currentNode2 = l2, preNode = resultList;
		
		int carry = 0;						//进位
		while(currentNode1 != null || currentNode2 != null) {
			int sum = carry;
			if (currentNode1 != null) {
				sum += currentNode1.val;
				currentNode1 = currentNode1.next;
			}
			if (currentNode2 != null) {
				sum += currentNode2.val;
				currentNode2 = currentNode2.next;
			}

			carry = sum / 10;
		
			preNode.next = new ListNode(sum % 10);
			preNode = preNode.next;		
		}
		if (carry > 0) {
			preNode.next = new ListNode(carry);
		}
		
		return resultList.next;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
}
