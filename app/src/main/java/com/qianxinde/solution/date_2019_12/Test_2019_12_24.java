package com.qianxinde.solution.date_2019_12;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-24
 */
public class Test_2019_12_24 {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);

        diameterOfBinaryTree(treeNode);

        System.out.println(reverseStr("a", 2));

        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5},
                new int[]{9, 4, 9, 8, 4})));

        System.out.println(isPerfectSquare(808201));
    }

    private static int max = 1;

    /**
     * 543. 二叉树的直径
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过根结点。
     *
     * @param root 二叉树
     * @return 二叉树的直径
     */
    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dps(root);
        return max - 1;
    }

    /**
     * 深度遍历
     *
     * @param root 二叉树
     * @return 返回每层深度
     */
    private static int dps(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dps(root.left);
        int r = dps(root.right);
        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
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
     * 541. 反转字符串 II
     * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
     * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
     * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
     *
     * @param s 字符串
     * @param k k个字符进行反转
     * @return 反转后的结果
     */
    private static String reverseStr(String s, int k) {
        boolean isReverse = true;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += k) {
            if (isReverse) {
                int l = i;
                int r = Math.min(chars.length, i + k) - 1;
                while (l < r) {
                    char temp = chars[r];
                    chars[r] = chars[l];
                    chars[l] = temp;
                    l++;
                    r--;
                }
            }
            isReverse = !isReverse;
        }
        return String.valueOf(chars);
    }

    /**
     * 349. 两个数组的交集
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组交集
     */
    private static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        for (int i : nums1) {
            hashSet1.add(i);
        }
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int i : nums2) {
            hashSet2.add(i);
        }
        hashSet1.retainAll(hashSet2);
        int[] ans = new int[hashSet1.size()];
        int i = 0;
        for (Integer integer : hashSet1) {
            ans[i++] = integer;
        }
        return ans;
    }

    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 方法1，hashMap
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i : nums1) {
            int count = hashMap1.getOrDefault(i, 0);
            hashMap1.put(i, ++count);
        }
        List<Integer> data = new ArrayList<>();
        for (int i : nums2) {
            int count = hashMap1.getOrDefault(i, 0);
            if (i > 0) {
                data.add(i);
                hashMap1.put(i, --count);
            }
        }
        int[] num = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            num[i] = data.get(i);
        }
        return num;
    }

    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 方法2，排序，一一对比
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    private static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> data = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                data.add(nums1[i]);
                i++;
                j++;
            }

        }
        int[] num = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            num[i] = data.get(i);
        }
        return num;
    }

    /**
     * 367. 有效的完全平方数
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     * 说明：不要使用任何内置的库函数，如  sqrt。
     *
     * @param num 正整数
     * @return 是否为完全平方数
     */
    private static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long l = 0;
        long r = num / 2;
        while (l <= r) {
            long m = (r - l) / 2 + l;
            if (m * m == num) {
                return true;
            } else if (m * m < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    /**
     * 409. 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * @param s 字符串
     * @return 回文的长度
     */
    private static int longestPalindrome(String s) {
        int[] nums = new int[126];
        for (char c : s.toCharArray()) {
            nums[c]++;
        }
        int ans = 0;
        for (int num : nums) {
            ans += num / 2 * 2;
            if (num % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
