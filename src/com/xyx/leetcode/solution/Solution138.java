package com.xyx.leetcode.solution;

//138. Copy List with Random Pointer
public class Solution138 {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        //后接复制节点
        RandomListNode node = head;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }

        //更新随机字段
        node = head;
        while (node != null) {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }

        //拆分
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        node = head;
        while (node != null) {
            cur.next = node.next;
            cur = cur.next;
            node.next = node.next.next;
            node = node.next;
        }
        return dummy.next;
    }
}
