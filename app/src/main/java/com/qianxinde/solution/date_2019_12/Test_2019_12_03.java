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

        int[] nums = {3, 2, 2, 2, 2,1};
        System.out.println(thirdMax(nums));
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
}
