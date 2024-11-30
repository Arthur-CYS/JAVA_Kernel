package doublePointer;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    /**
     * 未实现
     *
     * @param args
     */
    public static void main(String[] args) {

    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int target = -nums[i];

        }

        // 找到0的索引值
        int zeroIndex = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            }
            if (nums[i] > 0) {
                zeroIndex = i;
                break;
            }
        }

        // 三指针，核心逻辑
        // 负数
        int i = 0;
        // 正数
        int j = nums.length - 1;

        while (i <= zeroIndex) {
            int count = nums[i] + nums[j];
            if (count == 0) {
                if (nums[zeroIndex] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[zeroIndex]);
                }
                // 循环

            }
            if (count > 0) {
                j--;
                continue;
            }
            if (count < 0) {
                i ++;
                continue;
            }

        }






        List<List<Integer>> resultList = resultSet.stream()
                .collect(Collectors.toList());

        return resultList;
    }
}
