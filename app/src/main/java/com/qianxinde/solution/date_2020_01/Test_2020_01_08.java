package com.qianxinde.solution.date_2020_01;

/**
 * @author :yangbw
 * @date :2020_01_08
 */
public class Test_2020_01_08 {

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
    }

    /**
     * 1013. 将数组分成和相等的三个部分
     * 给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * 形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i]
     * == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
     *
     * @param A 数组
     * @return 是否三等分
     */
    private static boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for (int i : A) {
            total += i;
        }
        int averge = total / 3;
        int j = 0;
        total = 0;
        for (int value : A) {
            total += value;
            if (total == averge) {
                j++;
                total = 0;
            }
        }
        return j == 3 && total == 0;
    }
}
