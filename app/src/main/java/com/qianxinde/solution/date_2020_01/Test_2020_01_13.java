package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_13 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));
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

    /**
     * 5143. 解压缩编码列表
     * 给你一个以行程长度编码压缩的整数列表 nums 。
     * 考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
     * 请你返回解压后的列表。
     *
     * @param nums 整数列表
     * @return 解压后结果
     */
    private static int[] decompressRLElist(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                integers.add(nums[i + 1]);
            }
        }
        int[] ans = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ans[i] = integers.get(i);
        }
        return ans;
    }
}
