package hashLeetCode;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        groupAnagramsByCount(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        groupAnagramsByCount(new String[]{"", ""});
        groupAnagramsByCount(new String[]{"ddddddddddg","dgggggggggg"});

        groupAnagramsBySort(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        groupAnagramsBySort(new String[]{"", ""});
        groupAnagramsBySort(new String[]{"ddddddddddg","dgggggggggg"});
    }


    /**
     * 计数算法
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsByCount(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        List<Map<Character, Integer>> strMapList = new ArrayList<>();
        List<String> originalStrList = new ArrayList<>();

        // 构造Map数据
        for (String str : strs) {
            Map<Character, Integer> strMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (Objects.nonNull(strMap.get(str.charAt(i)))) {
                    strMap.put(str.charAt(i), strMap.get(str.charAt(i)) + 1);
                } else {
                    strMap.put(str.charAt(i), 1);
                }
            }
            strMapList.add(strMap);
            originalStrList.add(str);
        }


        Set<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < strMapList.size(); i++) {
            if (indexSet.contains(i)) {
                continue;
            }
            List<String> strList = new ArrayList<>();
            Map<Character, Integer> sourceMap = strMapList.get(i);
            strList.add(originalStrList.get(i));
            for (int j = i + 1; j < strMapList.size(); j++) {
                Map<Character, Integer> targetMap = strMapList.get(j);
                // 之前处理过的，跳过
                if (indexSet.contains(i)) {
                    continue;
                }

                // 确定是否为相同的字符
                if (sourceMap.size() == targetMap.size()) {
                    boolean mark = true;
                    // 判断key的value
                    for (Character key : sourceMap.keySet()) {
                        if (! sourceMap.get(key).equals(targetMap.get(key))) {
                            mark = false;
                            break;
                        }
                    }

                    if (mark) {
                        strList.add(originalStrList.get(j));
                        indexSet.add(j);
                    }
                }

            }
            result.add(strList);
        }
        System.out.println(result);
        return result;
    }

    public static List<List<String>> groupAnagramsBySort(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strSorted = new String(chars);
            if (Objects.nonNull(map.get(strSorted))) {
                map.get(strSorted).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(strSorted, list);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            result.add(list);
        }
        System.out.println(result);
        return result;
    }

}
