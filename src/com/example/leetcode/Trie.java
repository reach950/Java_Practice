package com.example.leetcode;

class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode('/');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode p = this.root;
        for (char c : wordArray) {
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(c);
            }
            p = p.children[index];
        }
        p.isEnding = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode p = this.root;
        for (char c : charArray) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEnding;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode p = this.root;
        for (char c : charArray) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return true;
    }
}

class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    boolean isEnding = false;

    TrieNode(char data) {
        this.data = data;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */