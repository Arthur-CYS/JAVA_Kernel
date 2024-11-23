package hashLeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int[] nums1 = new int[]{1,2,0,1};
        longestConsecutivePre(nums1);
    }

    public static int longestConsecutive(int[] nums) {
        int result = 1;

        if (nums == null || nums.length == 0) return 0;

        // 去重
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        for (Integer num : num_set) {
            if (map.containsKey(num)) {
                continue;
            }

            int count = 1;
            if (map.get(num - 1) != null) {
                count += map.get(num - 1);
            }
            if (map.get(num + 1) != null) {
                count += map.get(num + 1);
            }
            map.put(num, count);

            if (count > result) {
                result = count;
            }

            // 遍历更新
            int index = num;
            while (true) {
                index ++;
                if (map.get(index) != null) {
                    map.put(index, count);
                } else {
                    break;
                }
            }
            while (true) {
                index --;
                if (map.get(index) != null) {
                    map.put(index, count);
                } else {
                    break;
                }
            }
        }
        return result;
    }


    public static int longestConsecutivePre(int[] nums) {
        int result =0;
        if (nums == null || nums.length == 0) return result;

        // 去重
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }


        for (int num : num_set) {
            if (! num_set.contains(num - 1)) {
                // 最前置节点
                int currentNum = num;
                int count = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum ++;
                    count ++;
                }

                if (count > result) {
                    result = count;
                }
            }

        }

        System.out.println(result);

        return result;

    }
}
