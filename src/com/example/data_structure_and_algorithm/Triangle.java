package com.example.data_structure_and_algorithm;


import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] status = new int[size];
        for (int i = 0; i < size; i++) {
            status[i] = triangle.get(size - 1).get(i);
        }
        for (int j = size - 2; j >= 0; j--) {
            for (int k = 0; k < triangle.get(j).size(); k++) {
                status[k] = Math.min(status[k], status[k + 1]) + triangle.get(j).get(k);
            }
        }
        return status[0];
    }
}
