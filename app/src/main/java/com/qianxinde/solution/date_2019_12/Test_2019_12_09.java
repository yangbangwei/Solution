package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :yangbw
 * @date :2019-12-06
 */
public class Test_2019_12_09 {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

        String[] words = {
                "Hello", "Alaska", "Dad", "Peace"
        };
        System.out.println(Arrays.toString(findWords(words)));
    }

    /**
     * 771. 宝石与石头
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     *  S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *
     * @param J 字符串j
     * @param S 字符串s
     * @return 返回宝石数量
     */
    private static int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (char s : S.toCharArray()) {
            for (char j : J.toCharArray()) {
                if (s == j) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 500. 键盘行
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词
     *
     * @param words 单词列表
     * @return 返回结果
     */
    private static String[] findWords(String[] words) {
        String[] lines = new String[]{
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };
        List<String> res = new ArrayList<>();
        for (String word : words) {
            for (String line : lines) {
                if (isContain(line, word.toLowerCase())) {
                    res.add(word);
                }
            }
        }
        return res.toArray(new String[0]);
    }

    /**
     * 是否包含
     *
     * @param line 键盘行
     * @param word 查询的单词
     * @return 是否可以完全包含
     */
    private static boolean isContain(String line, String word) {
        for (char c : word.toCharArray()) {
            if (line.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 412. Fizz Buzz
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * @param n n以内
     * @return 输出结果
     */
    private static List<String> fizzBuzz(int n) {
        String[] ans = new String[n];
        for (int i = 1; i <= n; i++) {
            ans[i - 1] = String.valueOf(i);
        }
        for (int i = 3; i <= n; i += 3) {
            ans[i - 1] = "Fizz";
        }
        for (int i = 5; i <= n; i += 5) {
            ans[i - 1] = "Buzz";
        }
        for (int i = 15; i <= n; i += 15) {
            ans[i - 1] = "FizzBuzz";
        }
        return Arrays.asList(ans);
    }

    /**
     * 804. 唯一摩尔斯密码词
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，
     *  比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
     * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab"
     * 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
     * 返回我们可以获得所有词不同单词翻译的数量。
     *
     * @param words 单词列表
     * @return 不同的单词数量
     */
    private static int uniqueMorseRepresentations(String[] words) {
        String[] key = {".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                sb.append(key[i]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    /**
     * 700. 二叉搜索树中的搜索
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
     * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     *
     * @param root 二叉树
     * @param val  值
     * @return 返回根节点
     */
    private static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
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
     * 832. 翻转图像
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     *
     * @param A 二进制矩阵
     * @return 水平翻转，翻转图片后的矩阵
     */
    private static int[][] flipAndInvertImage(int[][] A) {
        for (int[] ints : A) {
            int length = ints.length % 2 == 0 ? ints.length / 2 : ints.length / 2 + 1;
            for (int i = 0; i < length; i++) {
                int temp = ints[i];
                int j = ints.length - i - 1;
                ints[i] = ints[j] ^ 1;
                ints[j] = temp ^ 1;
            }
        }
        return A;
    }

}
