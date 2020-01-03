package com.example.leetcode;

public class MinimumPathSum {

    int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 5}, {3, 2, 1}};
        System.out.println(new MinimumPathSum().minPathSum2(grid));
    }

    //动态规划
    public int minPathSum1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    //回溯
    public int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        helper(grid, 0, 0, 0);
        return minSum;
    }

    private void helper(int[][] grid, int i, int j, int sum) {
        if (i >= grid.length || j >= grid[i].length) {
            return;
        }
        sum += grid[i][j];
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            if (sum < minSum) {
                minSum = sum;
            }
        }
        helper(grid, i + 1, j, sum);
        helper(grid, i, j + 1, sum);
    }
}
