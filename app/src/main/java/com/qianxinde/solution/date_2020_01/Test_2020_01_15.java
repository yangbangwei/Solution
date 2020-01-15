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

        System.out.println(findJudge(2, new int[][]{{1, 2}}));
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

    /**
     * 997. 找到小镇的法官
     * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
     * 如果小镇的法官真的存在，那么：
     * 小镇的法官不相信任何人。
     * 每个人（除了小镇法官外）都信任小镇的法官。
     * 只有一个人同时满足属性 1 和属性 2 。
     * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
     * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
     *
     * @param N     人数
     * @param trust 相信记录
     * @return 法官身份
     */
    private static int findJudge(int N, int[][] trust) {
        int[] myself = new int[N + 1];
        int[] believeName = new int[N + 1];
        for (int[] ints : trust) {
            myself[ints[0]]++;
            believeName[ints[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (myself[i] == 0 && believeName[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 944. 删列造序
     * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
     * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，
     * 形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
     *
     * @param A 字符串数组
     * @return 删除的列数
     */
    private int minDeletionSize(String[] A) {
        int num = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    num++;
                    break;
                }
            }
        }
        return num;
    }
}
