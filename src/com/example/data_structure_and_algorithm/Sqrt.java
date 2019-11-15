package com.example.data_structure_and_algorithm;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(1));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid || (mid < x / mid && (mid + 1) > x / (mid + 1))) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
