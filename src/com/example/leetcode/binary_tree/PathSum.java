package com.example.leetcode.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    // DFS
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

    // BFS
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> prevSum = new LinkedList<>();
        q.offer(root);
        prevSum.offer(0);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            int s = prevSum.poll();
            if (n.left == null && n.right == null && n.val == sum - s) {
                return true;
            }
            if (n.left != null) {
                q.offer(n.left);
                prevSum.offer(s + n.val);
            }
            if (n.right != null) {
                q.offer(n.right);
                prevSum.offer(s + n.val);
            }
        }
        return false;
    }
}
