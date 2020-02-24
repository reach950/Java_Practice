package com.example.leetcode;


import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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

    // 24. Swap Nodes in Pairs 两两交换链表中的节点
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

    //141. Linked List Cycle 判断链表是否有环(用快慢指针实现，空间复杂度O(1))
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

    //判断链表是否有环,哈希表实现
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    //25. Reverse Nodes in k-Group k个一组翻转链表
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

    //25. Reverse Nodes in k-Group k个一组翻转链表
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prevSubTail = start, subHead = head, subTail = head, nextSubHead = null;
        while (subHead != null) {
            for (int i = 0; i < k - 1; i++) {
                subTail = subTail.next;
                if (subTail == null) {
                    return start.next;
                }
            }
            nextSubHead = subTail.next;

            //反转一组子链表
            ListNode newSubHead = null;
            ListNode curr = subHead;
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = curr.next;
                curr.next = newSubHead;
                newSubHead = curr;
                curr = temp;
            }

            //将反转的子链表与前后两个子链表接起来
            prevSubTail.next = newSubHead;
            subTail.next = nextSubHead;
            //更新前一个子链表的tail，此时subHead是子链表的tail
            prevSubTail = subHead;
            //更新子链表的head与tail
            subHead = nextSubHead;
            subTail = nextSubHead;
        }
        return start.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode curr = start;
        ListNode l1Curr = l1, l2Curr = l2;
        int v = 0;//进位

        while (l1Curr != null || l2Curr != null) {
            int l1Val = (l1Curr != null) ? l1Curr.val : 0;
            int l2Val = (l2Curr != null) ? l2Curr.val : 0;
            int sum = l1Val + l2Val + v;
            curr.next = new ListNode(sum % 10);
            v = sum / 10;
            if (l1Curr != null) {
                l1Curr = l1Curr.next;
            }
            if (l2Curr != null) {
                l2Curr = l2Curr.next;
            }
            curr = curr.next;
        }

        if (v > 0) {
            curr.next = new ListNode(v);
        }
        return start.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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
