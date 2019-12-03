package com.example.data_structure_and_algorithm;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS1(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }

        int[] lis = new int[size];
        for (int i = 0; i < size; i++) {
            lis[i] = 1;
        }

        int res = 1;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            res = Math.max(res, lis[i]);
        }
        return res;
    }

    //n log n算法
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] lis = new int[nums.length];
        lis[0] = nums[0];
        int size = 1;
        for (int num : nums) {
            int begin = 0, end = size - 1;
            while (begin <= end) {
                int mid = begin + (end - begin) / 2;
                if (lis[mid] < num) {
                    begin = mid + 1;
                } else {
                    if (mid == 0 || lis[mid - 1] < num) {
                        lis[mid] = num;
                        break;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            if (begin > end) {
                lis[size++] = num;
            }

        }
        return size;
    }
}
