package com.qianxinde.solution.date_2019_11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :yangbw
 * @date :2019-11-12
 */
public class Test_2019_11_12 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * @return 两数之和
     */
    public static int[] twoSum(int[] nums, int target) {
        //解法
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                result[1] = i;
                result[0] = map.get(num);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * 9. 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * @return 是否为回文
     */
    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int base = 0;
        while (x > base) {
            base = base * 10 + x % 10;
            x /= 10;
        }
        return x == base || x == base / 10;
    }
}
