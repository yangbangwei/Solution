package com.qianxinde.solution.date_2020_01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;

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

        System.out.println(licenseKeyFormatting("2-5G-3J", 2));
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

    /**
     * 985. 查询后的偶数和
     * 给出一个整数数组 A 和一个查询数组 queries。
     * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。
     * 然后，第 i 次查询的答案是 A 中偶数值的和。
     * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
     * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
     *
     * @param A       整数数组
     * @param queries 查询数组
     * @return 查询结果
     */
    private int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int total = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                total += i;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int val = queries[i][0];
            int old = A[index];
            if (old % 2 == 0) {
                total -= old;
            }
            A[index] += val;
            if (A[index] % 2 == 0) {
                total += A[index];
            }
            ans[i] = total;
        }
        return ans;
    }

    /**
     * 521. 最长特殊序列 Ⅰ
     * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。
     * 最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
     * 子序列可以通过删去字符串中的某些字符实现，
     * 但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
     * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
     *
     * @param a 字符串a
     * @param b 字符串b
     * @return 特殊序列的长度
     */
    private int findLUSlength(String a, String b) {
        return a.equals(b) ? a.length() : Math.max(a.length(), b.length());
    }

    /**
     * 482. 密钥格式化
     * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。
     * N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，除了第一个分组以外，
     * 每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，
     * 并且将所有的小写字母转换为大写字母。
     * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
     *
     * @param S 字符串s
     * @param K 拆成K个
     * @return 格式化的字符串
     */
    private static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1, j = 0; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (j % K == 0 && j != 0) {
                    sb.insert(0, "-");
                }
                sb.insert(0, S.charAt(i));
                j++;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    /**
     * 492. 构造矩形
     * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。
     * 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
     * 1. 你设计的矩形页面必须等于给定的目标面积。
     * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
     * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
     * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
     *
     * @param area 矩形面积
     * @return 长宽
     */
    private int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt != 0) {
            --sqrt;
        }
        return new int[]{area / sqrt, sqrt};
    }

    /**
     * 232. 用栈实现队列
     * 使用栈实现队列的下列操作：
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     */
    private class MyQueue {

        private Stack<Integer> mStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            mStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            mStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return mStack.remove(0);
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return mStack.get(0);
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return mStack.isEmpty();
        }
    }

    /**
     * 225. 用队列实现栈
     * 使用队列实现栈的下列操作：
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     */
    private class MyStack {

        private ArrayDeque<Integer> mQueue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            mQueue = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            mQueue.addLast(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        @SuppressWarnings("ConstantConditions")
        public int pop() {
            return mQueue.pollLast();
        }

        /**
         * Get the top element.
         */
        @SuppressWarnings("ConstantConditions")
        public int top() {
            return mQueue.peekLast();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return mQueue.isEmpty();
        }
    }
}
