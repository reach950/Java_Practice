package com.example.leetcode.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

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

    //DFS
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    //BFS
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (n.left == null && n.right == null) {
                    return minDepth;
                }
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
        }
        return minDepth;
    }
}
