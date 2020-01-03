package com.example.leetcode.binary_tree;

public class InvertBinaryTree {
    //由上向下递归
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode n = root.left;
        root.left = root.right;
        root.right = n;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    //DFS
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
