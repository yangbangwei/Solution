package com.qianxinde.solution.date_2019_12;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-12-18
 */
public class Test_2019_12_18 {

    public static void main(String[] args) {
        System.out.println(heightChecker1(new int[]{13, 13, 14, 12, 1, 3}));
    }

    /**
     * 1051. 高度检查器
     * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
     * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
     *
     * @param heights 身高数组
     * @return 站错位置的数量
     */
    private static int heightChecker(int[] heights) {
        int[] temp = new int[heights.length];
        System.arraycopy(heights, 0, temp, 0, heights.length);
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 1051. 高度检查器
     * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
     * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
     *
     * @param heights 身高数组
     * @return 站错位置的数量
     */
    private static int heightChecker1(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }
}
