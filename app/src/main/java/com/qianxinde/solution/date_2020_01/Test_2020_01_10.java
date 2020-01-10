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

}
