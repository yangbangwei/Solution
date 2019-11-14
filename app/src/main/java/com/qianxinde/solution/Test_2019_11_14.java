package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-12
 */
public class Test_2019_11_14 {

    public static void main(String[] args) {
        getNext("ababacbd");
    }

    /**
     * 28. 实现 strStr()
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
     * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * @return
     */
    public static int strStr() {
        String haystack = "hello";
        String needle = "hea";

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {

        }
        needle.indexOf(needle);
        return -1;
    }

    public static int[] getNext(String pattern) {
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
