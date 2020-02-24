package com.example.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LinkedList {
    //206. Reverse Linked List 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    //反转链表递归实现
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    //24. Swap Nodes in Pairs 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode prev = start;
        prev.next = head;
        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next;
            ListNode b = a.next;
            ListNode temp = b.next;
            b.next = a;
            a.next = temp;
            prev.next = b;
            prev = a;
        }
        return start.next;
    }

    //141. Linked List Cycle 判断链表是否有环
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //25. Reverse Nodes in k-Group k个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode start, prevSubTail, subHead, subTail, nextSubHead;
        start = prevSubTail = new ListNode(0);
        start.next = head;
        subHead = subTail = head;
        while (subHead != null) {
            for (int i = 0; i < k - 1; i++) {
                if (subTail == null) {
                    return start.next;
                }
                subTail = subTail.next;
            }
            nextSubHead = subTail.next;
            //将子链表的tail的next指针设为null,反转链表
            subTail.next = null;
            reverseList(subHead);
            //把子链表接起来,此时的subHead为反转后的tail,subTail为反转后的head
            prevSubTail.next = subTail;
            subHead.next = nextSubHead;
            //将prevSubTail更新子链表的tail,subHead,subTail更新到下一个子链表的head
            prevSubTail = subHead;
            subHead = subTail = nextSubHead;
        }
        return start.next;
    }

    //23. Merge k Sorted Lists合并K个排序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode start = new ListNode(0);
        ListNode cur = start;

        for (ListNode n : lists) {
            if (n != null) {
                queue.offer(n);
            }
        }

        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return start.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
