package com.qianxinde.solution;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author :yangbw
 * @date :2019-11-26
 */
public class Test_2019_11_26 {

    public static void main(String[] args) {
        System.out.println(getRow(3));

        int[] nums = {1, 2};
        System.out.println(maxProfit1(nums));

        int[] nums1 = {17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        System.out.println(singleNumber(nums1));

        System.out.println(isPalindrome("race a car"));

        System.out.println(convertToTitle(1));

        System.out.println(titleToNumber("AAA"));
    }

    /**
     * 119. 杨辉三角 II
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *
     * @param rowIndex 第几行
     * @return 返回结果
     */
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> data = new ArrayList<>();
        long nk = 1;
        for (int i = 0; i <= rowIndex; i++) {
            data.add((int) nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return data;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     * 方法1
     *
     * @param prices 周期列表
     * @return 返回最大利润
     */
    private static int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length == 0) {
            return max;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j <= prices.length - 1; j++) {
                max = Math.max(max, -prices[i] + prices[j]);
            }
        }
        return max;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票。
     * 方法2
     *
     * @param prices 周期列表
     * @return 返回最大利润
     */
    private static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 0) {
            return maxProfit;
        }
        int minProfit = prices[0];
        for (int price : prices) {
            if (minProfit > price) {
                minProfit = price;
            } else if (price - minProfit > maxProfit) {
                maxProfit = price - minProfit;
            }
        }
        return maxProfit;
    }

    /**
     * 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 方法1，排序后，判断前后两个是否相同
     *
     * @param nums 数组
     * @return 返回唯一值
     */
    private static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int single = nums[0];
        int i = 1;
        while (i < nums.length - 1) {
            if (single == nums[i]) {
                single = nums[i + 1];
                i++;
            }
            i++;
        }
        return single;
    }

    /**
     * 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 方法2，异或，n^n=0,0^n=n
     *
     * @param nums 数组
     * @return 返回唯一值
     */
    private static int singleNumber1(int[] nums) {
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    /**
     * 125. 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * @param s 字符串
     * @return 返回是否为回文
     */
    private static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     * 方法1，快慢双指针
     *
     * @param head 链表
     * @return 是否有环
     */
    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     * 方法1，集合
     *
     * @param head 链表
     * @return 是否有环
     */
    private static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> listNodes = new HashSet<>();
        while (head.next != null) {
            if (listNodes.contains(head)) {
                return true;
            } else {
                listNodes.add(head);
                head = head.next;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            return super.equals(obj);
        }
    }

    public static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> helper;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int x) {
            stack.add(x);
            if (helper.isEmpty() || helper.peek() > x) {
                helper.push(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                int num = stack.pop();
                if (num == helper.peek()) {
                    helper.pop();
                }
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                return stack.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

        public int getMin() {
            if (helper.isEmpty()) {
                return helper.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
    }

    static class MinStack1 {

        class Node {
            int val;
            int min;
            Node next;

            Node(int x, int y) {
                val = x;
                min = y;
                next = null;
            }

        }

        Node head;

        /**
         * initialize your data structure here.
         */
        public MinStack1() {
        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, Math.min(0, x));
            } else {
                Node n = new Node(x, Math.min(head.min, x));
                n.next = head;
                head = n;
            }
        }

        public void pop() {
            if (head != null) {
                head = head.next;
            }
        }

        public int top() {
            if (head != null) {
                return head.val;
            }
            return -1;
        }

        public int getMin() {
            if (null != head) {
                return head.min;
            }
            return -1;
        }
    }

    /**
     * 168. Excel表列名称
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 1 -> A
     * 2 -> B
     * 3 -> C
     *
     * @param n 行数
     * @return 转换成大写
     */
    private static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            //从‘A’开始算，所以需要减1
            n--;
            stringBuilder.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        //颠倒顺序
        return stringBuilder.reverse().toString();
    }

    /**
     * 171. Excel表列序号
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * A -> 1
     * B -> 2
     * C -> 3
     *
     * @param s 表列序号
     * @return 行数
     */
    private static int titleToNumber(String s) {
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            row = row * 26 + (s.charAt(i) - 'A' + 1);
        }
        return row;
    }
}
