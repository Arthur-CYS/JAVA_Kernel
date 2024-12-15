package dynamicProgramming;

public class CoinChange {

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
        int[] coins = {186,419,83,408};
        coinChange(coins, 6249);
    }

    public static int coinChange(int[] coins, int amount) {
        // dp[i]表示amount为i时，最小的数量
        int[] dp = new int[amount + 1];

        dp[0] = 0;
        if (amount == 0) return 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            // 找到dp[i - coin[0]], dp[i - coin[1]], dp[i - coin[2]] 三个的最小值
            // 找到dp[i - 1], dp[i - 2], dp[i - 5] 三个的最小值
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if (dp[amount] > amount) return -1;
        else return dp[amount];
    }
}
