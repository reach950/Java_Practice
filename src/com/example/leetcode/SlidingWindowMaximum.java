package com.example.leetcode;

import java.util.*;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow1(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        Queue<Integer> q = new PriorityQueue<>(k, (a, b) -> b - a);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = q.peek();
                q.remove(nums[i - k + 1]);
            }
        }
        return result;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]) {
                deque.removeFirst();
            }
            deque.addFirst(i);
            if (i >= k && i - k >= deque.getLast()) {
                deque.removeLast();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getLast()];
            }
        }
        return result;

    }
}
