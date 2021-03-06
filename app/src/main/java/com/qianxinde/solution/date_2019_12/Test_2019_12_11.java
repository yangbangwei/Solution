package com.qianxinde.solution.date_2019_12;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author :yangbw
 * @date :2019-12-11
 */
public class Test_2019_12_11 {

    public static void main(String[] args) {

        System.out.println(hammingDistance(2, 3));

        System.out.println(findComplement(2));

        System.out.println(firstUniqChar("loveleetcode"));

        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    /**
     * 461. 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离
     *
     * @param x 整数x
     * @param y 整数y
     * @return 汉明距离
     */
    private static int hammingDistance(int x, int y) {
        int count = 0;
        int temp = x ^ y;
        while (temp != 0) {
            if ((temp & 1) == 1) {
                count++;
            }
            temp = temp >>> 1;
        }
        return count;
    }

    /**
     * 476. 数字的补数
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     *
     * @param num 正整数
     * @return 补数
     */
    private static int findComplement(int num) {
        long num2 = 1;
        while (num2 <= num) {
            num2 = num2 << 1;
        }
        num2--;
        return (int) num2 ^ num;
    }

    /**
     * 387. 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * @param s 字符串
     * @return 返回不重复字符下标
     */
    private static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int num = s.indexOf(temp);
            if (s.indexOf(temp, num + 1) == -1) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 371. 两整数之和
     *
     * @param a 整数a
     * @param b 整数b
     * @return 两者之和
     */
    private static int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    /**
     * 206. 反转链表
     * 反转一个单链表
     *
     * @param head 链表
     * @return 反转后链表
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 206. 反转链表
     * 反转一个单链表
     *
     * @param head 链表
     * @return 反转后链表
     */
    private static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 268. 缺失数字
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * @param nums 整数数组
     * @return 缺失数字
     */
    private static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        for (int num : nums) {
            if (num == temp) {
                temp++;
            } else {
                return num;
            }
        }
        return -1;
    }

    /**
     * 268. 缺失数字
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * @param nums 整数数组
     * @return 缺失数字
     */
    private static int missingNumber1(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * 404. 左叶子之和
     * 计算给定二叉树的所有左叶子之和。(无子节点）
     *
     * @param root 二叉树
     * @return 右叶子之和
     */
    private static int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            }
            ans += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            ans += sumOfLeftLeaves(root.right);
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 290. 单词规律
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 
     * str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * @param pattern 规律
     * @param str     字符串
     * @return 是否符合对应规律
     */
    private static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hashMap = new HashMap<>();
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            char key = pattern.charAt(i);
            if (hashMap.containsKey(key)) {
                String word = hashMap.get(key);
                if (!word.equals(words[i])) {
                    return false;
                }
            } else {
                if (hashMap.containsValue(words[i])) {
                    return false;
                }
                hashMap.put(key, words[i]);
            }
        }
        return true;
    }
}
