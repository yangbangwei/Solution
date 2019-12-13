package com.qianxinde.solution.date_2019_12;

import java.util.HashSet;

/**
 * @author :yangbw
 * @date :2019-12-11
 */
public class Test_2019_12_13 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        removeElements(listNode, 6);
    }

    /**
     * 299. 猜数字游戏
     * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
     * 每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
     * 有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     *
     * @param secret 数字
     * @param guess  要猜的数字
     * @return 返回结果
     */
    private static String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] bucket = new int[10];
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                bulls++;
                continue;
            }
            bucket[s[i] - '0']++;
            bucket[g[i] - '0']--;
        }
        for (int i : bucket) {
            if (i > 0) {
                cows += i;
            }
        }
        cows = s.length - cows - bulls;
        return bulls + "A" + cows + "B";
    }

    /**
     * 203. 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     *
     * @param head 链表
     * @param val  删除节点
     * @return 删除后链表
     */
    private static ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode prev = ans;
        while (head != null) {
            if (head.val != val) {
                prev.next = head;
                prev = head;
            } else {
                prev.next = head.next;
            }
            head = head.next;
        }
        return ans.next;
    }

    /**
     * 203. 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     *
     * @param head 链表
     * @param val  删除节点
     * @return 删除后链表
     */
    private static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * @param nums 数组
     * @return 是否出现两次
     */
    private static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 459. 重复的子字符串
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
     * 给定的字符串只含有小写英文字母，并且长度不超过10000。
     *
     * @param s 字符串
     * @return 是否为重复字符
     */
    private static boolean repeatedSubstringPattern(String s) {
        String temp = s + s;
        return temp.substring(1, temp.length() - 1).contains(s);
    }

    /**
     * 485. 最大连续1的个数
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     *
     * @param nums 数组
     * @return 最大连续1的个数
     */
    private static int findMaxConsecutiveOnes(int[] nums) {
        int total = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                total++;
            } else {
                max = Math.max(total, max);
                total = 0;
            }
        }
        return max;
    }

    /**
     * 434. 字符串中的单词数
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     *
     * @param s 字符串
     * @return 单词个数
     */
    private static int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        return s.split("\\s+").length;
    }

    /**
     * 434. 字符串中的单词数
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     *
     * @param s 字符串
     * @return 单词个数
     */
    private static int countSegments1(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == ' ') {
                if (s.charAt(i) != ' ') {
                    num++;
                }
            }
        }
        return num;
    }
}
