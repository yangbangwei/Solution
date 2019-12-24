package com.qianxinde.solution.date_2019_12;

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
}
