package com.qianxinde.solution.date_2020_01;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2020_01_02
 */
public class Test_2020_01_02 {

    public static void main(String[] args) {

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
}
