package com.example.leetcode;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
            } else if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
