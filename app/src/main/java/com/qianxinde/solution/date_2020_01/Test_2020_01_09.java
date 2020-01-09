package com.qianxinde.solution.date_2020_01;

/**
 * @author :yangbw
 * @date :2020_01_09
 */
public class Test_2020_01_09 {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(11));
    }

    /**
     *
     * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
     *
     * @param n 正整数
     * @return 二进制是否相邻
     */
    private static boolean hasAlternatingBits(int n) {
        int num = n % 2;
        while (n > 0) {
            int temp = n % 2;
            if (num != temp) {
                return false;
            }
            num = temp == 0 ? 1 : 0;
            n /= 2;
        }
        return true;
    }
}
