package com.example.data_structure_and_algorithm;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        helper(n, 0, queens);
        return result;
    }

    private void helper(int n, int row, int[] queens) {
        if (row == n) {
            List<String> list = generateStringQueens(queens);
            result.add(list);
            return;
        }
        for (int column = 0; column < n; column++) {
            if (isValid(row, column, queens)) {
                queens[row] = column;
                helper(n, row + 1, queens);
            }
        }
    }

    private boolean isValid(int row, int column, int[] queens) {
        for (int i = row - 1; i >= 0; i--) {
            if (queens[i] == column) {
                return false;
            }
            if (i + queens[i] == row + column) {
                return false;
            }
            if (queens[i] - i == column - row) {
                return false;
            }
        }
        return true;
    }

    private List<String> generateStringQueens(int[] queens) {
        List<String> stringQueens = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (j == queens[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            stringQueens.add(sb.toString());
        }
        return stringQueens;
    }
}
