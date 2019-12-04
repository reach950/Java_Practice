package com.example.leetcode;

public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit1(prices));
    }

    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size < 2) {
            return 0;
        }
        int[][][] maxProfit = new int[size][3][2];
        maxProfit[0][0][0] = 0;
        maxProfit[0][0][1] = -prices[0];

        maxProfit[0][1][0] = 0;
        maxProfit[0][1][1] = -prices[0];

        maxProfit[0][2][0] = 0;
        for (int i = 1; i < size; i++) {
            maxProfit[i][0][0] = maxProfit[i - 1][0][0];
            maxProfit[i][0][1] = Math.max(maxProfit[i - 1][0][1], maxProfit[i - 1][0][0] - prices[i]);

            maxProfit[i][1][0] = Math.max(maxProfit[i - 1][1][0], maxProfit[i - 1][0][1] + prices[i]);
            maxProfit[i][1][1] = Math.max(maxProfit[i - 1][1][1], maxProfit[i - 1][1][0] - prices[i]);

            maxProfit[i][2][0] = Math.max(maxProfit[i - 1][2][0], maxProfit[i - 1][1][1] + prices[i]);
        }
        return Math.max(Math.max(maxProfit[size - 1][0][0], maxProfit[size - 1][1][0]), maxProfit[size - 1][2][0]);

    }

    public int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }
}
