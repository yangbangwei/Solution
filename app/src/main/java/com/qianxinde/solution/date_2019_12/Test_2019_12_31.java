package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-27
 */
public class Test_2019_12_31 {

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
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
}

