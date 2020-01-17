package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @author :yangbw
 * @date :2020_01_17
 */
public class Test_2020_01_17 {

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));

        System.out.println(findUnsortedSubarray(new int[]{2, 1}));

        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        System.out.println(findSecondMinimumValue(treeNode));
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

    /**
     * 530. 二叉搜索树的最小绝对差
     * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
     *
     * @param root 二叉树
     * @return 最小值
     */
    private int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getMinimumDifferenceDFS(root, list);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(Math.abs(list.get(i) - list.get(i - 1)), min);
        }
        return min;
    }

    /**
     * 遍历所有二叉树
     *
     * @param root 二叉树
     * @param list list
     */
    private void getMinimumDifferenceDFS(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getMinimumDifferenceDFS(root.left, list);
        getMinimumDifferenceDFS(root.right, list);
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
     * 532. 数组中的K-diff数对
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
     * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     *
     * @param nums 数组
     * @param k    整数k
     * @return 绝对值为k的数
     */
    private static int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashSet<Integer> diff = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(k - num)) {
                diff.add(k - num);
            }
            if (set.contains(k + num)) {
                set.add(num);
            }
            set.add(num);
        }
        return diff.size();
    }

    /**
     * 235. 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * @param root 二叉树
     * @param p    左节点
     * @param q    右节点
     * @return 最近公共祖先
     */
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    private int add;

    /**
     * 538. 把二叉搜索树转换为累加树
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
     * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     *
     * @param root 二叉树
     * @return 累加树
     */
    private TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        root.val += add;
        add = root.val;
        convertBST(root.left);
        return root;
    }

    /**
     * 581. 最短无序连续子数组
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 你找到的子数组应是最短的，请输出它的长度
     *
     * @param nums 数组
     * @return 需要修改的数列
     */
    private static int findUnsortedSubarray(int[] nums) {
        int[] old = new int[nums.length];
        System.arraycopy(nums, 0, old, 0, old.length);
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (old[i] != nums[i]) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (old[i] != nums[i]) {
                right = i;
                break;
            }
        }
        return right - left > 0 ? right - left + 1 : 0;
    }

    private int tilt;

    /**
     * 563. 二叉树的坡度
     * 给定一个二叉树，计算整个树的坡度。
     * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
     * 整个树的坡度就是其所有节点的坡度之和。
     *
     * @param root 二叉树
     * @return 坡度之和
     */
    private int findTilt(TreeNode root) {
        findTiltDFS(root);
        return tilt;
    }

    /**
     * 计算每层坡度
     *
     * @param root 二叉树
     * @return 返回每层坡度
     */
    private int findTiltDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTiltDFS(root.left);
        int right = findTiltDFS(root.right);
        tilt += Math.abs(right - left);
        return left + right + root.val;
    }

    /**
     * 671. 二叉树中第二小的节点
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
     * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
     * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     *
     * @param root 二叉树
     * @return 第二小的值
     */
    private static int findSecondMinimumValue(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        boolean isHad = false;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (first > treeNode.val) {
                second = first;
                first = treeNode.val;
            } else if (first < treeNode.val && second >= treeNode.val) {
                second = treeNode.val;
                isHad = true;
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        return isHad ? -1 : second;
    }


}
