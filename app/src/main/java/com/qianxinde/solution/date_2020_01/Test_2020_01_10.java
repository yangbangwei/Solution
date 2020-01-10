package com.qianxinde.solution.date_2020_01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_09
 */
public class Test_2020_01_10 {

    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{1, 2, 3}));

        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

        System.out.println(shortestCompletingWord("1s3 pst",
                new String[]{"step", "steps", "stripe", "stepple"}));

        System.out.println(numMagicSquaresInside(new int[][]{{1, 1, 1}, {4, 5, 6}, {9, 9, 9}}));

        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
    }

    /**
     * 1029. 两地调度
     * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
     * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
     *
     * @param costs 所有花费
     * @return 最小花费
     */
    private int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int n = costs.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[0][i + n];
        }
        return total;
    }

    /**
     * 1037. 有效的回旋镖
     * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
     * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
     *
     * @param points 坐标点
     * @return 是否能构成回旋镖
     */
    private boolean isBoomerang(int[][] points) {
        return (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]) !=
                (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]);
    }

    /**
     * 1217. 玩筹码
     * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
     * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
     * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
     * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
     * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
     * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
     *
     * @param chips 筹码数组
     * @return 最小代价
     */
    private static int minCostToMoveChips(int[] chips) {
        if (chips.length <= 1) {
            return 0;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) {
                cnt2++;
            } else {
                cnt1++;
            }
        }
        return Math.min(cnt1, cnt2);
    }

    /**
     * 1175. 质数排列
     * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」
     * （索引从 1 开始）上；你需要返回可能的方案总数。
     * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
     * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
     *
     * @param n 整数
     * @return 排序结果
     */
    private int numPrimeArrangements(int n) {
        if (n < 3) {
            return 1;
        }
        boolean[] nums = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i * i < nums.length; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < nums.length; j += i) {
                    if (nums[i]) {
                        continue;
                    }
                    nums[i] = true;
                    count++;
                }
            }
        }
        count++;
        if (n < 8) {
            count = n - count;
        }
        long res = 1;
        for (int i = 0; i <= count; i++) {
            res = res * i % 1000000007;
            if (i == n - count) {
                res = (res * res) % 1000000007;
            }
        }
        return (int) res;
    }

    /**
     * 989. 数组形式的整数加法
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。
     * 例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     *
     * @param A 数组
     * @param K 整数
     * @return 相加结果
     */
    private static List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> data = new LinkedList<>();
        int pos = A.length;
        while (--pos >= 0 || K > 0) {
            if (pos >= 0) {
                K += A[pos];
            }
            data.addFirst(K % 10);
            K /= 10;
        }
        return data;
    }

    /**
     * 674. 最长连续递增序列
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
     *
     * @param nums 数组
     * @return 连续递增的长度
     */
    private int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp++;
            if (i == nums.length - 1 || nums[i] > nums[i + 1]) {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        return max;
    }

    /**
     * 746. 使用最小花费爬楼梯
     * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     *
     * @param cost 体力花费值
     * @return 最低花费
     */
    private static int minCostClimbingStairs(int[] cost) {
        int pre = 0;
        int cur = 0;
        for (int i : cost) {
            int temp = cur;
            cur = Math.min(pre, cur) + i;
            pre = temp;
        }
        return Math.min(cur, pre);
    }

    /**
     * 748. 最短完整词
     * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。
     * 在所有完整词中，最短的单词我们称之为最短完整词。
     * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
     * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
     * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
     *
     * @param licensePlate 牌照表
     * @param words        单词列表
     * @return 最短的包含牌照表的词
     */
    private static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] nums = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                nums[c - 'a']++;
            }
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String word : words) {
            int[] temp = new int[26];
            boolean isSuc = true;
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (temp[j] < nums[j]) {
                    isSuc = false;
                }
            }
            if (isSuc) {
                return word;
            }
        }
        return "";
    }

    /**
     * 836. 矩形重叠
     * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
     * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
     * 给出两个矩形，判断它们是否重叠并返回结果。
     *
     * @param rec1 矩形1
     * @param rec2 矩形2
     * @return 是否重叠
     */
    private boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||
                rec1[3] <= rec2[1] ||
                rec1[0] >= rec2[2] ||
                rec1[1] >= rec2[3]);
    }

    /**
     * 840. 矩阵中的幻方
     * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
     * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
     *
     * @param grid 矩阵
     * @return 多少个幻方
     */
    private static int numMagicSquaresInside(int[][] grid) {
        if (grid.length <= 2 || grid[0].length <= 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (grid[i + 1][j + 1] == 5) {
                    if (grid[i][j] != 5) {
                        int sum1 = grid[i][j] % 10 + grid[i + 2][j + 2] % 10 + 5;
                        int sum2 = grid[i][j + 1] % 10 + grid[i + 2][j + 1] % 10 + 5;
                        int sum3 = grid[i][j + 2] % 10 + grid[i + 2][j] % 10 + 5;
                        int sum4 = grid[i + 1][j] % 10 + grid[i + 1][j + 2] % 10 + 5;
                        int sum5 = grid[i][j] % 10 + grid[i][j + 1] % 10 + grid[i][j + 2] % 10;
                        int sum6 = grid[i + 2][j] % 10 + grid[i + 2][j + 1] % 10 + grid[i + 2][j + 2] % 10;
                        int sum7 = grid[i][j] % 10 + grid[i + 1][j] % 10 + grid[i + 2][j] % 10;
                        int sum8 = grid[i][j + 2] % 10 + grid[i + 1][j + 2] % 10 + grid[i + 2][j + 2] % 10;
                        if (15 == sum1 && sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 &&
                                sum5 == sum6 && sum6 == sum7 && sum7 == sum8) {
                            count++;
                        }
                    }

                }
            }
        }
        return count;
    }

    /**
     * 914. 卡牌分组
     * 给定一副牌，每张牌上都写着一个整数。
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     *
     * @param deck 牌的数组
     * @return 公约数
     */
    private static boolean hasGroupsSizeX(int[] deck) {
        int[] nums = new int[10000];
        for (int value : deck) {
            nums[value]++;
        }
        int ans = -1;
        for (int num : nums) {
            if (num > 0) {
                if (ans == -1) {
                    ans = num;
                } else {
                    ans = gcd(ans, num);
                }
            }
        }
        return ans >= 2;
    }

    /**
     * 公约数
     *
     * @param x 旧值
     * @param y 新值
     * @return 公约数
     */
    private static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
