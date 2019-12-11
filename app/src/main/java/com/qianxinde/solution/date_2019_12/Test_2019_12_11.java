package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-11
 */
public class Test_2019_12_11 {

    public static void main(String[] args) {

        System.out.println(hammingDistance(2, 3));
        System.out.println(findComplement(2));
    }

    /**
     * 461. 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离
     *
     * @param x 整数x
     * @param y 整数y
     * @return 汉明距离
     */
    private static int hammingDistance(int x, int y) {
        int count = 0;
        int temp = x ^ y;
        while (temp != 0) {
            if ((temp & 1) == 1) {
                count++;
            }
            temp = temp >>> 1;
        }
        return count;
    }

    /**
     * 476. 数字的补数
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     *
     * @param num 正整数
     * @return 补数
     */
    private static int findComplement(int num) {
        long num2 = 1;
        while (num2 <= num) {
            num2 = num2 << 1;
        }
        num2--;
        return (int) num2 ^ num;
    }
}
