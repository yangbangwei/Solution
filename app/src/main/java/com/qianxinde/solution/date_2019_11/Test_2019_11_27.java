package com.qianxinde.solution.date_2019_11;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-11-26
 */
public class Test_2019_11_27 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(15));

        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));

        System.out.println(romanToInt("I"));
        System.out.println(romanToInt1("IV"));
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

    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * @param s 罗马数字
     * @return 整数
     */
    private static int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i + 1 > s.length() - 1) {
                        num += 1;
                    } else {
                        if (s.charAt(i + 1) == 'V') {
                            i++;
                            num += 4;
                        } else if (s.charAt(i + 1) == 'X') {
                            i++;
                            num += 9;
                        } else {
                            num += 1;
                        }
                    }
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if (i + 1 > s.length() - 1) {
                        num += 10;
                    } else {
                        if (s.charAt(i + 1) == 'L') {
                            i++;
                            num += 40;
                        } else if (s.charAt(i + 1) == 'C') {
                            i++;
                            num += 90;
                        } else {
                            num += 10;
                        }
                    }
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if (i + 1 > s.length() - 1) {
                        num += 100;
                    } else {
                        if (s.charAt(i + 1) == 'D') {
                            i++;
                            num += 400;
                        } else if (s.charAt(i + 1) == 'M') {
                            i++;
                            num += 900;
                        } else {
                            num += 100;
                        }
                    }
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
                default:
                    break;
            }
        }
        return num;
    }

    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * @param s 罗马数字
     * @return 整数
     */
    private static int romanToInt1(String s) {
        String rms = "MDCLXVI";
        int[] nums = {1000, 500, 100, 50, 10, 5, 1};
        int sum = 0, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pos = rms.indexOf(c);
            int num = nums[pos];
            sum += (num > prev ? num - prev - prev : num);
            prev = num;
        }
        return sum;
    }
}
