package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        List<String> list = new GenerateParentheses().generateParenthesis(3);
        System.out.println(list);
    }


    public List<String> generateParenthesis(int n) {
        helper(n, "", 0, 0);
        return res;
    }

    private void helper(int n, String s, int left, int right) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            helper(n, s + "(", left + 1, right);
        }
        if (right < left) {
            helper(n, s + ")", left, right + 1);
        }
    }
}
