package com.qianxinde.solution.date_2020_01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author :yangbw
 * @date :2020_01_09
 */
public class Test_2020_01_10 {

    public static void main(String[] args) {

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
}
