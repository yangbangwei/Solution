package com.qianxinde.solution.date_2019_11;

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
     * @return 返回方法数
     */
    private static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    /**
     * 记忆化递归
     * f(n) = f(n-2)+ f(n-1)
     *
     * @param i    步数1，2
     * @param n    第几阶
     * @param memo 缓存数组
     * @return 返回方法数
     */
    private static int climb_Stairs(int i, int n, int[] memo) {
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

    /**
     * 斐波那契数列
     *
     * @param n 第几阶台阶
     * @return 返回方法数
     */
    private static int climb_Stairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        for (int i = 3; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 动态规划
     *
     * @param n 第几阶台阶
     * @return 返回方法数
     */
    private static int climb_Stairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
