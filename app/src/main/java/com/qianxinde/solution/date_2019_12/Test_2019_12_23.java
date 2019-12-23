package com.qianxinde.solution.date_2019_12;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-23
 */
public class Test_2019_12_23 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(5);

        System.out.println(getIntersectionNode(listNode1, listNode2));
    }

    /**
     * 884. 两句话中的不常见单词
     * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
     * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
     * 返回所有不常用单词的列表。
     * 您可以按任何顺序返回列表。
     *
     * @param A 字符串A
     * @param B 字符串B
     * @return 不常用的单词
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String c : A.split(" ")) {
            int time = hashMap.getOrDefault(c, 0);
            hashMap.put(c, ++time);
        }
        for (String c : B.split(" ")) {
            int time = hashMap.getOrDefault(c, 0);
            hashMap.put(c, ++time);
        }
        List<String> data = new ArrayList<>();
        for (String s : hashMap.keySet()) {
            if (hashMap.get(s) == 1) {
                data.add(s);
            }
        }
        return data.toArray(new String[0]);
    }

    /**
     * 160. 相交链表
     * 编写一个程序，找到两个单链表相交的起始节点。
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交节点
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 108. 将有序数组转换为二叉搜索树
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * @param nums 数组
     * @return 二叉树
     */
    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null && nums.length == 0) {
            return null;
        }
        return dsf(nums, 0, nums.length - 1);
    }

    /**
     * 深度优先算法
     *
     * @param nums  数组
     * @param left  左边界
     * @param right 右边界
     * @return 二叉树
     */
    private static TreeNode dsf(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = dsf(nums, left, middle - 1);
        treeNode.right = dsf(nums, middle + 1, right);
        return treeNode;
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
