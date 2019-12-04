package com.example.leetcode;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int res = new NumberOf1Bits().hammingWeight1(7);
        System.out.println(res);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
