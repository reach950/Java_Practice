package com.example.data_structure_and_algorithm;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int[][] dpStatus = new int[2][2];
        dpStatus[0][0] = nums[0];
        dpStatus[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpStatus[1][0] = Math.max(Math.max(dpStatus[0][0] * nums[i], dpStatus[0][1] * nums[i]), nums[i]);
            dpStatus[1][1] = Math.min(Math.min(dpStatus[0][0] * nums[i], dpStatus[0][1] * nums[i]), nums[i]);
            res = Math.max(dpStatus[1][0], res);
            dpStatus[0][0] = dpStatus[1][0];
            dpStatus[0][1] = dpStatus[1][1];
        }
        return res;
    }
}
