package dynamicProgramming;

public class Rob {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int[] nums1 = new int[]{2,7,9,3,1};
        rob(nums);
        rob(nums1);
    }

    /**
     * 打家劫舍
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int result = 0;

        // 定义偷到第i户人家的最大值
        // 0:不偷该户
        // 1: 偷该户
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        result = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            if (dp[i][0] > result) result = dp[i][0];
            if (dp[i][1] > result) result = dp[i][1];
        }

        return result;
    }
}
