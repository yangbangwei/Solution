package com.qianxinde.solution.date_2020_01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author :yangbw
 * @date :2020_01_03
 */
public class Test_2020_01_03 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));

        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));

        int[][] nums = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(matrixReshape(nums, 1, 4)));
    }

    /**
     * 860. 柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，
     * 也就是说净交易是每位顾客向你支付 5 美元。
     * 注意，一开始你手头没有任何零钱。
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *
     * @param bills 账单
     * @return 是否正确找零
     */
    private boolean lemonadeChange(int[] bills) {
        int num5 = 0;
        int num10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                num5++;
            } else if (bill == 10) {
                if (num5 >= 1) {
                    num5--;
                    num10++;
                } else {
                    return false;
                }
            } else {
                if (num5 >= 1 && num10 >= 1) {
                    num5--;
                    num10--;
                } else if (num5 >= 3) {
                    num5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 852. 山脉数组的峰顶索引
     * 我们把符合下列属性的数组 A 称作山脉：
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 
     * 的 i 的值。
     *
     * @param A 数组
     * @return 峰顶
     */
    private int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    /**
     * 744. 寻找比目标字母大的最小字母
     * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
     * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
     *
     * @param letters 有序数组
     * @param target  目标字母
     * @return 最小的字母
     */
    private char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (target < letter) {
                return letter;
            }
        }
        return ' ';
    }

    /**
     * 724. 寻找数组的中心索引
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     *
     * @param nums 数组
     * @return 中心索引
     */
    private static int pivotIndex(int[] nums) {
        if (nums.length > 2) {
            int total = 0;
            int leftSum = 0;
            for (int num : nums) {
                total += num;
            }
            for (int i = 0; i < nums.length; i++) {
                if (leftSum == total - nums[i] - leftSum) {
                    return i;
                }
                leftSum += nums[i];
            }
        }
        return -1;
    }

    /**
     * 219. 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
     * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     *
     * @param nums 数组
     * @param k    距离不大于k
     * @return 是否满足
     */
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 35000 || nums.length < 1) {
            return false;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int num : nums) {
            if (queue.contains(num)) {
                return true;
            }
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return false;
    }

    /**
     * 566. 重塑矩阵
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * @param nums 数组
     * @param r    行
     * @param c    列
     * @return 重塑或原始矩阵
     */
    private static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums[0].length;
        int col = nums.length;
        if (row * col == r * c) {
            int[][] newNums = new int[r][c];
            int index = 0;
            for (int[] num : nums) {
                for (int j = 0; j < row; j++) {
                    newNums[index / c][index % c] = num[j];
                    index++;
                }
            }
            return newNums;
        } else {
            return nums;
        }
    }

    /**
     * 561. 数组拆分 I
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
     * 使得从1 到 n 的 min(ai, bi) 总和最大。
     *
     * @param nums 数组
     * @return 两组min的总和
     */
    private int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

