package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

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

        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));

        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
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

    /**
     * 824. 山羊拉丁文
     * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
     * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
     * <p>
     * 山羊拉丁文的规则如下：
     * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
     * 例如，单词"apple"变为"applema"。
     * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 例如，单词"goat"变为"oatgma"。
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
     * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
     *
     * @param S 单词句子
     * @return 山羊拉丁文
     */
    private static String toGoatLatin(String S) {
        String[] wrods = S.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wrods.length; i++) {
            String wrod = wrods[i];
            if (!wrod.startsWith("a")
                    && !wrod.startsWith("e")
                    && !wrod.startsWith("i")
                    && !wrod.startsWith("o")
                    && !wrod.startsWith("u")
                    && !wrod.startsWith("A")
                    && !wrod.startsWith("E")
                    && !wrod.startsWith("I")
                    && !wrod.startsWith("O")
                    && !wrod.startsWith("U")) {
                wrod = wrod.substring(1) + wrod.substring(0, 1);
            }
            wrod += "ma";
            StringBuilder sb = new StringBuilder(wrod);
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            stringBuilder.append(sb.toString()).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 682. 棒球比赛
     * 你现在是棒球比赛记录员。
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     *
     * @param ops 比赛记录
     * @return 得分
     */
    private static int calPoints(String[] ops) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int a = stack.peek();
                    int b = stack.get(stack.size() - 2);
                    int c = a + b;
                    ans += c;
                    stack.push(c);
                    break;
                case "C":
                    ans -= stack.pop();
                    break;
                case "D":
                    int d = stack.peek() * 2;
                    stack.push(d);
                    ans += d;
                    break;
                default:
                    int num = Integer.valueOf(op);
                    ans += num;
                    stack.push(num);
                    break;
            }
        }
        return ans;
    }

    /**
     * 657. 机器人能否返回原点
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，
     * 判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。
     * 机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人
     *
     * @param moves 移动顺序
     * @return 是否返回原点
     */
    private static boolean judgeCircle(String moves) {
        int[] nums = new int[26];
        for (char c : moves.toCharArray()) {
            nums[c - 'A']++;
        }
        return nums['L' - 'A'] == nums['R' - 'A'] && nums['U' - 'A'] == nums['D' - 'A'];
    }
}
