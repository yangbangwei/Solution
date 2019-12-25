package com.qianxinde.solution.date_2019_12;

import java.util.HashSet;

/**
 * @author :yangbw
 * @date :2019-12-25
 */
public class Test_2019_12_25 {

    public static void main(String[] args) {

    }

    private static HashSet<Integer> hashSet = new HashSet<>();

    /**
     * 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
     * 这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     * 方法1，遍历后存储在hashset中，然后判断
     *
     * @param root 二叉树
     * @param sum  目标值
     * @return 是否符合目标值
     */
    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dsf(root, root.val);
        return hashSet.contains(sum);
    }

    /**
     * 深度优先遍历
     *
     * @param root 二叉树
     * @param num  累加值
     */
    private static void dsf(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            hashSet.add(num);
            return;
        }
        if (root.left != null) {
            dsf(root.left, root.left.val + num);
        }
        if (root.right != null) {
            dsf(root.right, root.right.val + num);
        }
    }

    /**
     * 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
     * 这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     * 方法2，每次累减，叶节点时是否为0
     *
     * @param root 二叉树
     * @param sum  目标值
     * @return 是否符合目标值
     */
    private static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum1(root.left, sum) || hasPathSum1(root.right, sum);
    }

    private static int min = Integer.MAX_VALUE;

    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * @param root 二叉树
     * @return 最小深度
     */
    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        searchDepth(root, min);
        return min;
    }

    /**
     * 深度优先遍历
     *
     * @param root  二叉树
     * @param depth 当前深度
     */
    private static void searchDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(min, depth);
            return;
        }
        searchDepth(root.left, depth + 1);
        searchDepth(root.right, depth + 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
