package com.qianxinde.solution.date_2019_12;

import java.util.Stack;

/**
 * @author :yangbw
 * @date :2019-12-19
 */
public class Test_2019_12_20 {

    public static void main(String[] args) {

    }

    private int ans;

    /**
     * 938. 二叉搜索树的范围和
     * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
     * 二叉搜索树保证具有唯一的值。
     * 方法1，递归调用
     *
     * @param root 二叉树
     * @param L    左节点
     * @param R    右节点
     * @return 节点之和
     */
    private int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    /**
     * 深度优先
     *
     * @param node 二叉树
     * @param L    左节点
     * @param R    右节点
     */
    private void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R) {
                ans += node.val;
            }
            if (L < node.val) {
                dfs(node.left, L, R);
            }
            if (node.val < R) {
                dfs(node.right, L, R);
            }
        }
    }

    /**
     * 938. 二叉搜索树的范围和
     * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
     * 二叉搜索树保证具有唯一的值。
     * 方法2，迭代器方式
     *
     * @param root 二叉树
     * @param L    左节点
     * @param R    右节点
     * @return 节点之和
     */
    private int rangeSumBST1(TreeNode root, int L, int R) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();

            if (treeNode.val >= L && treeNode.val <= R) {
                ans += treeNode.val;
            }
            if (treeNode.val > L) {
                stack.push(treeNode.left);
            }
            if (treeNode.val < R) {
                stack.push(treeNode.right);
            }
        }
        return ans;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
