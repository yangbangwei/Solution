package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author :yangbw
 * @date :2020_01_08
 */
public class Test_2020_01_08 {

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));

        System.out.println(largestSumAfterKNegations(new int[]{4, 2, 3}, 1));

        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com",
                "1 intel.mail.com", "5 wiki.org"}));

        System.out.println(longestWord(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm",
                "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"}));

        System.out.println(largestPerimeter(new int[]{2, 1, 2}));
    }

    /**
     * 1013. 将数组分成和相等的三个部分
     * 给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * 形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i]
     * == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
     *
     * @param A 数组
     * @return 是否三等分
     */
    private static boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for (int i : A) {
            total += i;
        }
        int averge = total / 3;
        int j = 0;
        total = 0;
        for (int value : A) {
            total += value;
            if (total == averge) {
                j++;
                total = 0;
            }
        }
        return j == 3 && total == 0;
    }

    /**
     * 1005. K 次取反后最大化的数组和
     *
     * @param A 数组
     * @param K 取反次数
     * @return 最大和
     */
    private static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int total = 0;
        int min = 101;
        for (int value : A) {
            if (value < 0 && K > 0) {
                value = -value;
                K--;
            }
            min = Math.min(min, Math.abs(value));
            total += value;
        }
        if (K % 2 != 0) {
            total -= min * 2;
        }
        return total;
    }

    /**
     * 811. 子域名访问计数
     * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，
     * 下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。
     * 当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
     * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。
     * 其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
     * 接下来会给出一组访问次数和域名组合的列表cpdomains。
     * 要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
     *
     * @param cpdomains 网站地址
     * @return 访问次数
     */
    private static List<String> subdomainVisits(String[] cpdomains) {
        List<String> data = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            int num = Integer.valueOf(s[0]);
            String[] address = s[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = address.length - 1; i >= 0; i--) {
                sb.insert(0, ".").insert(1, address[i]);
                String key = sb.toString().substring(1);
                @SuppressWarnings("ConstantConditions")
                int value = hashMap.getOrDefault(key, 0) + num;
                hashMap.put(key, value);
            }
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            data.add(entry.getValue() + " " + entry.getKey());
        }
        return data;
    }

    /**
     * 720. 词典中最长的单词
     * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
     * 该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
     * 若无答案，则返回空字符串。
     *
     * @param words 字符串数组
     * @return 返回最小单词
     */
    private static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }

    /**
     * 812. 最大三角形面积
     * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
     *
     * @param points 坐标点
     * @return 最大面积
     */
    private double largestTriangleArea(int[][] points) {
        int length = points.length;
        double max = 0.0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    max = Math.max(max, area(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }

    /**
     * 鞋带公式
     *
     * @param p 坐标1
     * @param q 坐标2
     * @param r 坐标3
     * @return 面积
     */
    private double area(int[] p, int[] q, int[] r) {
        return 0.5 * Math.abs(p[0] * q[1] + q[0] * r[1] + r[0] * p[1]
                - p[1] * q[0] - q[1] * r[0] - r[1] * p[0]);
    }

    /**
     * 976. 三角形的最大周长
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * 如果不能形成任何面积不为零的三角形，返回 0。
     *
     * @param A 正数数组
     * @return 最大边长
     */
    private static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }


}
