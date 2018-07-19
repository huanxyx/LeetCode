package com.xyx.leetcode.solution;

//25. Reverse Nodes in k-Group
public class Solution025 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(1);
		dummy.next = head;
		
		ListNode cur = reversePart(dummy, k);
		while (cur != null) {
			cur = reversePart(cur, k);
		}
		return dummy.next;
	}
	
	//逆序一个部分，同时返回反转后的后端
	public ListNode reversePart(ListNode beforeHead, int k) {
		ListNode rear = beforeHead;
		//找到当前部分的尾部,若是数量不够，则返回空
		int w = k;
		while (w > 0 && rear.next != null) {
			rear = rear.next;
			w--;
		}
		
		if (w > 0)
			return null;						//返回null表示长度不够
			
		ListNode nextPart = rear.next;			//下一个部分的头部
			
		ListNode dummy = new ListNode(0);		//虚拟头部
		ListNode newRear = beforeHead.next;		//逆转后的尾部
		
		ListNode cur = beforeHead.next;			
		for (int i = 0; i < k; i++) {
			ListNode next = cur.next;				//保存剩余的部分
			cur.next = dummy.next;
			dummy.next = cur;
			cur = next;
		}
		
		beforeHead.next = dummy.next;
		newRear.next = nextPart;
		
		return newRear;
	}

}
