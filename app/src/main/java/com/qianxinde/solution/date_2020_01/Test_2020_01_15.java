package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_15 {

    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2, 3, 10));

        System.out.println(readBinaryWatch(1));

        System.out.println(numSpecialEquivGroups(new String[]{"abcd", "cdab", "adcb", "cbad"}));
    }

    /**
     * 970. 强整数
     * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，
     * 其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
     * 返回值小于或等于 bound 的所有强整数组成的列表。
     * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
     *
     * @param x     正整数
     * @param y     正整数
     * @param bound 边界
     * @return 强整数列表
     */
    private static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        //以2，3，10为例题。
        //a的值为1,2,4,8，b的值为1，3，9。实则为x，y符合条件的平方数。省略每次中间多余运算部分。
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
                //为了y的多次平方都为1的情况。
                if (y == 1) {
                    break;
                }
            }
            //为了x的多次平方都为1的情况。
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 401. 二进制手表
     * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
     * 每个 LED 代表一个 0 或 1，最低位在右侧。
     *
     * @param num 亮灯个数
     * @return 可能的时间
     */
    private static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount((i << 6) | j) == num) {
                    list.add(i + ":" + (j > 9 ? "" : "0") + j);
                }
            }
        }
        return list;
    }

    /**
     * 896. 单调数列
     * 如果数组是单调递增或单调递减的，那么它是单调的。
     * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
     * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
     * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
     *
     * @param A 数组
     * @return 判断是否为单调数组
     */
    private boolean isMonotonic(int[] A) {
        boolean isUp = true;
        boolean isDown = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                isUp = false;
            }
            if (A[i] < A[i + 1]) {
                isDown = false;
            }
        }
        return isUp || isDown;
    }

    /**
     * 893. 特殊等价字符串组
     * 你将得到一个字符串数组 A。
     * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
     * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
     * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，
     * 这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
     * 返回 A 中特殊等价字符串组的数量。
     *
     * @param A 字符串
     * @return 等价字符串组的数量
     */
    private static int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        for (String s : A) {
            long a = 0;
            long b = 0;
            char[] words = s.toCharArray();
            for (int i = 0; i < words.length; i++) {
                if (i % 2 == 0) {
                    a *= words[i];
                } else {
                    b *= words[i];
                }
            }
            set.add(a + "+" + b);
        }
        return set.size();
    }
}
