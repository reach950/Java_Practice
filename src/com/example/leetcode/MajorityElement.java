package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

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

    //hashtable
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            if (m.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
