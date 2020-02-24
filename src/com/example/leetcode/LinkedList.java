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

    //23. Merge k Sorted Lists 合并K个排序链表
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

    //2. Add Two Numbers 两数相加
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

    //19. Remove Nth Node From End of List 删除链表的倒数第N个节点
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
