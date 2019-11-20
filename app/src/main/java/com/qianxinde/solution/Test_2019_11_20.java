package com.qianxinde.solution;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-11-20
 */
public class Test_2019_11_20 {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));

        int[] nums = {1, 2, 2, 3, 4, 4, 5, 5, 5};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates1(nums));
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord1("Hello World"));

        int[] nums1 = {1, 3, 5, 6, 7};
        int target = 0;
        System.out.println(searchInsert(nums1, target));
        System.out.println(searchInsert1(nums1, target));
    }

    /**
     * 67. 二进制求和
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     *
     * @param a 字符串a
     * @param b 字符串b
     * @return 求和值
     */
    private static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int flag = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = flag;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            result.append(sum % 2);
            flag = sum / 2;
        }
        result.append(flag == 1 ? 1 : "");
        return result.reverse().toString();
    }

    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums 整数数组
     * @return 返回去重后结果
     */
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 链表解法
     *
     * @param nums 整数数组
     * @return 返回去重后结果
     */
    private static int removeDuplicates1(int[] nums) {
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    /**
     * 58. 最后一个单词的长度
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * 解法1
     *
     * @param s 字符串
     * @return 单词的长度
     */
    private static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if (words.length == 0) {
            return 0;
        }
        return words[words.length - 1].length();
    }

    /**
     * 58. 最后一个单词的长度
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * 解法2
     *
     * @param s 字符串
     * @return 单词的长度
     */
    private static int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != 32) {
                num++;
            } else {
                break;
            }
        }
        return num;
    }

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 解法1
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 插入位置
     */
    private static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 解法2（二分法）
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 插入位置
     */
    private static int searchInsert1(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                //如果与nums[2]相等，直接返回结果
                return mid;
            } else if (nums[mid] > target) {
                //如果比nums[2]小，right等于2-1，重新比较
                right = mid - 1;
            } else {
                //如果比nums[2]大，left等于2+1，重新比较
                left = mid + 1;
            }
        }
        // 根据题意需要返回左边坐标，
        return left;
    }
}
