package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                int value = hashMap.getOrDefault(key, 0) + num;
                hashMap.put(key, value);
            }
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            data.add(entry.getValue() + " " + entry.getKey());
        }
        return data;
    }
}
