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

        System.out.println(bitwiseComplement(7));

        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));

        System.out.println(binaryGap(5));
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

    /**
     * 1009. 十进制整数的反码
     * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，
     * 依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
     * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
     * 给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
     *
     * @param N 整数
     * @return 反码后的值
     */
    private static int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int ans = 0;
        int i = 0;
        while (N > 0) {
            int temp = N % 2;
            if (temp == 0) {
                ans += Math.pow(2, i);
            }
            i++;
            N /= 2;
        }
        return ans;
    }

    /**
     * 949. 给定数字能组成的最大时间
     * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
     * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
     * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
     *
     * @param A 数组
     * @return 最大有效时间
     */
    private static String largestTimeFromDigits(int[] A) {
        int ans = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != i) {
                    for (int k = 0; k < 4; k++) {
                        if (j != k && k != i) {
                            int l = 6 - i - j - k;
                            int min = 10 * A[i] + A[j];
                            int hour = 10 * A[k] + A[l];
                            if (hour < 24 && min < 60) {
                                ans = Math.max(ans, hour * 60 + min);
                            }
                        }
                    }
                }
            }
        }
        return ans != -1 ? (ans / 60) + ":" + (ans % 60) : "";
    }

    /**
     * 868. 二进制间距
     * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
     * 如果没有两个连续的 1，返回 0 。
     *
     * @param N 正整数
     * @return 1之间的最长距离
     */
    private static int binaryGap(int N) {
        int ans = 0;
        int length = 0;
        boolean isBegin = false;
        while (N > 0) {
            int temp = N % 2;
            if (isBegin) {
                length++;
            }
            if (temp == 1) {
                isBegin = true;
                ans = Math.max(ans, length);
                length = 0;
            }
            N /= 2;
        }
        return ans;
    }
}
