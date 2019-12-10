package com.qianxinde.solution.date_2019_12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-10
 */
public class Test_2019_12_10 {

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb",
                "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"}));

        System.out.println(detectCapitalUse("mL"));
    }

    /**
     * 999. 车的可用捕获量
     * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），
     * 然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
     * 另外，车不能与其他友方（白色）象进入同一个方格。
     * 返回车能够在一次移动中捕获到的卒的数量。
     *
     * @param board 象棋坐标
     * @return 捕获卒的个数
     */
    private static int numRookCaptures(char[][] board) {
        int ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        for (int i = x; i >= 0; i--) {
            if (board[i][y] == 'p') {
                ans++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = x; i < 8; i++) {
            if (board[i][y] == 'p') {
                ans++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = y; i >= 0; i--) {
            if (board[x][i] == 'p') {
                ans++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        for (int i = y; i < 8; i++) {
            if (board[x][i] == 'p') {
                ans++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        return ans;
    }

    /**
     * 1002. 查找常用字符
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符
     * （包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，
     * 则需要在最终答案中包含该字符 3 次。
     * 你可以按任意顺序返回答案。
     *
     * @param A 字符串数组
     * @return 重复出现的字符
     */
    private static List<String> commonChars(String[] A) {
        int[][] nums = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                nums[i][c - 'a']++;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                min = Math.min(min, nums[i][j]);
            }
            for (int i = 0; i < min; i++) {
                ans.add(String.valueOf((char) (j + 'a')));
            }
        }
        return ans;
    }

    /**
     * 520. 检测大写字母
     * 给定一个单词，你需要判断单词的大写使用是否正确。
     * 我们定义，在以下情况时，单词的大写用法是正确的：
     * 全部字母都是大写，比如"USA"。
     * 单词中所有字母都不是大写，比如"leetcode"。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     * 否则，我们定义这个单词没有正确使用大写字母。
     *
     * @param word 单词
     * @return 是否大写正确
     */
    private static boolean detectCapitalUse(String word) {
        int num = 0;
        char first = word.charAt(0);
        word = word.substring(1);
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                num++;
            }
        }
        int length = word.length();
        if (first >= 'a' && first <= 'z') {
            return num == length;
        } else {
            return num == length || num == 0;
        }
    }
}
