package com.xyx.leetcode.solution;

//86. Partition List
public class Solution086 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
    public ListNode partition(ListNode head, int x) {
    	ListNode lessDummy = new ListNode(0);
    	ListNode moreDummy = new ListNode(0);
    	
    	ListNode lessCur = lessDummy;
    	ListNode moreCur = moreDummy;
    	
    	ListNode originCur = head;
    	
    	while (originCur != null) {
    		if (originCur.val < x) {
    			lessCur.next = originCur;
    			lessCur = lessCur.next;
    		} else {
    			moreCur.next = originCur;
    			moreCur = moreCur.next;
    		}
    		originCur = originCur.next;
    	}
    	
    	lessCur.next = moreDummy.next;
    	moreCur.next = null;
    	
    	return lessDummy.next;
    }

}
