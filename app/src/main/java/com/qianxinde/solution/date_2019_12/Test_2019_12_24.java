package com.qianxinde.solution.date_2019_12;

import java.util.HashSet;

/**
 * @author :yangbw
 * @date :2019-12-24
 */
public class Test_2019_12_24 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);

        diameterOfBinaryTree(treeNode);

        System.out.println(reverseStr("a", 2));
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
}
