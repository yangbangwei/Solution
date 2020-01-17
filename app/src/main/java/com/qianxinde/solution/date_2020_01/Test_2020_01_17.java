package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_17
 */
public class Test_2020_01_17 {

    public static void main(String[] args) {

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

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
