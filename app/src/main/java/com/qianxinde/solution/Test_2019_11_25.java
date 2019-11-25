package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-25
 */
public class Test_2019_11_25 {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
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
        return num1 >= num2 ? num1 : num2;
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
