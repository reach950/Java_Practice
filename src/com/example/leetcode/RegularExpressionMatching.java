package com.example.leetcode;

public class RegularExpressionMatching {

    private boolean matched;

    public static void main(String[] args) {
        String s = "aab";
        String p = "aab*";
        System.out.println(new RegularExpressionMatching().isMatch2(s, p));
    }

    public boolean isMatch1(String s, String p) {
        matched = false;
        helper(s, p, 0, 0);
        return matched;
    }

    //回溯
    private void helper(String s, String p, int sIndex, int pIndex) {
        if (matched) {
            return;
        }
        if (pIndex == p.length()) {
            if (sIndex == s.length()) {
                matched = true;
            }
            return;
        }
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            helper(s, p, sIndex, pIndex + 2);
            if (sIndex < s.length() && p.charAt(pIndex) == '.') {
                for (int i = 1; i <= s.length() - sIndex; i++) {
                    helper(s, p, sIndex + i, pIndex + 2);
                }
            } else if (sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex)) {
                int i = 1;
                for (; i < s.length() - sIndex; i++) {
                    if (s.charAt(sIndex + i) == s.charAt(sIndex)) {
                        helper(s, p, sIndex + i, pIndex + 2);
                    } else {
                        break;
                    }
                }
                helper(s, p, sIndex + i, pIndex + 2);
            }
        } else {
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
                helper(s, p, sIndex + 1, pIndex + 1);
            }
        }
    }

    //动态规划
    public boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();

        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                if (curS == curP || curP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (curP == '*') {
                    char prevP = p.charAt(j - 2);
                    if (prevP != curS && prevP != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i - 1][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
