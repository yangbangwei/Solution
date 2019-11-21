package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-21
 */
public class Test_2019_11_21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoLists2(l1, l2);

    }

    /**
     * 21. 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     * 解法一
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合成后链表
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l2, l1.next);
            return l1;
        }
    }

    /**
     * 21. 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     * 解法二
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合成后链表
     */
    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    /**
     * 21. 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     * 解法三
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合成后链表
     */
    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l2.val < l1.val) {
            ListNode tmp = l2;
            l2 = l1;
            l1 = tmp;
        }
        l1.next = mergeTwoLists2(l1, l2);
        return l1;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
