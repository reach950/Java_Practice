package com.example.leetcode;

public class FriendCircles {

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
        };
        System.out.println(new FriendCircles().findCircleNum(M));
    }

    class UnionFind {
        private int[] roots;
        private int count;

        UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
            count = n;
        }

        private int findRoot(int i) {
            int root = i;
            while (root != roots[root]) {
                root = roots[root];
            }
            while (i != roots[i]) {
                int temp = roots[i];
                roots[i] = root;
                i = temp;
            }
            return root;
        }

        void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (pRoot == qRoot) {
                return;
            }
            roots[pRoot] = qRoot;
            count--;
        }

        int getCount() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}
