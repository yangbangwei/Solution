package com.qianxinde.solution.date_2019_12;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author :yangbw
 * @date :2019-12-19
 */
public class Test_2019_12_20 {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        int[] num1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] num2 = {2, 42, 38, 0, 43, 21};
        System.out.println(Arrays.toString(relativeSortArray(num1, num2)));

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(7);
        System.out.println(averageOfLevels(treeNode));

        System.out.println(Arrays.toString(nextGreaterElement1(new int[]{1, 3, 5, 2, 4},
                new int[]{6, 5, 4, 3, 2, 1, 7})));
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

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static List<Double> data = new ArrayList<>();
    private static HashMap<Integer, Double> hmTotal = new HashMap<>();
    private static HashMap<Integer, Integer> hmCount = new HashMap<>();

    /**
     * 637. 二叉树的层平均值
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
     * 方法1，递归调用
     *
     * @param root 二叉树
     * @return 每一层平均值
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        data.add((double) root.val);
        average(0, root.left, root.right);
        for (Integer integer : hmTotal.keySet()) {
            data.add(hmTotal.get(integer) / hmCount.get(integer));
        }
        return data;
    }

    /**
     * 记录每层的总数和个数
     *
     * @param deep  层次
     * @param left  左节点
     * @param right 由节点
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void average(int deep, TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }
        deep++;
        Double total = hmTotal.getOrDefault(deep, 0.0);
        int count = hmCount.getOrDefault(deep, 0);
        if (left != null) {
            total += left.val;
            hmTotal.put(deep, total);
            hmCount.put(deep, ++count);
            average(deep, left.left, left.right);
        }
        if (right != null) {
            total += right.val;
            hmTotal.put(deep, total);
            hmCount.put(deep, ++count);
            average(deep, right.left, right.right);
        }
    }

    /**
     * 637. 二叉树的层平均值
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
     * 方法2，迭代器
     *
     * @param root 二叉树
     * @return 每一层平均值
     */
    private static List<Double> averageOfLevels1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            long total = 0, count = 0;
            Queue<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                total += node.val;
                count++;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            data.add(total * 1.0 / count);
            queue = temp;
        }
        return data;
    }

    /**
     * 496. 下一个更大元素 I
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
     * 如果不存在，对应位置输出-1。
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 更大元素
     */
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int index = hashMap.get(num) + 1;
            nums1[i] = -1;
            if (index != 0) {
                while (index < nums2.length) {
                    if (num < nums2[index]) {
                        nums1[i] = nums2[index];
                        break;
                    }
                    index++;
                }
            }
        }
        return nums1;
    }

    /**
     * 496. 下一个更大元素 I
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
     * 如果不存在，对应位置输出-1。
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 更大元素
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hasMap = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hasMap.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    /**
     * 509. 斐波那契数
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
     * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)。
     *
     * @param N 整数0<=n<=30
     * @return F（N）
     */
    private static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int[] nums = new int[N + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= N; i++) {
            nums[i] = nums[i - 1] + nums[i - 1];
        }
        return nums[N];
    }
}
