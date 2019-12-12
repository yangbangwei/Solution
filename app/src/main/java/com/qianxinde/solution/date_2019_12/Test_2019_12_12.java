package com.qianxinde.solution.date_2019_12;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author :yangbw
 * @date :2019-12-11
 */
public class Test_2019_12_12 {

    public static void main(String[] args) {

        System.out.println(hammingWeight(2));

        rotate(new int[]{1, 2}, 1);
        rotate1(new int[]{1, 2}, 1);
        rotate2(new int[]{1, 2}, 1);

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

    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 方法1，不新增额外空间
     *
     * @param nums 数组
     * @param k    右移位置
     */
    private static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 方法2，额外空间
     *
     * @param nums 数组
     * @param k    右移位置
     */
    private static void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int j = (i + k) % nums.length;
            nums[j] = hashMap.get(i);
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 方法3，翻转
     *
     * @param nums 数组
     * @param k    右移位置
     */
    private static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 翻转方法
     *
     * @param nums  数组
     * @param start 起始点
     * @param end   结束点
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
