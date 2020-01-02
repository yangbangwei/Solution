package com.qianxinde.solution.date_2020_01;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2020_01_02
 */
public class Test_2020_01_02 {

    public static void main(String[] args) {
        int[] distance = {7, 10, 1, 12, 11, 14, 5, 0};
        System.out.println(distanceBetweenBusStops(distance, 7, 2));
    }

    /**
     * 1170. 比较字符串最小字母出现频次
     * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中
     * （按字典序比较）最小字母的出现频次。
     * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
     * 现在，给你两个字符串数组待查表 queries 和词汇表 words，
     * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i]
     *  是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
     *
     * @param queries 待查表
     * @param words   词汇表
     * @return f(queries[i]) < f(W) 的词的数目
     */
    private int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsNum = new int[11];
        int[] answer = new int[queries.length];
        for (String word : words) {
            wordsNum[f(word)]++;
        }
        for (int i = 0; i < answer.length; i++) {
            int total = 0;
            for (int j = f(queries[i]) + 1; j < wordsNum.length; j++) {
                total += wordsNum[j];
            }
            answer[i] = total;
        }
        return answer;
    }

    /**
     * 查询最小字母出现次数
     *
     * @param s 字符
     * @return 出现次数
     */
    private int f(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int ans = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

    /**
     * 1184. 公交站间的距离
     * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，
     * distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
     * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
     * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
     *
     * @param distance    距离
     * @param start       开始
     * @param destination 结束
     * @return 最短距离
     */
    private static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int left = 0, right = 0;
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        for (int i = start; i < destination; i++) {
            right += distance[i];
        }
        for (int i = distance.length - 1; i >= destination; i--) {
            left += distance[i];
        }
        for (int i = 0; i < start; i++) {
            left += distance[i];
        }
        return left < right ? left : right;
    }
}
