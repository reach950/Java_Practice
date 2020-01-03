package com.example.leetcode;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new ReverseWordsInAString().reverseWords2(s));
    }

    public String reverseWords1(String s) {
        if (s.trim().equals("")) {
            return "";
        }
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (!ss[i].trim().equals("")) {
                sb.append(ss[i]).append(" ");
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(s, j + 1, i + 1).append(" ");
            i = j - 1;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
