package com.qianxinde.solution.date_2019_12;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-12-18
 */
public class Test_2019_12_18 {

    public static void main(String[] args) {
        System.out.println(heightChecker1(new int[]{13, 13, 14, 12, 1, 3}));

        System.out.println(divisorGame(3));
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

    /**
     * 1025. 除数博弈
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     *
     * @return 爱丽丝的输赢情况
     */
    private static boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
