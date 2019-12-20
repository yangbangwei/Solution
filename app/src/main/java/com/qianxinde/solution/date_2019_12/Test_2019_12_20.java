package com.qianxinde.solution.date_2019_12;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author :yangbw
 * @date :2019-12-19
 */
public class Test_2019_12_20 {

    public static void main(String[] args) {
        int[] num1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] num2 = {2, 42, 38, 0, 43, 21};
        System.out.println(Arrays.toString(relativeSortArray(num1, num2)));
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

    /**
     * 1122. 数组的相对排序
     * 给你两个数组，arr1 和 arr2，
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
     * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 排序后结果
     */
    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int i : arr1) {
            bucket[i]++;
        }
        int j = 0;
        for (int num : arr2) {
            while (bucket[num]-- > 0) {
                arr1[j++] = num;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (bucket[i]-- > 0) {
                arr1[j++] = i;
            }
        }
        return arr1;
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
