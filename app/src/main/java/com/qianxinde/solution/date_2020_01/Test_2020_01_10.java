package com.qianxinde.solution.date_2020_01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author :yangbw
 * @date :2020_01_09
 */
public class Test_2020_01_10 {

    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{1, 2, 3}));
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
}
