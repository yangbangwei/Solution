package com.qianxinde.solution;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-11-26
 */
public class Test_2019_11_29 {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram1("aaaa", "a"));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 237. 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     * @param node 删除节点
     */
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 344. 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * @param s 字符串
     */
    private static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 方法1，排序后对比
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 是否为异位词
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);

        return new String(char1).equals(new String(char2));
    }

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 方法2，通过出现次数判断
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 是否为异位词
     */
    private static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for (int i : cnt) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 226. 翻转二叉树
     * 翻转一棵二叉树。
     *
     * @param root 二叉树
     * @return 翻转之后的二叉树
     */
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 374. 猜数字大小
     * 我们正在玩一个猜数字游戏。 游戏规则如下：
     * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     * 每次你猜错了，我会告诉你这个数字是大了还是小了。
     * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
     * 方法1，二分法，low+（high-low)/2防止Int类型溢出
     *
     * @param n 最大范围
     * @return 猜对的值
     */
    private static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 374. 猜数字大小
     * 我们正在玩一个猜数字游戏。 游戏规则如下：
     * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     * 每次你猜错了，我会告诉你这个数字是大了还是小了。
     * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
     * 方法2，三分法
     *
     * @param n 最大范围
     * @return 猜对的值
     */
    private static int guessNumber1(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 3;
            int mid1 = high - (high - low) / 3;
            int res = guess(mid);
            int res1 = guess(mid1);
            if (res == 0) {
                return mid;
            } else if (res1 == 0) {
                return mid1;
            } else if (res < 0) {
                high = mid - 1;
            } else if (res1 > 0) {
                low = mid1 + 1;
            } else {
                low = mid + 1;
                high = mid1 - 1;
            }
        }
        return -1;
    }

    private static int guess(int num) {
        int result = 10;
        if (num > result) {
            return 1;
        } else if (num < result) {
            return -1;
        } else {
            return 0;
        }
    }
}
