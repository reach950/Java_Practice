package com.example.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
    }

    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int res = 0;
        while (n > 0) {
            res = a + b;
            a = b;
            b = res;
            n--;
        }
        return res;
    }

}
