package com.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()()(())";
        System.out.println(new LongestValidParentheses().longestValidParentheses4(s));
    }

    // 解法1，暴力求解O(n^3)
    public int longestValidParentheses1(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    private boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    //解法2，暴力求解优化O(n^2)
    public int longestValidParentheses2(String s) {
        int maxLen = 0;
        int count;
        for (int i = 0; i < s.length() - 1; i++) {
            count = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    count++;
                } else {
                    count--;
                }
                if (count < 0) {
                    break;
                }
                if (count == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    //解法3 动态规划O(n)
    public int longestValidParentheses3(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    //解法3 栈 O(n)
    public int longestValidParentheses4(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}