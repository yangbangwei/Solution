package com.qianxinde.solution.date_2020_01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_09
 */
public class Test_2020_01_10 {

    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{1, 2, 3}));

        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    /**
     * 1029. 两地调度
     * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
     * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
     *
     * @param costs 所有花费
     * @return 最小花费
     */
    private int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int n = costs.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[0][i + n];
        }
        return total;
    }

    /**
     * 1037. 有效的回旋镖
     * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
     * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
     *
     * @param points 坐标点
     * @return 是否能构成回旋镖
     */
    private boolean isBoomerang(int[][] points) {
        return (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]) !=
                (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]);
    }

    /**
     * 1217. 玩筹码
     * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
     * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
     * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
     * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
     * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
     * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
     *
     * @param chips 筹码数组
     * @return 最小代价
     */
    private static int minCostToMoveChips(int[] chips) {
        if (chips.length <= 1) {
            return 0;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) {
                cnt2++;
            } else {
                cnt1++;
            }
        }
        return Math.min(cnt1, cnt2);
    }

    /**
     * 1175. 质数排列
     * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」
     * （索引从 1 开始）上；你需要返回可能的方案总数。
     * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
     * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
     *
     * @param n 整数
     * @return 排序结果
     */
    private int numPrimeArrangements(int n) {
        if (n < 3) {
            return 1;
        }
        boolean[] nums = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i * i < nums.length; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < nums.length; j += i) {
                    if (nums[i]) {
                        continue;
                    }
                    nums[i] = true;
                    count++;
                }
            }
        }
        count++;
        if (n < 8) {
            count = n - count;
        }
        long res = 1;
        for (int i = 0; i <= count; i++) {
            res = res * i % 1000000007;
            if (i == n - count) {
                res = (res * res) % 1000000007;
            }
        }
        return (int) res;
    }

    /**
     * 989. 数组形式的整数加法
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。
     * 例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     *
     * @param A 数组
     * @param K 整数
     * @return 相加结果
     */
    private static List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> data = new LinkedList<>();
        int pos = A.length;
        while (--pos >= 0 || K > 0) {
            if (pos >= 0) {
                K += A[pos];
            }
            data.addFirst(K % 10);
            K /= 10;
        }
        return data;
    }

    /**
     * 674. 最长连续递增序列
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
     *
     * @param nums 数组
     * @return 连续递增的长度
     */
    private int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp++;
            if (i == nums.length - 1 || nums[i] > nums[i + 1]) {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        return max;
    }

    /**
     * 746. 使用最小花费爬楼梯
     * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     *
     * @param cost 体力花费值
     * @return 最低花费
     */
    private static int minCostClimbingStairs(int[] cost) {
        int pre = 0;
        int cur = 0;
        for (int i : cost) {
            int temp = cur;
            cur = Math.min(pre, cur) + i;
            pre = temp;
        }
        return Math.min(cur, pre);
    }
}
