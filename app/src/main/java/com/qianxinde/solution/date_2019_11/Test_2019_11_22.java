package com.qianxinde.solution.date_2019_11;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-11-22
 */
public class Test_2019_11_22 {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {21, 5, 6};
        merge2(num1, 3, num2, 3);
    }

    /**
     * 88. 合并两个有序数组
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 方法一
     *
     * @param nums1 数组1
     * @param m     数组1的长度
     * @param nums2 数组2
     * @param n     数组2的长度
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 88. 合并两个有序数组
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 方法二，
     *
     * @param nums1 数组1
     * @param m     数组1的长度
     * @param nums2 数组2
     * @param n     数组2的长度
     */
    private static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            nums1[p] = (nums1_copy[p1] > nums2[p2]) ? nums1_copy[p2++] : nums2[p1++];
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    /**
     * 88. 合并两个有序数组
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 方法三，双指针/从后往前
     *
     * @param nums1 数组1
     * @param m     数组1的长度
     * @param nums2 数组2
     * @param n     数组2的长度
     */
    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 100. 相同的树
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param p 二叉树1
     * @param q 二叉树2
     * @return 返回是否相同
     */
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 101. 对称二叉树
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     * @param root 根结点
     * @return 是否对称
     */
    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * 根结点对称判断
     *
     * @param t1 根结点左子树
     * @param t2 根节点右子树
     * @return 是否对称
     */
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            return true;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
