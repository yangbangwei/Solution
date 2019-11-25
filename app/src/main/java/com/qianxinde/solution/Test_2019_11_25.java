package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-25
 */
public class Test_2019_11_25 {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    /**
     * 69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * @param x 输入值
     * @return 返回开平方
     */
    private static int mySqrt(int x) {
        long lo = 1, hi = x;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (mid * mid > x) {
                hi = mid - 1;
            } else if ((mid + 1) * (mid + 1) <= x) {
                lo = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return 0;
    }
}
