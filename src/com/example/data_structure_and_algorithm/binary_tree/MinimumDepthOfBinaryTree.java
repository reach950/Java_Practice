package com.example.data_structure_and_algorithm.binary_tree;

public class MinimumDepthOfBinaryTree {
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return minDepth;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && depth < minDepth) {
            minDepth = depth;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }
}
