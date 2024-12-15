package dynamicProgramming;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumSquares {

    public static void main(String[] args) {
        numSquares(13);
    }

    /**
     * 完全平方数 —— 未做完
     *
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int result = 0;

        Set<Integer> squaresSet = new HashSet<>();
        // dp[i] 代表 i 值的完全平方数的最少数量
        int j = 2;
        int frontPowNum = j * j;

        int[] dp = new int[n + 1];
        dp[0] = 0; // 0
        for (int i = 1; i <= n; i++) {
            int powNum = j * j;
            if (i >= powNum) {
                j++;
                frontPowNum = powNum;
            }
            if (i >= frontPowNum) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i - frontPowNum] + 1);

            } else {
                dp[i] = dp[i - 1] + 1;
            }
            System.out.println("i: " + i  + " frontPowNum: " + frontPowNum + " result : " + dp[i]);
        }

        return result;
    }
}
