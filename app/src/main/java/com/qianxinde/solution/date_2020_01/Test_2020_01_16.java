package com.qianxinde.solution.date_2020_01;

import java.util.HashMap;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_16 {

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));

        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"},
                "hlabcdefgijkmnopqrstuvwxyz"));
    }

    /**
     * 941. 有效的山脉数组
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
     * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     * A.length >= 3
     * 在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[B.length - 1]
     *
     * @param A 数组
     * @return 是否为山脉数组
     */
    private static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int left = 0, right = A.length - 1;
        while (left < right - 1 && A[left] < A[left + 1]) {
            left++;
        }
        while (right > 1 && A[right] < A[right - 1]) {
            right--;
        }
        return left == right;
    }

    /**
     * 953. 验证外星语词典
     * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
     * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，
     * 返回 true；否则，返回 false。
     *
     * @param words 字符串数组
     * @param order 字典
     * @return 是否按照字典排序
     */
    private static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            hashMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s1.equals(s2)) {
                continue;
            }
            if (s1.startsWith(s2)) {
                return false;
            }
            int length = Math.min(s1.length(), s2.length());
            for (int j = 0; j < length; j++) {
                int index1 = hashMap.get(s1.charAt(j));
                int index2 = hashMap.get(s2.charAt(j));
                if (index1 < index2) {
                    break;
                } else {
                    return false;
                }
            }

        }
        return true;
    }
}
