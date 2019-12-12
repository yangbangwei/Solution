package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-11
 */
public class Test_2019_12_12 {

    public static void main(String[] args) {

        System.out.println(hammingWeight(2));

    }

    /**
     * 191. 位1的个数
     * 编写一个函数，输入是一个无符号整数，
     * 返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     *
     * @param n 整数n
     * @return 汉明重量
     */
    private static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

}
