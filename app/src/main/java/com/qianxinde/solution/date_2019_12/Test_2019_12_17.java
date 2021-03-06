package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-17
 */
public class Test_2019_12_17 {

    public static void main(String[] args) {
        System.out.println(maximumProduct1(new int[]{1, 2, 3, 4}));

        System.out.println(judgeSquareSum(4));

        System.out.println(rotatedDigits(857));

        System.out.println(mostCommonWord("Bob",
                new String[]{"hit"}));

        System.out.println(reverseOnlyLetters("ab-cd"));
    }

    /**
     * 653. 两数之和 IV - 输入 BST
     * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true
     *
     * @param root 二叉树
     * @param k    目标结果
     * @return 是否包含目标结果
     */
    private static boolean findTarget(TreeNode root, int k) {
        List<Integer> data = new ArrayList<>();
        addTreeNode(data, root);
        int left = 0;
        int right = data.size() - 1;
        while (left < right) {
            if (data.get(left) + data.get(right) == k) {
                return true;
            } else if (data.get(left) + data.get(right) > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    /**
     * 添加数组到list
     *
     * @param data 储存数据
     * @param root 二叉树
     */
    private static void addTreeNode(List<Integer> data, TreeNode root) {
        if (root == null) {
            return;
        }
        data.add(root.val);
        addTreeNode(data, root.left);
        addTreeNode(data, root.right);
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
     * 628. 三个数的最大乘积
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     *
     * @param nums 整数数组
     * @return 3个数最大乘积
     */
    private static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    /**
     * 628. 三个数的最大乘积
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     *
     * @param nums 整数数组
     * @return 3个数最大乘积
     */
    private static int maximumProduct1(int[] nums) {
        int m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE, m3 = Integer.MIN_VALUE;
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m3 = m2;
                m2 = num;
            } else if (num > m3) {
                m3 = num;
            }
            if (n1 > num) {
                n2 = n1;
                n1 = num;
            } else if (n2 > num) {
                n2 = num;
            }
        }

        return Math.max(m1 * m2 * m3, m1 * n1 * n2);
    }

    /**
     * 633. 平方数之和
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     * 方法1，开平方
     *
     * @param c 非负整数
     * @return 是否有两个整数的平方和为c
     */
    private static boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            double temp = Math.sqrt(c - i * i);
            if (temp == (int) temp) {
                return true;
            }
        }
        return false;
    }

    /**
     * 633. 平方数之和
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     * 方法2，双指针
     *
     * @param c 非负整数
     * @return 是否有两个整数的平方和为c
     */
    private static boolean judgeSquareSum1(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left < right) {
            int num = left * left + right * right;
            if (num == c) {
                return true;
            } else if (num < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    /**
     * 633. 平方数之和
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     * 方法3，费马平方和
     *
     * @param c 非负整数
     * @return 是否有两个整数的平方和为c
     */
    private static boolean judgeSquareSum2(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0) {
                    return false;
                }
            }

        }
        return c % 4 != 3;
    }

    /**
     * 961. 重复 N 次的元素
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     *
     * @param A 数组A
     * @return 重复的那个元素
     */
    private static int repeatedNTimes(int[] A) {
        int[] nums = new int[10001];
        for (int i : A) {
            nums[i]++;
            if (nums[i] > 1) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 788. 旋转数字
     * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
     * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
     * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。
     * 0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，
     * 除了这些以外其他的数字旋转以后都不再是有效的数字。
     * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
     *
     * @param N 整数
     * @return 判断有多个好数
     */
    private static int rotatedDigits(int N) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            String s = String.valueOf(i);
            boolean isNotIn = false;
            boolean isAdd = true;
            for (char c : s.toCharArray()) {
                if (c == '3' || c == '4' || c == '7') {
                    isAdd = false;
                    break;
                }
                if (c == '2' || c == '5' || c == '6' || c == '9') {
                    isNotIn = true;
                }
            }
            if (isAdd && isNotIn) {
                total++;
            }
        }
        return total;
    }

    /**
     * 819. 最常见的单词
     * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，
     * 同时不在禁用列表中的单词。题目保证至少有一个词不在禁用列表中，而且答案唯一。
     *
     * @param paragraph 段落
     * @param banned    禁用单词列表
     * @return 返回常见单词
     */
    private static String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        HashMap<String, String> bannedMap = new HashMap<>();
        for (String s : banned) {
            bannedMap.put(s, s);
        }
        int max = 0;
        String key = "";
        HashMap<String, Integer> numMap = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!bannedMap.containsKey(finalword)) {
                    int num = 1;
                    if (numMap.containsKey(finalword)) {
                        num = numMap.get(finalword);
                        numMap.put(finalword, ++num);
                    } else {
                        numMap.put(finalword, num);
                    }
                    if (max < num) {
                        max = num;
                        key = finalword;
                    }
                }
                word = new StringBuilder();
            }
        }
        return key;
    }

    /**
     * 917. 仅仅反转字母
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     *
     * @param S 字符串
     * @return 仅反转字母后的字符串
     */
    private static String reverseOnlyLetters(String S) {
        int left = 0;
        int right = S.length() - 1;
        char[] words = S.toCharArray();
        while (left < right) {
            if (!Character.isLetter(words[left])) {
                left++;
            } else if (!Character.isLetter(words[right])) {
                right--;
            } else {
                char temp = words[right];
                words[right] = words[left];
                words[left] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(words);
    }
}
