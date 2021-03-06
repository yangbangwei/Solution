package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-26
 */
public class Test_2019_12_26 {

    public static void main(String[] args) {
        System.out.println(dayOfYear("2016-02-29"));

        System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student"
                , "a", "good")));
    }

    /**
     * 1266. 访问所有点的最小时间
     * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
     * 你可以按照下面的规则在平面上移动：
     * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
     * 必须按照数组中出现的顺序来访问这些点。
     *
     * @param points 坐标点
     * @return 移动距离
     */
    private static int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0] - points[i - 1][0]);
            int y = Math.abs(points[i][1] - points[i - 1][1]);
            ans += Math.min(x, y);
            ans += Math.abs(x - y);
        }
        return ans;
    }

    /**
     * 1128. 等价多米诺骨牌对的数量
     * 给你一个由一些多米诺骨牌组成的列表 dominoes。
     * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
     * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
     * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 
     * 等价的骨牌对 (i, j) 的数量。
     *
     * @param dominoes 多米诺牌
     * @return 等价的数量
     */
    private static int numEquivDominoPairs(int[][] dominoes) {
        int[] nums = new int[100];
        for (int[] dominoe : dominoes) {
            int x = dominoe[0];
            int y = dominoe[1];
            int k = x > y ? x * 10 + y : y * 10 + x;
            nums[k]++;
        }
        int ans = 0;
        for (int num : nums) {
            ans += num * (num - 1) / 2;
        }
        return ans;
    }

    /**
     * 1275. 找出井字棋的获胜者
     * A 和 B 在一个 3 x 3 的网格上玩井字棋。
     *
     * @param moves 玩家移动步数
     * @return 结果
     */
    private static String tictactoe(int[][] moves) {
        char[][] ch = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                ch[moves[i][0]][moves[i][1]] = 'X';
                if (ch[0][0] == 'X' && ch[1][1] == 'X' && ch[2][2] == 'X' ||
                        ch[2][0] == 'X' && ch[1][1] == 'X' && ch[0][2] == 'X' ||
                        ch[0][0] == 'X' && ch[1][0] == 'X' && ch[2][0] == 'X' ||
                        ch[0][1] == 'X' && ch[1][1] == 'X' && ch[2][1] == 'X' ||
                        ch[0][2] == 'X' && ch[1][2] == 'X' && ch[2][2] == 'X' ||
                        ch[0][0] == 'X' && ch[0][1] == 'X' && ch[0][2] == 'X' ||
                        ch[1][0] == 'X' && ch[1][1] == 'X' && ch[1][2] == 'X' ||
                        ch[2][0] == 'X' && ch[2][1] == 'X' && ch[2][2] == 'X') {
                    return "A";
                }
            } else {
                ch[moves[i][0]][moves[i][1]] = 'O';
                if (ch[0][0] == 'O' && ch[1][1] == 'O' && ch[2][2] == 'O' ||
                        ch[2][0] == 'O' && ch[1][1] == 'O' && ch[0][2] == 'O' ||
                        ch[0][0] == 'O' && ch[1][0] == 'O' && ch[2][0] == 'O' ||
                        ch[0][1] == 'O' && ch[1][1] == 'O' && ch[2][1] == 'O' ||
                        ch[0][2] == 'O' && ch[1][2] == 'O' && ch[2][2] == 'O' ||
                        ch[0][0] == 'O' && ch[0][1] == 'O' && ch[0][2] == 'O' ||
                        ch[1][0] == 'O' && ch[1][1] == 'O' && ch[1][2] == 'O' ||
                        ch[2][0] == 'O' && ch[2][1] == 'O' && ch[2][2] == 'O') {
                    return "B";
                }
            }
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }

    /**
     * 1154. 一年中的第几天
     * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
     * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
     *
     * @param date 日期
     * @return 天数
     */
    private static int dayOfYear(String date) {
        String[] data = date.split("-");
        int[] monday = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int year = Integer.valueOf(data[0]);
        int month = Integer.valueOf(data[1]) - 1;
        int day = Integer.valueOf(data[2]);

        if (month < 2) {
            return monday[month - 1] + day;
        } else {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                return monday[month - 1] + day + 1;
            }
        }
        return monday[month - 1] + day;
    }

    /**
     * 1078. Bigram 分词
     * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
     * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
     *
     * @param text   文字
     * @param first  第一个词
     * @param second 第二个词
     * @return 第三个词
     */
    private static String[] findOcurrences(String text, String first, String second) {
        List<String> data = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                data.add(words[i]);
            }
        }
        return data.toArray(new String[0]);
    }
}


