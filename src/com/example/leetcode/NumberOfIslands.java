package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += dfs(grid, i, j);
            }
        }
        return count;
    }

    private int dfs(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == '0') {
            return 0;
        }
        grid[row][column] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, row + dx[i], column + dy[i]);
        }
        return 1;
    }

    private int bfs(char[][] grid, int row, int column) {
        if (grid[row][column] == '0') {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, column});
        while (q.size() > 0) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            grid[x][y] = '0';
            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == '1') {
                    q.offer(new int[]{x1, y1});
                }
            }

        }
        return 1;
    }
}
