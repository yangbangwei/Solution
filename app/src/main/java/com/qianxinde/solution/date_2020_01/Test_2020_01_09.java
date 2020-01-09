package com.qianxinde.solution.date_2020_01;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_09
 */
public class Test_2020_01_09 {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(11));

        System.out.println(countPrimeSetBits(10, 15));

        System.out.println(bitwiseComplement(7));

        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));

        System.out.println(binaryGap(5));

        System.out.println(maxDistToClosest(new int[]{0, 1}));

        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));

        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    /**
     * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
     *
     * @param n 正整数
     * @return 二进制是否相邻
     */
    private static boolean hasAlternatingBits(int n) {
        int num = n % 2;
        while (n > 0) {
            int temp = n % 2;
            if (num != temp) {
                return false;
            }
            num = temp == 0 ? 1 : 0;
            n /= 2;
        }
        return true;
    }

    /**
     * 762. 二进制表示中质数个计算置位
     * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
     * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
     *
     * @param L 左边界
     * @param R 右边界
     * @return 质数的个数
     */
    private static int countPrimeSetBits(int L, int R) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(7);
        hashSet.add(11);
        hashSet.add(13);
        hashSet.add(17);
        hashSet.add(19);
        int ans = 0;
        for (int i = L; i <= R; i++) {
            int total = 0;
            int num = i;
            while (num > 0) {
                int temp = num % 2;
                if (temp == 1) {
                    total++;
                }
                num /= 2;
            }
            if (hashSet.contains(total)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 766. 托普利茨矩阵
     * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
     * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
     *
     * @param matrix 矩阵
     * @return 是否为托普利茨矩阵
     */
    private boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 1009. 十进制整数的反码
     * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，
     * 依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
     * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
     * 给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
     *
     * @param N 整数
     * @return 反码后的值
     */
    private static int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int ans = 0;
        int i = 0;
        while (N > 0) {
            int temp = N % 2;
            if (temp == 0) {
                ans += Math.pow(2, i);
            }
            i++;
            N /= 2;
        }
        return ans;
    }

    /**
     * 949. 给定数字能组成的最大时间
     * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
     * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
     * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
     *
     * @param A 数组
     * @return 最大有效时间
     */
    private static String largestTimeFromDigits(int[] A) {
        int ans = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j != i) {
                    for (int k = 0; k < 4; k++) {
                        if (j != k && k != i) {
                            int l = 6 - i - j - k;
                            int min = 10 * A[i] + A[j];
                            int hour = 10 * A[k] + A[l];
                            if (hour < 24 && min < 60) {
                                ans = Math.max(ans, hour * 60 + min);
                            }
                        }
                    }
                }
            }
        }
        return ans != -1 ? (ans / 60) + ":" + (ans % 60) : "";
    }

    /**
     * 868. 二进制间距
     * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
     * 如果没有两个连续的 1，返回 0 。
     *
     * @param N 正整数
     * @return 1之间的最长距离
     */
    private static int binaryGap(int N) {
        int ans = 0;
        int length = 0;
        boolean isBegin = false;
        while (N > 0) {
            int temp = N % 2;
            if (isBegin) {
                length++;
            }
            if (temp == 1) {
                isBegin = true;
                ans = Math.max(ans, length);
                length = 0;
            }
            N /= 2;
        }
        return ans;
    }

    /**
     * 849. 到最近的人的最大距离
     * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
     * 至少有一个空座位，且至少有一人坐在座位上。
     * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
     * 返回他到离他最近的人的最大距离。
     *
     * @param seats 座位
     * @return 最大距离
     */
    private static int maxDistToClosest(int[] seats) {
        int start = 0;
        int end = 0;
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1 || i == seats.length - 1) {
                if (seats[start] == seats[end]) {
                    ans = Math.max(ans, (end - start) / 2);
                } else {
                    ans = Math.max(ans, end - start);
                }
                start = i;
                end = start;
            }
            end++;
        }
        return ans;
    }

    /**
     * 830. 较大分组的位置
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     * 最终结果按照字典顺序输出。
     *
     * @param S 字符串
     * @return 返回较大分组
     */
    private static List<List<Integer>> largeGroupPositions(String S) {
        char[] sChar = S.toCharArray();
        List<List<Integer>> data = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < sChar.length; i++) {
            num++;
            if (i == sChar.length - 1 || sChar[i] != sChar[i + 1]) {
                if (num >= 3) {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(i - num + 1);
                    integers.add(i);
                    data.add(integers);
                }
                num = 0;
            }
        }
        return data;
    }

    /**
     * 447. 回旋镖的数量
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
     * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     *
     * @param points 坐标点
     * @return 回旋镖数
     */
    private int numberOfBoomerangs(int[][] points) {
        @SuppressLint("UseSparseArrays")
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int[] i : points) {
            hashMap.clear();
            for (int[] j : points) {
                if (i == j) {
                    continue;
                }
                int distance = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
                int num = hashMap.getOrDefault(distance, 0);
                ans += num * 2;
                hashMap.put(distance, num + 1);
            }
        }
        return ans;
    }

    /**
     * 717. 1比特与2比特字符
     * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
     * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
     *
     * @param bits 数组
     * @return 是否以0结尾
     */
    private static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    /**
     * 453. 最小移动次数使数组元素相等
     * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
     *
     * @param nums 整数数组
     * @return 最小移动步数
     */
    private int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            ans += nums[i] - nums[0];
        }
        return ans;
    }

    /**
     * 645. 错误的集合
     * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
     * 导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
     * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     *
     * @param nums 数组
     * @return 重复，以及丢失整数
     */
    private int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];

        for (int i : nums) {
            count[i]++;
        }

        int[] res = new int[2];
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                res[1] = i;
            } else if (count[i] == 2) {
                res[0] = i;
            }
        }
        return res;
    }
}
