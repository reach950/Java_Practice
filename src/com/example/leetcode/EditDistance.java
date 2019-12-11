package com.example.leetcode;

public class EditDistance {

    private int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(new EditDistance().minDistance1(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        helper(word1.toCharArray(), word2.toCharArray(), 0, 0, 0);
        return minDistance;
    }

    //回溯
    private void helper(char[] word1, char[] word2, int i, int j, int distance) {
        if (i == word1.length || j == word2.length) {
            if (i < word1.length) {
                distance += word1.length - i;
            }
            if (j < word2.length) {
                distance += word2.length - j;
            }
            if (minDistance > distance) {
                minDistance = distance;
            }
            return;
        }
        if (word1[i] == word2[j]) {
            helper(word1, word2, i + 1, j + 1, distance);
        } else {
            helper(word1, word2, i, j + 1, distance + 1);
            helper(word1, word2, i + 1, j, distance + 1);
            helper(word1, word2, i + 1, j + 1, distance + 1);
        }
    }

    //动态规划
    public int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0){
            return Math.max(m, n);
        }
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int[][] minDist = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                minDist[i][0] = word1Array[i] == word2Array[0] ? 0 : 1;
            } else {
                minDist[i][0] = word1Array[i] == word2Array[0] ? i : minDist[i - 1][0] + 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                minDist[0][j] = word2Array[j] == word1Array[0] ? 0 : 1;
            } else {
                minDist[0][j] = word2Array[j] == word1Array[0] ? j : minDist[0][j - 1] + 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1Array[i] == word2Array[j]) {
                    minDist[i][j] = Math.min(Math.min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1), minDist[i - 1][j - 1]);
                } else {
                    minDist[i][j] = Math.min(Math.min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1), minDist[i - 1][j - 1] + 1);
                }
            }
        }
        return minDist[m - 1][n - 1];
    }

}
