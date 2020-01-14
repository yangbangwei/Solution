package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_14 {

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));

        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
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
        list.add(root.val);
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
        if (root.right != null) {
            dfs(root.right, list);
        }
    }

    /**
     * 876. 链表的中间结点
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 方法1，快慢指针
     *
     * @param head 链表
     * @return 中间节点
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 876. 链表的中间结点
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 方法2，保存到数组中
     *
     * @param head 链表
     * @return 中间节点
     */
    private ListNode middleNode1(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int i = 0;
        while (head != null) {
            nodes[i++] = head;
            head = head.next;
        }
        return nodes[i / 2];
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 908. 最小差值 I
     *
     * @param A 数组A
     * @param K -k~k
     * @return 最小差值
     */
    private int smallestRangeI(int[] A, int K) {
        int max = A[0], min = A[0];
        for (int i : A) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        return Math.max(0, max - min - 2 * K);
    }

    /**
     * 697. 数组的度
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     *
     * @param nums 数组
     * @return 最小的度
     */
    private static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
            if (!leftMap.containsKey(num)) {
                leftMap.put(num, i);
            }
            rightMap.put(num, i);
        }
        int count = Collections.max(numMap.values());
        int min = nums.length;
        for (Integer integer : numMap.keySet()) {
            if (numMap.get(integer) == count) {
                int left = leftMap.getOrDefault(integer, 0);
                int right = rightMap.getOrDefault(integer, 0);
                min = Math.min(min, right - left + 1);
            }
        }
        return min;
    }

    /**
     * 922. 按奇偶排序数组 II
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     * @param A 数组
     * @return 调整后的数组
     */
    private static int[] sortArrayByParityII(int[] A) {
        int[] nums1 = new int[A.length];
        int[] nums2 = new int[A.length];
        for (int i = 0, j = 0, k = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                nums1[j++] = A[i];
            } else {
                nums2[k++] = A[i];
            }
        }
        for (int i = 0, j = 0, k = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = nums1[j++];
            } else {
                A[i] = nums2[k++];
            }
        }
        return A;
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