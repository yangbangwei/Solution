package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-17
 */
public class Test_2019_12_17 {

    public static void main(String[] args) {

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

}
