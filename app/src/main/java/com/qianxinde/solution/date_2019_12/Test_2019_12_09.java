package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
