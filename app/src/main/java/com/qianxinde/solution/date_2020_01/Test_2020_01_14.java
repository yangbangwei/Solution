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

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
