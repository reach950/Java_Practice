package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    List<List<String>> result = new ArrayList<>();
    List<int[]> res = new ArrayList<>();

    public static void main(String[] args) {
//        List<List<String>> res = new NQueens().solveNQueens(4);
//        System.out.println(res);
        NQueens nqs = new NQueens();
        nqs.bitSolve(4, 0, 0, 0, 0, new int[4]);
        for (int[] array : nqs.res) {
            System.out.println(Arrays.toString(array));
        }
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

    private void bitSolve(int n, int row, int column, int pie, int na, int[] queens) {
        if (row >= n) {
            res.add(queens.clone());
            return;
        }
        int bits = (~(column | pie | na)) & ((1 << n) - 1);
        while (bits > 0) {
            int p = bits & -bits;
            queens[row] = p;
            bitSolve(n, row + 1, column | p, (pie | p) << 1, (na | p) >> 1, queens);
            bits &= bits - 1;
        }
    }
}
