package dynamicProgramming;

public class Trap {

    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        trap(new int[]{4,2,0,3,2,5});
    }


    /**
     * 接雨水 —— 动态规划
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int result = 0;

        // 存水高度
        int[] value = new int[height.length];

        value[0] = 0;
        value[height.length - 1] = 0;

        // 当前位置左侧的最高高度
        int[] leftHeight = new int[height.length];
        // 当前位置右侧的最高高度
        int[] rightHeight = new int[height.length];

        // 初始化
        leftHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
        }

        rightHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            value[i] = Math.min(leftHeight[i - 1], rightHeight[i + 1]) - height[i];
            if (value[i] > 0) {
                result += value[i];
            }
        }

        return result;
    }
}
