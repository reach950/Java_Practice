package com.example.leetcode;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] dp_status = new int[amount + 1];
        for (int i = 0; i < dp_status.length; i++) {
            dp_status[i] = amount + 1;
        }
        dp_status[0] = 0;
        for (int i = 1; i < dp_status.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp_status[i] = Math.min(dp_status[i], dp_status[i - coin] + 1);
                }
            }
        }
        return dp_status[amount] > amount ? -1 : dp_status[amount];
    }
}
