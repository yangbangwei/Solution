package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-27
 */
public class Test_2019_12_31 {

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));

        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }

    /**
     * 1185. 一周中的第几天
     * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
     * 输入为三个整数：day、month 和 year，分别表示日、月、年。
     * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday",
     * "Wednesday", "Thursday", "Friday", "Saturday"}。
     *
     * @param day   日
     * @param month 月
     * @param year  年
     * @return 周几
     */
    private static String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};
        int[] monday = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int total = day + 4 + monday[month - 1];
        for (int i = 1971; i < year; i++) {
            total += isLeapYear(i) ? 366 : 365;
        }
        if (isLeapYear(year) && month > 2) {
            total++;
        }
        return week[total % 7];
    }

    /**
     * 判断是否为闰年
     *
     * @param year 年
     * @return 是否为闰年
     */
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    /**
     * 1304. 和为零的N个唯一整数
     * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
     *
     * @param n 整数
     * @return 整数数组
     */
    private static int[] sumZero(int n) {
        int[] ans = new int[n];
        if (n % 2 != 0) {
            ans[n / 2] = 0;
        }
        for (int i = 0; i < n / 2; i++) {
            ans[i] = i + 1;
            ans[n - i - 1] = -(i + 1);
        }
        return ans;
    }

    /**
     * 1299. 将每个元素替换为右侧最大元素
     * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
     * 完成所有替换操作后，请你返回这个数组。
     *
     * @param arr 数组
     * @return 替换后的数组
     */
    private static int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i > 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return arr;
    }

    /**
     * 1260. 二维网格迁移
     * 给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
     * 每次「迁移」操作将会引发下述活动：
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。
     * 请你返回 k 次迁移操作后最终得到的 二维网格。
     *
     * @param grid 二维数组
     * @param k    迁移k次
     * @return 迁移后的结果
     */
    private static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] temp = new int[n * m];
        k %= temp.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[(i * m + j + k) % temp.length] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            t.add(temp[i]);
            if ((i + 1) % m == 0) {
                res.add(t);
                t = new ArrayList<>();
            }
        }
        return res;
    }
}


