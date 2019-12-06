package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author :yangbw
 * @date :2019-12-06
 */
public class Test_2019_12_06 {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    private static TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }

        return t1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static HashMap<Integer, Employee> importances = new HashMap<>();

    /**
     * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
     *
     * @param employees 所有员工信息
     * @param id        要查询的员工ID
     * @return 返回所有重要度之和
     */
    private static int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            importances.put(employee.id, employee);
        }
        return dfs(id);
    }

    /**
     * 深度优先算法 DFS
     *
     * @param eid 待查询的ID
     * @return 返回累加值
     */
    private static int dfs(int eid) {
        Employee employee = importances.get(eid);
        int ans = employee.importance;
        for (Integer subid : employee.subordinates) {
            ans += dfs(subid);
        }
        return ans;
    }

    private static class Employee {
        private int id;
        private int importance;
        private List<Integer> subordinates;
    }

    /**
     * 728. 自除数
     * 自除数 是指可以被它包含的每一位数除尽的数。
     * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
     *
     * @param left  左边界
     * @param right 右边界
     * @return 返回所有自除数
     */
    private static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> nums = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isZero(i)) {
                nums.add(i);
            }
        }
        return nums;
    }

    /**
     * 判断是否符合条件
     *
     * @param n 当前这个数
     * @return 返回结果
     */
    private static boolean isZero(int n) {
        int m = n;
        while (n > 0) {
            int k = n % 10;
            if (k == 0 || m % k != 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }
}
