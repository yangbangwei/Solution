package com.qianxinde.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-11-26
 */
public class Test_2019_11_26 {

    public static void main(String[] args) {
        System.out.println(getRow(3));

        int[] nums = {1, 2};
        System.out.println(maxProfit1(nums));
    }

    /**
     * 119. 杨辉三角 II
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *
     * @param rowIndex 第几行
     * @return 返回结果
     */
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> data = new ArrayList<>();
        long nk = 1;
        for (int i = 0; i <= rowIndex; i++) {
            data.add((int) nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return data;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     * 方法1
     *
     * @param prices 周期列表
     * @return 返回最大利润
     */
    private static int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length == 0) {
            return max;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j <= prices.length - 1; j++) {
                max = Math.max(max, -prices[i] + prices[j]);
            }
        }
        return max;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     * 方法2
     *
     * @param prices 周期列表
     * @return 返回最大利润
     */
    private static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 0) {
            return maxProfit;
        }
        int minProfit = prices[0];
        for (int price : prices) {
            if (minProfit > price) {
                minProfit = price;
            } else if (price - minProfit > maxProfit) {
                maxProfit = price - minProfit;
            }
        }
        return maxProfit;
    }
}
