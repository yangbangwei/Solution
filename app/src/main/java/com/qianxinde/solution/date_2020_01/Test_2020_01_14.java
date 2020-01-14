package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_14 {

    public static void main(String[] args) {

    }

    /**
     * 965. 单值二叉树
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     *
     * @param root 二叉树
     * @return 是否单值二叉树
     */
    private boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int val = list.get(0);
        for (Integer integer : list) {
            if (val != integer) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深度优先遍历
     *
     * @param root 二叉树
     * @param list 链表
     */
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        }
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
