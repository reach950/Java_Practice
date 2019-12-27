package com.example.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        String[] symbols = new String[]{"+", "-", "*", "/"};
        List<String> list = Arrays.asList(symbols);
        for (String token : tokens) {
            if (list.contains(token)) {
                int left = stack.pop();
                int right = stack.pop();
                if ("+".equals(token)) {
                    stack.push(right + left);
                } else if ("-".equals(token)) {
                    stack.push(right - left);
                } else if ("*".equals(token)) {
                    stack.push(right * left);
                } else if ("/".equals(token)) {
                    stack.push(right / left);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
