package com.qianxinde.solution;

import java.util.ArrayList;
import java.util.Arrays;
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

        int[] nums1 = {17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        System.out.println(singleNumber(nums1));
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

    /**
     * 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 方法1，排序后，判断前后两个是否相同
     *
     * @param nums 数组
     * @return 返回唯一值
     */
    private static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int single = nums[0];
        int i = 1;
        while (i < nums.length - 1) {
            if (single == nums[i]) {
                single = nums[i + 1];
                i++;
            }
            i++;
        }
        return single;
    }

    /**
     * 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 方法2，异或，n^n=0,0^n=n
     *
     * @param nums 数组
     * @return 返回唯一值
     */
    private static int singleNumber1(int[] nums) {
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }
}
