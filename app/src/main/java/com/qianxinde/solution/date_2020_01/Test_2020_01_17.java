package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_17
 */
public class Test_2020_01_17 {

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }

    private List<Integer> list = new ArrayList<>();
    private TreeNode pre;
    private int max = 0;
    private int cur = 1;

    /**
     * 501. 二叉搜索树中的众数
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     * 假定 BST 有如下定义：
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     *
     * @param root 二叉树
     * @return 众数
     */
    private int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        inorder(root);
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    /**
     * 递归调用，判断是否和上个节点相同
     *
     * @param root 二叉树
     */
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null) {
            if (pre.val != root.val) {
                cur++;
            } else {
                cur = 1;
            }
        }
        if (cur > max) {
            max = cur;
            list.clear();
            list.add(root.val);
            max = cur;
        } else if (cur == max) {
            list.add(root.val);
        }
        pre = root;
        inorder(root.right);
    }

    /**
     * 530. 二叉搜索树的最小绝对差
     * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
     *
     * @param root 二叉树
     * @return 最小值
     */
    private int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getMinimumDifferenceDFS(root, list);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(Math.abs(list.get(i) - list.get(i - 1)), min);
        }
        return min;
    }

    /**
     * 遍历所有二叉树
     *
     * @param root 二叉树
     * @param list list
     */
    private void getMinimumDifferenceDFS(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getMinimumDifferenceDFS(root.left, list);
        getMinimumDifferenceDFS(root.right, list);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 532. 数组中的K-diff数对
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
     * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     *
     * @param nums 数组
     * @param k    整数k
     * @return 绝对值为k的数
     */
    private static int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashSet<Integer> diff = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(k - num)) {
                diff.add(k - num);
            }
            if (set.contains(k + num)) {
                set.add(num);
            }
            set.add(num);
        }
        return diff.size();
    }
}
