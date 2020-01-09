package com.qianxinde.solution.date_2020_01;

import java.util.HashSet;

/**
 * @author :yangbw
 * @date :2020_01_09
 */
public class Test_2020_01_09 {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(11));

        System.out.println(countPrimeSetBits(10, 15));
    }

    /**
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

    /**
     * 762. 二进制表示中质数个计算置位
     * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
     * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
     *
     * @param L 左边界
     * @param R 右边界
     * @return 质数的个数
     */
    private static int countPrimeSetBits(int L, int R) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(7);
        hashSet.add(11);
        hashSet.add(13);
        hashSet.add(17);
        hashSet.add(19);
        int ans = 0;
        for (int i = L; i <= R; i++) {
            int total = 0;
            int num = i;
            while (num > 0) {
                int temp = num % 2;
                if (temp == 1) {
                    total++;
                }
                num /= 2;
            }
            if (hashSet.contains(total)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 766. 托普利茨矩阵
     * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
     * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
     *
     * @param matrix 矩阵
     * @return 是否为托普利茨矩阵
     */
    private boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
