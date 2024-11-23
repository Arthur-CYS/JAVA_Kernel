package hashLeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
     *
     * 你可以按任意顺序返回答案。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
//        twoSum_Loop(nums, target);

        twoSum_Hash(nums, target);

    }


    /**
     * 两重循环嵌套，暴力解决， 时间复杂度N2
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_Loop(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
        return result;
    }

    /**
     * 哈希表，复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_Hash(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            targetMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int targetNum = target - nums[i];
            if (Objects.nonNull(targetMap.get(targetNum))) {
                if (targetMap.get(targetNum) == i) {
                    continue;
                }
                result[0] = i;
                result[1] = targetMap.get(targetNum);
            }
        }

        System.out.println(result[0] + " " + result[1]);

        return result;
    }


}
