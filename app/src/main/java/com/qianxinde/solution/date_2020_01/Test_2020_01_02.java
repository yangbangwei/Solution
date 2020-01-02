package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_02
 */
public class Test_2020_01_02 {

    public static void main(String[] args) {
        int[] distance = {7, 10, 1, 12, 11, 14, 5, 0};
        System.out.println(distanceBetweenBusStops(distance, 7, 2));

        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(oddCells(2, 3, indices));

        System.out.println(Arrays.toString(distributeCandies(7, 4)));

        System.out.println(prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
                , 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));

        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));

        System.out.println(Arrays.toString(diStringMatch("IDID")));
    }

    /**
     * 1170. 比较字符串最小字母出现频次
     * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中
     * （按字典序比较）最小字母的出现频次。
     * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
     * 现在，给你两个字符串数组待查表 queries 和词汇表 words，
     * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i]
     *  是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
     *
     * @param queries 待查表
     * @param words   词汇表
     * @return f(queries[i]) < f(W) 的词的数目
     */
    private int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsNum = new int[11];
        int[] answer = new int[queries.length];
        for (String word : words) {
            wordsNum[f(word)]++;
        }
        for (int i = 0; i < answer.length; i++) {
            int total = 0;
            for (int j = f(queries[i]) + 1; j < wordsNum.length; j++) {
                total += wordsNum[j];
            }
            answer[i] = total;
        }
        return answer;
    }

    /**
     * 查询最小字母出现次数
     *
     * @param s 字符
     * @return 出现次数
     */
    private int f(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int ans = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

    /**
     * 1184. 公交站间的距离
     * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，
     * distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
     * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
     * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
     *
     * @param distance    距离
     * @param start       开始
     * @param destination 结束
     * @return 最短距离
     */
    private static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int left = 0, right = 0;
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        for (int i = start; i < destination; i++) {
            right += distance[i];
        }
        for (int i = distance.length - 1; i >= destination; i--) {
            left += distance[i];
        }
        for (int i = 0; i < start; i++) {
            left += distance[i];
        }
        return left < right ? left : right;
    }

    /**
     * 1232. 缀点成线
     * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
     * 其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
     * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
     *
     * @param coordinates 坐标点
     * @return 是否在一条直线上
     */
    private boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        int x2 = coordinates[1][0], y2 = coordinates[1][1];
        double k = (double) (x2 - x1) / (y2 - y1);
        for (int i = 2; i < coordinates.length; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];
            double temp = (double) (x3 - x1) / (y3 - y1);
            if (temp != k) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1252. 奇数值单元格的数目
     * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
     * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
     * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
     * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
     *
     * @param n       行
     * @param m       列
     * @param indices 索引数组
     * @return 奇数个数
     */
    private static int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = row[i] + col[j];
                if (num % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        private int f(int x, int y) {
            return 0;
        }
    }

    /**
     * 1237. 找出给定方程的正整数解
     * 给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。
     *
     * @param customfunction 方程
     * @param z              目标值
     * @return 符合条件的x，y数组
     */
    private List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1;
        int y = 1000;
        while (x <= 1000 && y >= 1) {
            int temp = customfunction.f(x, y);
            if (temp == z) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                res.add(list);
                x++;
            } else if (temp > z) {
                y--;
            } else {
                x++;
            }
        }
        return res;
    }

    /**
     * 1103. 分糖果 II
     * 排坐，分糖果。
     * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
     * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
     * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，
     * 直到给最后一个小朋友 2 * n 颗糖果。
     * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），
     * 直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），
     * 这些糖果也会全部发给当前的小朋友。
     * 返回一个长度为 num_people、元素之和为 candies 的数组，
     * 以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
     *
     * @param candies    糖果数量
     * @param num_people 人数
     * @return 每人分到糖果数量
     */
    private static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int num = 1;
        int i = 0;
        while (candies > 0) {
            candies = candies - num;
            if (candies >= 0) {
                ans[i] += num;
                i++;
                i = i % num_people;
                num++;
            } else {
                ans[i] += num + candies;
            }
        }
        return ans;
    }

    /**
     * 1071. 字符串的最大公因子
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
     * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
     *
     * @param str1 字符串s
     * @param str2 字符串t
     * @return 最大公因子
     */
    private String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            for (int i = str1.length(); i > 0; i--) {
                if (str1.length() % i == 0 && str2.length() % i == 0
                        && (str1.substring(0, i) + str2).equals(str2 + str1.substring(0, i))) {
                    return str1.substring(0, i);
                }
            }
        }
        return "";
    }

    /**
     * 1018. 可被 5 整除的二进制前缀
     * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数
     * （从最高有效位到最低有效位）。
     * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
     *
     * @param A 数组A
     * @return 是否能被5整除
     */
    private static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int mod = 0;
        for (int i : A) {
            mod = (2 * mod + i) % 5;
            ans.add(mod % 5 == 0);
        }
        return ans;
    }

    /**
     * 1010. 总持续时间可被 60 整除的歌曲
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，
     * 我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
     *
     * @param time 播放时间
     * @return 被60整除的曲曲
     */
    private static int numPairsDivisibleBy60(int[] time) {
        int[] nums = new int[60];
        for (int i : time) {
            nums[i % 60]++;
        }
        int count = nums[0] * (nums[0] - 1) / 2 + nums[30] * (nums[30] - 1) / 2;
        for (int i = 1; i < 30; i++) {
            int value = nums[i];
            if (value != 0) {
                int num = nums[60 - i];
                count += (num * value);
            }
        }
        return count;
    }

    /**
     * 942. 增减字符串匹配
     * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
     * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
     * 如果 S[i] == "I"，那么 A[i] < A[i+1]
     * 如果 S[i] == "D"，那么 A[i] > A[i+1]
     *
     * @param S 字符串
     * @return 对应的A数组
     */
    private static int[] diStringMatch(String S) {
        int max = S.length();
        int[] A = new int[max + 1];
        int min = 0;
        int i = 0;
        for (; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                A[i] = max;
                max--;
            } else {
                A[i] = min;
                min++;
            }
        }
        A[i] = max;
        return A;
    }

    /**
     * 977. 有序数组的平方
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     *
     * @param A 整数数组
     * @return 平方后排序数组
     */
    private int[] sortedSquares(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int index = right;
        int[] ans = new int[A.length];
        while (left <= right) {
            int a = A[left] * A[left];
            int b = A[right] * A[right];
            if (a > b) {
                ans[index--] = a;
                left++;
            } else {
                ans[index--] = b;
                right--;
            }
        }
        return ans;
    }
}

