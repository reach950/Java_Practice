package com.example.leetcode;

public class StringToInteger {
    public static void main(String[] args) {
        String str = "20000000000000000000";
        System.out.println(new StringToInteger().myAtoi(str));
    }

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int index = 0, sign = 1, total = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int num = str.charAt(index) - '0';
            if (num < 0 || num > 9) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < num)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + num;
            index++;
        }
        return total * sign;
    }
}
