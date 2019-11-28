package com.example.data_structure_and_algorithm;

public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int count = 0;
            int n = i;
            while (n != 0) {
                n &= n - 1;
                count++;
            }
            res[i] = count;
        }
        return res;
    }

    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & i - 1] + 1;
        }
        return res;
    }
}
