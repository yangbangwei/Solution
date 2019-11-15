package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-12
 */
public class Test_2019_11_15 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * <p>
     * 斐波那契数列
     *
     * @return
     */
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public static int climb_Stairs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

}
