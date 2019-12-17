package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-17
 */
public class Test_2019_12_17 {

    public static void main(String[] args) {
        System.out.println(maximumProduct1(new int[]{1, 2, 3, 4}));
    }

    /**
     * 653. 两数之和 IV - 输入 BST
     * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true
     *
     * @param root 二叉树
     * @param k    目标结果
     * @return 是否包含目标结果
     */
    private static boolean findTarget(TreeNode root, int k) {
        List<Integer> data = new ArrayList<>();
        addTreeNode(data, root);
        int left = 0;
        int right = data.size() - 1;
        while (left < right) {
            if (data.get(left) + data.get(right) == k) {
                return true;
            } else if (data.get(left) + data.get(right) > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    /**
     * 添加数组到list
     *
     * @param data 储存数据
     * @param root 二叉树
     */
    private static void addTreeNode(List<Integer> data, TreeNode root) {
        if (root == null) {
            return;
        }
        data.add(root.val);
        addTreeNode(data, root.left);
        addTreeNode(data, root.right);
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
     * 628. 三个数的最大乘积
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     *
     * @param nums 整数数组
     * @return 3个数最大乘积
     */
    private static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    /**
     * 628. 三个数的最大乘积
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     *
     * @param nums 整数数组
     * @return 3个数最大乘积
     */
    private static int maximumProduct1(int[] nums) {
        int m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE, m3 = Integer.MIN_VALUE;
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m3 = m2;
                m2 = num;
            } else if (num > m3) {
                m3 = num;
            }
            if (n1 > num) {
                n2 = n1;
                n1 = num;
            } else if (n2 > num) {
                n2 = num;
            }
        }

        return Math.max(m1 * m2 * m3, m1 * n1 * n2);
    }

}
