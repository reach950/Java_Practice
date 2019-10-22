package com.example.data_structure_and_algorithm;

import java.util.*;

//有效的括号
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(new ValidParentheses().isValid(s));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(c) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
