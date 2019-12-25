package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-25
 */
public class Test_2019_12_25 {

    public static void main(String[] args) {
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
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
        dfs(root, root.val);
        return hashSet.contains(sum);
    }

    /**
     * 深度优先遍历
     *
     * @param root 二叉树
     * @param num  累加值
     */
    private static void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            hashSet.add(num);
            return;
        }
        if (root.left != null) {
            dfs(root.left, root.left.val + num);
        }
        if (root.right != null) {
            dfs(root.right, root.right.val + num);
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

    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 方法1
     *
     * @param root 二叉树
     * @return 是否为平衡二叉树
     */
    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int temp = search(root.left) - search(root.right);
        if (Math.abs(temp) > 1) {
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }

    /**
     * 搜索每个二叉树的深度
     *
     * @param root 二叉树
     * @return 深度
     */
    private static int search(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(search(root.left), search(root.right)) + 1;
    }

    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 方法2
     *
     * @param root 二叉树
     * @return 是否为平衡二叉树
     */
    private static boolean isBalanced1(TreeNode root) {
        return foo(root) != -1;
    }

    /**
     * 遍历二叉树
     *
     * @param treeNode 二叉树
     * @return 是否超过2
     */
    private static int foo(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int l = foo(treeNode.left);
        if (l == -1) {
            return -1;
        }
        int r = foo(treeNode.right);
        if (r == -1) {
            return -1;
        }
        return Math.abs(l - r) < 2 ? Math.max(l, r) + 1 : -1;
    }

    /**
     * 859. 亲密字符串
     * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到
     * 与 B 相等的结果，就返回 true ；否则返回 false 。
     *
     * @param A 字符串A
     * @param B 字符串B
     * @return 返回交换后是否相同
     */
    private static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] wordsA = A.toCharArray();
        char[] wordsB = B.toCharArray();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < wordsA.length; i++) {
            if (wordsA[i] != wordsB[i]) {
                data.add(i);
            }
        }
        if (data.size() == 2) {
            char temp = wordsA[data.get(0)];
            wordsA[data.get(0)] = wordsA[data.get(1)];
            wordsA[data.get(1)] = temp;
            return String.valueOf(wordsA).equals(String.valueOf(wordsB));
        } else if (data.size() == 0) {
            char[] count = new char[26];
            for (char c : wordsA) {
                count[c - 'a']++;
                if (count[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}


