package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-26
 */
public class Test_2019_11_27 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(15));
    }

    /**
     * 172. 阶乘后的零
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * @param n 阶乘
     * @return 尾数为0的数量
     */
    private static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

}
