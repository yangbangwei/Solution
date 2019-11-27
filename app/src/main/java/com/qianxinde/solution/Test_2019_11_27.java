package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-26
 */
public class Test_2019_11_27 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(15));

        int[] nums = {2, 7, 11, 15};
        twoSum(nums, 9);
    }

    /**
     * 172. 阶乘后的零
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * @param n 阶乘
     * @return 尾数为0的数量
     */
    private static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * 方法1，二分法
     *
     * @param numbers 有序数组
     * @param target  目标值
     * @return 符合值下标
     */
    private static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];

            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (numbers[mid] == num) {
                    result[0] = i + 1;
                    result[1] = mid + 1;
                    return result;
                } else if (numbers[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * 方法2，双指针
     *
     * @param numbers 有序数组
     * @param target  目标值
     * @return 符合值下标
     */
    private static int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
