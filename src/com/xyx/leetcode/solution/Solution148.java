package com.xyx.leetcode.solution;

//148. Sort List
public class Solution148 {
	/*
	 * 有关链表的排序算法
	 * 由于单链表的特殊结构，使用归并排序才能满足条件
	 * 
	 * 如何找到中点：
	 * 		定义两个指针，一个每次走两步，一个每次走一步，当有一个走到了终点的时候停止，
	 * 		走一步的那个指针指向的就是中点
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		//slow代表的就是中点
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//将链表分割成两个部分
		ListNode head1 = head;
		ListNode head2 = slow.next;
		slow.next = null;
		//对两个子链表进行排序
		head1 = sortList(head1);
		head2 = sortList(head2);	
		//合并两个子链表
		return merge(head1, head2);
	}
	
	/*
	 * 合并两个链表
	 */
	private ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(-1);
		
		ListNode cur = dummy;
		while (a != null && b != null) {
			if (a.val < b.val) { 
				cur.next = a;
				a = a.next;
			} else {
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}
		while (a != null) {
			cur.next = a;
			cur = cur.next;
			a = a.next;
		}
		while (b != null) {
			cur.next = b;
			cur = cur.next;
			b = b.next;
		}
		return dummy.next;
	}
	

	/*
	 * 自底向上的非递归实现，真正意义上的O(1)空间复杂度
	 */
	private ListNode solution2(ListNode head) {
		int listLen = getLen(head);
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		for (int size = 1; size < listLen; size <<= 1) {
			ListNode curTail = dummy;
			
			while (curTail.next != null) {
				ListNode firstHead = curTail.next;
				ListNode firstTail = getNextPartTail(curTail, size);
				ListNode secondHead = firstTail.next;
				ListNode secondTail = getNextPartTail(firstTail, size);
				ListNode thirdHead = null;
				
				//分割成两个链表
				firstTail.next = null;
				if (secondTail != null) {
					thirdHead = secondTail.next;
					secondTail.next = null;
				}
				//合并两个链表并将插入到整体的链表当中
				curTail = merge(firstHead, secondHead, thirdHead, curTail);
			}
		}
		return dummy.next;
	}
	
	/*
	 * 每个部分的长度为len，node为上一个部分的的最后一个节点
	 * 该方法返回下一个部分的最后一个节点
	 */
	private ListNode getNextPartTail(ListNode node, int len) {
		while (len != 0 && node.next != null) {
			node = node.next;
			len--;
		}
		return node;
	}
	
	/*
	 * 获取链表的长度
	 */
	private int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
	
	/*
	 * 合并两个链表，并将下一个部分的头部加载合并后链表的后面，
	 * 将该链表插入到前一个部分的尾部的后面，
	 * 返回合并后链表的尾节点
	 */
	private ListNode merge(ListNode a, ListNode b, ListNode nextPartHead, ListNode prePartTail) {
		ListNode dummy = new ListNode(-1);
		
		ListNode cur = dummy;
		while (a != null && b != null) {
			if (a.val < b.val) { 
				cur.next = a;
				a = a.next;
			} else {
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}
		while (a != null) {
			cur.next = a;
			cur = cur.next;
			a = a.next;
		}
		while (b != null) {
			cur.next = b;
			cur = cur.next;
			b = b.next;
		}
		cur.next = nextPartHead;
		prePartTail.next = dummy.next;
		return cur;
	}
	
	//单元测试
	public static void main(String[] args) {
		ListNode create = create(new int[]{-1,5,3,4,0});
		ListNode result = new Solution148().solution2(create);
		print(result);
	}
	
	public static void print(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode create(int[] arr) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i : arr) {
			ListNode temp = new ListNode(i);
			cur.next = temp;
			cur = cur.next;
		}
		return dummy.next;
	}
	

	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	
}

