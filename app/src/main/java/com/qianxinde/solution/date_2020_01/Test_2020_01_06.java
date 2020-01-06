package com.qianxinde.solution.date_2020_01;

/**
 * @author :yangbw
 * @date :2020_01_03
 */
public class Test_2020_01_06 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog", "doracecar", "car"}));
    }

    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs 字符串数组
     * @return 公共前缀
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param prices 股票价格
     * @return 最大利润
     */
    private int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    /**
     * 190. 颠倒二进制位
     * 颠倒给定的 32 位无符号整数的二进制位。
     *
     * @param n 32位无符号整数
     * @return 颠倒后的数
     */
    private static int reverseBits(int n) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans = ans | ((n >> (31 - i) & 1)) << i;
        }
        return ans;
    }
}

