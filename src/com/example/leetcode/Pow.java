package com.example.leetcode;

public class Pow {
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        if (n == 0) return 1.0;
        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);
    }
}
