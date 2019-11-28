package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-26
 */
public class Test_2019_11_28 {

    public static void main(String[] args) {
        System.out.println(reverse(1000000111));
        System.out.println(addDigits(138));
        System.out.println(addDigits1(138));

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    /**
     * 7. 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param x 有符号整数
     * @return 旋转后结果
     */
    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10
                    || (rev * 10 == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10
                    || (rev == Integer.MAX_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 258. 各位相加
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * @param num 非负整数
     * @return 相加一位数结果
     */
    private static int addDigits(int num) {
        int value = 0;
        while (num != 0) {
            value = value + num % 10;
            num /= 10;
        }
        if (value >= 10) {
            return addDigits(value);
        }
        return value;
    }

    /**
     * 258. 各位相加
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * @param num 非负整数
     * @return 相加一位数结果
     */
    private static int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums 数组
     */
    private static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
