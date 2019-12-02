package com.qianxinde.solution.date_2019_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-11-25
 */
public class Test_2019_11_25 {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));

        generate(5);
    }

    /**
     * 69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * @param x 输入值
     * @return 返回开平方
     */
    private static int mySqrt(int x) {
        long lo = 1, hi = x;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (mid * mid > x) {
                hi = mid - 1;
            } else if ((mid + 1) * (mid + 1) <= x) {
                lo = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return 0;
    }

    /**
     * 292. Nim 游戏
     * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。
     * 拿掉最后一块石头的人就是获胜者。你作为先手。
     *
     * @param n 石头个数
     * @return 是否能获胜
     */
    private static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * @param root 当前树
     * @return 返回最大深度
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countDepth(1, root);
    }

    /**
     * 统计树的深度
     *
     * @param length 上一级深度
     * @param root   当前节点
     * @return 返回当前深度
     */
    private static int countDepth(int length, TreeNode root) {
        if (root.left == null && root.right == null) {
            return length;
        }
        length++;
        if (root.left == null) {
            return countDepth(length, root.right);
        }
        if (root.right == null) {
            return countDepth(length, root.left);
        }
        int num1 = countDepth(length, root.left);
        int num2 = countDepth(length, root.right);
        return Math.max(num1, num2);
    }

    /**
     * 107. 二叉树的层次遍历 II
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * @param root 根节点
     * @return 返回层次遍历结果
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> data = new ArrayList<>();
        if (root == null) {
            return data;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        data.add(list);
        leftAndRight(data, 1, root);
        Collections.reverse(data);
        return data;
    }

    /**
     * 遍历二叉树所有节点
     *
     * @param data  遍历结果
     * @param level 层级
     * @param root  根节点
     */
    private static void leftAndRight(List<List<Integer>> data, int level,
                                     TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        if (data.size() > level) {
            list = data.get(level);
            data.remove(level);
        }
        if (root.left != null) {
            list.add(root.left.val);
        }
        if (root.right != null) {
            list.add(root.right.val);
        }
        data.add(level, list);
        if (root.left != null) {
            leftAndRight(data, level + 1, root.left);
        }
        if (root.right != null) {
            leftAndRight(data, level + 1, root.right);
        }
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
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     * @param numRows 生成行数
     * @return 返回生成结果
     */
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> data = new ArrayList<>();
        if (numRows == 0) {
            return data;
        }
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    List<Integer> oldList = data.get(data.size() - 1);
                    list.add(oldList.get(j - 1) + oldList.get(j));
                }
            }
            data.add(list);
        }
        return data;
    }

}
