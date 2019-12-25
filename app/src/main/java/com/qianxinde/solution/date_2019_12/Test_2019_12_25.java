package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @author :yangbw
 * @date :2019-12-25
 */
public class Test_2019_12_25 {

    public static void main(String[] args) {
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(backspaceCompare1("ab#c", "ad#c"));
    }

    private static HashSet<Integer> hashSet = new HashSet<>();

    /**
     * 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
     * 这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     * 方法1，遍历后存储在hashset中，然后判断
     *
     * @param root 二叉树
     * @param sum  目标值
     * @return 是否符合目标值
     */
    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dfs(root, root.val);
        return hashSet.contains(sum);
    }

    /**
     * 深度优先遍历
     *
     * @param root 二叉树
     * @param num  累加值
     */
    private static void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            hashSet.add(num);
            return;
        }
        if (root.left != null) {
            dfs(root.left, root.left.val + num);
        }
        if (root.right != null) {
            dfs(root.right, root.right.val + num);
        }
    }

    /**
     * 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
     * 这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     * 方法2，每次累减，叶节点时是否为0
     *
     * @param root 二叉树
     * @param sum  目标值
     * @return 是否符合目标值
     */
    private static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum1(root.left, sum) || hasPathSum1(root.right, sum);
    }

    private static int min = Integer.MAX_VALUE;

    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * @param root 二叉树
     * @return 最小深度
     */
    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        searchDepth(root, min);
        return min;
    }

    /**
     * 深度优先遍历
     *
     * @param root  二叉树
     * @param depth 当前深度
     */
    private static void searchDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(min, depth);
            return;
        }
        searchDepth(root.left, depth + 1);
        searchDepth(root.right, depth + 1);
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
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 方法1
     *
     * @param root 二叉树
     * @return 是否为平衡二叉树
     */
    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int temp = search(root.left) - search(root.right);
        if (Math.abs(temp) > 1) {
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }

    /**
     * 搜索每个二叉树的深度
     *
     * @param root 二叉树
     * @return 深度
     */
    private static int search(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(search(root.left), search(root.right)) + 1;
    }

    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 方法2
     *
     * @param root 二叉树
     * @return 是否为平衡二叉树
     */
    private static boolean isBalanced1(TreeNode root) {
        return foo(root) != -1;
    }

    /**
     * 遍历二叉树
     *
     * @param treeNode 二叉树
     * @return 是否超过2
     */
    private static int foo(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int l = foo(treeNode.left);
        if (l == -1) {
            return -1;
        }
        int r = foo(treeNode.right);
        if (r == -1) {
            return -1;
        }
        return Math.abs(l - r) < 2 ? Math.max(l, r) + 1 : -1;
    }

    /**
     * 859. 亲密字符串
     * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到
     * 与 B 相等的结果，就返回 true ；否则返回 false 。
     *
     * @param A 字符串A
     * @param B 字符串B
     * @return 返回交换后是否相同
     */
    private static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] wordsA = A.toCharArray();
        char[] wordsB = B.toCharArray();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < wordsA.length; i++) {
            if (wordsA[i] != wordsB[i]) {
                data.add(i);
            }
        }
        if (data.size() == 2) {
            char temp = wordsA[data.get(0)];
            wordsA[data.get(0)] = wordsA[data.get(1)];
            wordsA[data.get(1)] = temp;
            return String.valueOf(wordsA).equals(String.valueOf(wordsB));
        } else if (data.size() == 0) {
            char[] count = new char[26];
            for (char c : wordsA) {
                count[c - 'a']++;
                if (count[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * 844. 比较含退格的字符串
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
     * 判断二者是否相等，并返回结果。 # 代表退格字符。
     *
     * @param S 字符串S
     * @param T 字符串T
     * @return 是否相等
     */
    private static boolean backspaceCompare(String S, String T) {
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if (temp == '#') {
                if (!stackA.isEmpty()) {
                    stackA.pop();
                }
            } else {
                stackA.add(temp);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char temp = T.charAt(i);
            if (temp == '#') {
                if (!stackB.isEmpty()) {
                    stackB.pop();
                }
            } else {
                stackB.add(temp);
            }
        }
        if (stackA.size() != stackB.size()) {
            return false;
        }
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            char a = stackA.pop();
            char b = stackB.pop();
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    /**
     * 844. 比较含退格的字符串
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
     * 判断二者是否相等，并返回结果。 # 代表退格字符。
     *
     * @param S 字符串S
     * @param T 字符串T
     * @return 是否相等
     */
    private static boolean backspaceCompare1(String S, String T) {
        char[] charA = S.toCharArray();
        char[] charB = T.toCharArray();
        int i1 = cleanStr(charA);
        int i2 = cleanStr(charB);
        if (i1 != i2) {
            return false;
        }
        for (int i = 0; i < i1; i++) {
            if (charA[i] != charB[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 清空对应#数据
     *
     * @param chars 数组
     * @return 返回格式化长度
     */
    private static int cleanStr(char[] chars) {
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (temp != '#') {
                chars[j] = temp;
                j++;
            } else {
                if (j != 0) {
                    j--;
                }
            }
        }
        return j;
    }

    /**
     * 1295. 统计位数为偶数的数字
     *
     * @param nums 整数数组
     * @return 位数偶数个数
     */
    private static int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int i = 0;
            while (num > 0) {
                num = num / 10;
                i++;
            }
            if (i % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 1290. 二进制链表转整数
     *
     * @param head 链表
     * @return 整数
     */
    private static int getDecimalValue(ListNode head) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        String temp = sb.reverse().toString();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') {
                ans += Math.pow(2, i);
            }
        }
        return ans;
    }
}


