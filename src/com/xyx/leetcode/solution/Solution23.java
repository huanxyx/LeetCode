package com.xyx.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

// 23.Merge k Sorted Lists
public class Solution23 {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(new NodeComparator());
		for (ListNode node : lists) {
			while (node != null) {
				pQueue.offer(node);
				node = node.next;
			}
		}
		
		ListNode dummyNode = new ListNode(0);
		ListNode curNode = dummyNode;
		while (!pQueue.isEmpty()) {
			ListNode temp = pQueue.poll();
			curNode.next = temp;
			curNode = temp;
		}
		curNode.next = null;
		return dummyNode.next;
	}
	
	public static class NodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	//test
	public static void main(String[] args) {
		ListNode[] list = new ListNode[] {createListNode()};
		ListNode mergeKLists = new Solution23().mergeKLists(list);
		printListNode(mergeKLists);
	}
	
	//for test
	public static void printListNode(ListNode headNode) {
		ListNode cur = headNode;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	
	//for test
	public static ListNode createListNode() {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int i = 0; i < 20; i++) {
			ListNode temp = new ListNode((int) (Math.random() * 100));
			cur.next = temp;
			cur = temp;
		}
		return dummy.next;
	}
}
