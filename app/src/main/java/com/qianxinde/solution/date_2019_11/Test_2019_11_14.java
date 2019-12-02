package com.qianxinde.solution.date_2019_11;

/**
 * @author :yangbw
 * @date :2019-11-12
 */
public class Test_2019_11_14 {

    public static void main(String[] args) {
        System.out.println(strStr());
    }

    /**
     * 28. 实现 strStr()
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
     * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * KMP算法
     *
     * @return 返回查找结果
     */
    private static int strStr() {
        String haystack = "hello";
        String needle = "l";
        char[] target = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        // 目标字符串下标
        int i = 0;
        // 搜索词下标
        int j = 0;
        // 整体右移一位的部分匹配表
        int[] next = getNext(needle);

        while (i < target.length && j < pattern.length) {
            // j == -1 表示从搜索词最开始进行匹配
            if (j == -1 || target[i] == pattern[j]) {
                i++;
                j++;
                // 匹配失败时，查询“部分匹配表”，得到搜索词位置j以前的最大共同前后缀长度
                // 将j移动到最大共同前后缀长度的后一位，然后再继续进行匹配
            } else {
                j = next[j];
            }
        }

        // 搜索词每一位都能匹配成功，返回匹配的的起始位置
        if (j == pattern.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 获取偏移位数
     *
     * @param pattern 字符串
     * @return 偏移位数
     */
    private static int[] getNext(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        // 第一位设为-1，方便判断当前位置是否为搜索词的最开始
        next[0] = -1;
        int i = 0;
        int j = -1;

        while (i < p.length - 1) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
