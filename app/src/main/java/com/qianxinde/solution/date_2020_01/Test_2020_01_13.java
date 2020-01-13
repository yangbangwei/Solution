package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_13 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));

        System.out.println(freqAlphabets("10#11#12"));
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
}
