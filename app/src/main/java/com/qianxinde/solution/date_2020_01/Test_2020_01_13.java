package com.qianxinde.solution.date_2020_01;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_13 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));

        System.out.println(freqAlphabets("10#11#12"));

        System.out.println(validPalindrome("acbab"));

        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    /**
     * 5307. 将整数转换为两个无零整数的和
     * 「无零整数」是十进制表示中 不含任何 0 的正整数。
     * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
     * A 和 B 都是无零整数
     * A + B = n
     * 题目数据保证至少有一个有效的解决方案。
     * 如果存在多个有效解决方案，你可以返回其中任意一个。
     *
     * @param n 整数
     * @return 符合的结果
     */
    private int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int num = n - i;
            if (!String.valueOf(i).contains("0")
                    && !String.valueOf(num).contains("0")) {
                return new int[]{i, num};
            }
        }
        return null;
    }

    /**
     * 5143. 解压缩编码列表
     * 给你一个以行程长度编码压缩的整数列表 nums 。
     * 考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
     * 请你返回解压后的列表。
     *
     * @param nums 整数列表
     * @return 解压后结果
     */
    private static int[] decompressRLElist(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                integers.add(nums[i + 1]);
            }
        }
        int[] ans = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ans[i] = integers.get(i);
        }
        return ans;
    }

    /**
     * 1309. 解码字母到整数映射
     * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
     * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
     * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
     * 返回映射之后形成的新字符串。
     * 题目数据保证映射始终唯一。
     *
     * @param s 整数字符串
     * @return 映射后的字符串
     */
    private static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char[] words = s.toCharArray();
        char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = words.length - 1; i >= 0; i--) {
            int num;
            if (words[i] == '#') {
                num = (words[i - 2] - '0') * 10 + (words[i - 1] - '1');
                i -= 2;
            } else {
                num = words[i] - '1';
            }
            sb.insert(0, letter[num]);
        }
        return sb.toString();
    }

    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     * 方法1，遍历后判断
     *
     * @param head 链表
     * @return 是否为回文链表
     */
    private boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int length = list.size();
        for (int i = 0; i <= length / 2; i++) {
            if (!list.get(i).equals(list.get(length - i - 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     * 方法2，快慢指针
     *
     * @param head 链表
     * @return 是否为回文链表
     */
    private boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;

            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 680. 验证回文字符串 Ⅱ
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * @param s 字符串
     * @return 是否为回文字符串
     */
    private static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isEqual(s, i + 1, j) || isEqual(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 判断是否相同
     *
     * @param s 字符串
     * @param i 左边指针
     * @param j 右指针
     * @return 是否为回文
     */
    private static boolean isEqual(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 575. 分糖果
     * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
     * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
     *
     * @param candies 糖果种类
     * @return 妹妹最大种类数
     */
    private int distributeCandies(int[] candies) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int candy : candies) {
            hashSet.add(candy);
        }
        return Math.min(hashSet.size() / 2, candies.length / 2);
    }

    /**
     * 559. N叉树的最大深度
     * 给定一个 N 叉树，找到其最大深度。
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     *
     * @param root N叉树
     * @return 最长路径
     */
    private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return max;
    }

    private int max = 0;

    private void dfs(Node node, int depth) {
        if (node.children.isEmpty()) {
            max = Math.max(max, depth);
        } else {
            for (Node child : node.children) {
                dfs(child, depth + 1);
            }
        }
    }

    class Node {
        private int val;
        private List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 594. 最长和谐子序列
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
     * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
     *
     * @param nums 数组
     * @return 子序中找到最长的长度
     */
    @SuppressWarnings("ConstantConditions")
    private static int findLHS(int[] nums) {
        @SuppressLint("UseSparseArrays") HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            int i = hashMap.getOrDefault(num, 0);
            hashMap.put(num, ++i);
        }
        for (int key : hashMap.keySet()) {
            if (hashMap.containsKey(key + 1)) {
                max = Math.max(max, hashMap.get(key) + hashMap.get(key + 1));
            }
        }
        return max;
    }

    /**
     * 598. 范围求和 II
     * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
     * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，
     * 含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
     * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
     *
     * @param m   矩阵m
     * @param n   矩阵n
     * @param ops 操作数组
     * @return 最大整数的个数
     */
    private int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(op[0], m);
            n = Math.min(op[1], n);
        }
        return m * n;
    }
}
