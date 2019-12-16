package com.qianxinde.solution.date_2019_12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :yangbw
 * @date :2019-12-11
 */
public class Test_2019_12_16 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }

    /**
     * 704. 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     * @param nums   数组
     * @param target 目标值
     * @return 下标
     */
    private static int search(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;
        while (low < hight) {
            int mid = (hight - low) + low;
            if (nums[mid] == target) {
                return target;
            } else if (nums[mid] > target) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 507. 完美数
     * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
     * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False。
     *
     * @param num 整数
     * @return 是否完美数
     */
    private static boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int total = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                total += i;
                if (i * i != num) {
                    total += num / i;
                }
            }
        }
        return total - num == num;
    }

    /**
     * 506. 相对名次
     * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
     * 前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（
     * "Gold Medal", "Silver Medal", "Bronze Medal"）。
     *
     * @param nums 运动员成绩
     * @return 排名
     */
    private static String[] findRelativeRanks(int[] nums) {
        Integer[] copy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i], i + 1);
        }
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int order = map.get(nums[i]);
            String s;
            if (order == 1) {
                s = "Gold Medal";
            } else if (order == 2) {
                s = "Silver Medal";
            } else if (order == 3) {
                s = "Bronze Medal";
            } else {
                s = String.valueOf(order);
            }
            res[i] = s;
        }
        return res;
    }
}
