package com.example.data_structure_and_algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    Set<String> res = new HashSet<>();

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = new char[][]{{'a', 'b'}};
        String[] words = {"ba"};
        WordSearch ws = new WordSearch();
        ws.findWords(board, words);
        System.out.println(ws.res);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        boolean[][] isVisit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, trie, "", isVisit);
            }
        }
        return new ArrayList<>(res);
    }

    public void helper(char[][] board, int i, int j, Trie trie, String s, boolean[][] isVisit) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (isVisit[i][j]) {
            return;
        }
        s += board[i][j];
        if (!trie.startsWith(s)) {
            return;
        }
        if (trie.search(s)) {
            res.add(s);
        }
        isVisit[i][j] = true;
        helper(board, i - 1, j, trie, s, isVisit);
        helper(board, i, j - 1, trie, s, isVisit);
        helper(board, i + 1, j, trie, s, isVisit);
        helper(board, i, j + 1, trie, s, isVisit);
        isVisit[i][j] = false;
    }
}
