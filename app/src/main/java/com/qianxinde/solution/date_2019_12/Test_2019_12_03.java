package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :yangbw
 * @date :2019-12-03
 */
public class Test_2019_12_03 {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));

        int[] nums = {3, 2, 2, 2, 2, 1};
        System.out.println(thirdMax(nums));

        System.out.println(arrangeCoins(8));

        System.out.println(addStrings("1", "1"));
    }

    /**
     * 463. 岛屿的周长
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
     * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     *
     * @param grid 岛屿
     * @return 返回周长
     */
    private static int islandPerimeter(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] line = grid[i];
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 1) {
                    if (j == 0 || line[j - 1] == 0) {
                        total += 2;
                    }
                    if (i == 0 || grid[i - 1][j] == 0) {
                        total += 2;
                    }
                }
            }
        }
        return total;
    }

    /**
     * 589. N叉树的前序遍历
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * 方法1，递归调用
     *
     * @param root 树
     * @return 返回遍历结果
     */
    private static List<Integer> preorder(Node root) {
        List<Integer> data = new ArrayList<>();
        if (root == null) {
            return data;
        }
        data.add(root.val);
        for (Node child : root.children) {
            data.addAll(preorder(child));
        }
        return data;
    }

    /**
     * 589. N叉树的前序遍历
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * 方法2，迭代法
     *
     * @param root 树
     * @return 返回遍历结果
     */
    private static List<Integer> preorder1(Node root) {
        List<Integer> data = new ArrayList<>();
        if (root == null) {
            return data;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            data.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return data;
    }

    /**
     * 590. N叉树的后序遍历
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     *
     * @param root N叉树
     * @return 返回遍历的结果
     */
    private static List<Integer> postorder(Node root) {
        List<Integer> data = new ArrayList<>();
        if (root == null) {
            return data;
        }
        for (Node child : root.children) {
            data.addAll(preorder(child));
        }
        data.add(root.val);
        return data;
    }

    private static class Node {
        private int val;
        private List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 414. 第三大的数
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。
     * 要求算法时间复杂度必须是O(n)。
     *
     * @param nums 数组
     * @return 第三大的数
     */
    private static int thirdMax(int[] nums) {
        long[] max = new long[3];
        max[0] = Long.MIN_VALUE;
        max[1] = Long.MIN_VALUE;
        max[2] = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (max[0] > num && num > max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (max[1] > num && num > max[2]) {
                max[2] = num;
            }
        }
        return (int) ((max[2] == Long.MIN_VALUE) ? max[0] : max[2]);
    }

    /**
     * 441. 排列硬币
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     *
     * @param n 硬币数
     * @return 行数
     */
    private static int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + n * 8L) - 1) / 2);
    }

    private static String addStrings(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int temp = 0;
        for (int i = char1.length - 1, j = char2.length - 1; i >= 0 || j >= 0; i--, j--) {
            int a = 0;
            if (i >= 0) {
                a = char1[i] - '0';
            }
            int b = 0;
            if (j >= 0) {
                b = char2[j] - '0';
            }
            temp = a + b + temp;
            stringBuilder.append(temp % 10);
            temp /= 10;
        }
        if (temp == 1) {
            stringBuilder.append(temp);
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * 557. 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * @param s 单词
     * @return 反转的单词
     */
    private static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(new StringBuilder(word).reverse().toString())
                    .append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
