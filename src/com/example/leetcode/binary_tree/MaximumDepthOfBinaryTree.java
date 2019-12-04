package com.example.leetcode.binary_tree;

public class MaximumDepthOfBinaryTree {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        helper(root, 1);
        return maxDepth;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }
}
