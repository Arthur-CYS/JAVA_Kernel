package dynamicProgramming;

public class ClimbStairs {

    public static void main(String[] args) {
        climbStairs(1);
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        // dp[i] 代表一共i个台阶，有多少种方法可以爬到楼顶
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
