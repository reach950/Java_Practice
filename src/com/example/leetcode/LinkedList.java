package com.example.leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LinkedList {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode prev, start, headK, tailK, a, b, temp;
        start = tailK = new ListNode(0);
        headK = a = b = head;
        int count;
        while (true) {
            count = 0;
            while (a != null && count < k) {
                count++;
                a = a.next;
            }
            if (count == k) {
                prev = null;
                for (int i = 0; i < k; i++) {
                    temp = b.next;
                    b.next = prev;
                    prev = b;
                    b = temp;
                }
                tailK.next = prev;
                tailK = headK;
                headK = b;
            } else {
                tailK.next = b;
                return start.next;
            }
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
