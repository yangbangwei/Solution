package com.qianxinde.solution.date_2020_01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_16 {

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));

        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"},
                "hlabcdefgijkmnopqrstuvwxyz"));

        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7",
                "ab1 off key dog", "a8 act zoo"})));

        System.out.println(Arrays.deepToString(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }

    /**
     * 941. 有效的山脉数组
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
     * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     * A.length >= 3
     * 在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[B.length - 1]
     *
     * @param A 数组
     * @return 是否为山脉数组
     */
    private static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int left = 0, right = A.length - 1;
        while (left < right - 1 && A[left] < A[left + 1]) {
            left++;
        }
        while (right > 1 && A[right] < A[right - 1]) {
            right--;
        }
        return left == right;
    }

    /**
     * 953. 验证外星语词典
     * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
     * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，
     * 返回 true；否则，返回 false。
     *
     * @param words 字符串数组
     * @param order 字典
     * @return 是否按照字典排序
     */
    @SuppressWarnings({"ConstantConditions", "LoopStatementThatDoesntLoop", "UnusedAssignment"})
    private static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            hashMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s1.equals(s2)) {
                continue;
            }
            if (s1.startsWith(s2)) {
                return false;
            }
            int length = Math.min(s1.length(), s2.length());
            for (int j = 0; j < length; j++) {
                int index1 = hashMap.get(s1.charAt(j));
                int index2 = hashMap.get(s2.charAt(j));
                if (index1 < index2) {
                    break;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * 937. 重新排列日志文件
     * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
     * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
     * 标识符后面的每个字将仅由小写字母组成，或；
     * 标识符后面的每个字将仅由数字组成。
     * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
     * 将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，
     * 忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
     * 返回日志的最终顺序。
     *
     * @param logs 日志数组
     * @return 按照顺序排列
     */
    private static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //以" "为分界切割成功长度为2的字符串数组。
                String[] s1 = o1.split(" ", 2);
                String[] s2 = o2.split(" ", 2);
                //判断第二个字符串第一个字符是否为数字
                boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
                //两个都不为数字时，需要根据a-z排序
                if (!isDigit1 && !isDigit2) {
                    int temp = s1[1].compareTo(s2[1]);
                    //不为0，直接根据比较返回。
                    if (temp != 0) {
                        return temp;
                    }
                    //比较第一个字符串的排序。
                    return s1[0].compareTo(s2[0]);
                }
                //如果isDigit1为数字，isDigit2也为数字返回0。默认排序。
                //如果isDigit1为数字，isDigit2不为数字返回1。s1排后面。
                //如果isDigit1不为数字，s1排前面。
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        });
        return logs;
    }

    /**
     * 867. 转置矩阵
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     *
     * @param A 矩阵
     * @return 转置矩阵
     */
    private static int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}
