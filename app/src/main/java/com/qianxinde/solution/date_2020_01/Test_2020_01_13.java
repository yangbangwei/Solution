package com.qianxinde.solution.date_2020_01;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_13 {

    public static void main(String[] args) {

    }

    /**
     * 5307. 将整数转换为两个无零整数的和
     * 「无零整数」是十进制表示中 不含任何 0 的正整数。
     * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
     * A 和 B 都是无零整数
     * A + B = n
     * 题目数据保证至少有一个有效的解决方案。
     * 如果存在多个有效解决方案，你可以返回其中任意一个。
     *
     * @param n 整数
     * @return 符合的结果
     */
    private int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int num = n - i;
            if (!String.valueOf(i).contains("0")
                    && !String.valueOf(num).contains("0")) {
                return new int[]{i, num};
            }
        }
        return null;
    }
}
