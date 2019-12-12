package com.qianxinde.solution.date_2019_12;

import android.util.SparseIntArray;

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

        System.out.println(isPowerOfThree(9));
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

    /**
     * 205. 同构字符串
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
     * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 是否存在映射关系
     */
    private static boolean isIsomorphic(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(ss[i]) != t.indexOf(tt[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 278. 第一个错误的版本
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
     * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     * @param n 版本号
     * @return 返回第一错误版本
     */
    private static int firstBadVersion(int n) {
        int low = 1;
        int hight = n;
        while (low < hight) {
            int mid = hight - (hight - low) / 2;
            if (isBadVersion(mid)) {
                hight = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 判断是否为错误版本
     *
     * @param n 版本号
     * @return 是否为错误版本
     */
    private static boolean isBadVersion(int n) {
        return false;
    }

    /**
     * 326. 3的幂
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     *
     * @param n 整数
     * @return 是否为3的幂次方
     */
    private static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
