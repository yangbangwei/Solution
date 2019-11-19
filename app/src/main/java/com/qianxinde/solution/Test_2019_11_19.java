package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-19
 */
public class Test_2019_11_19 {

    public static void main(String[] args) {
        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        digits = plusOne(digits);
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }
    }

    /**
     * 66. 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
