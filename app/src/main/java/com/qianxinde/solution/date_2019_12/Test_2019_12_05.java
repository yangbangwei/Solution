package com.qianxinde.solution.date_2019_12;

import java.util.Stack;

/**
 * @author :yangbw
 * @date :2019-12-05
 */
public class Test_2019_12_05 {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

    /**
     * 1221. 分割平衡字符串
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * 返回可以通过分割得到的平衡字符串的最大数量。
     *
     * @param s 字符串
     * @return 返回切换最大数
     */
    private static int balancedStringSplit(String s) {
        char[] all = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : all) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char temp = stack.peek();
                if (c == 'L' && temp == 'R'
                        || (c == 'R' && temp == 'L')) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        count++;
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return count;
    }

    /**
     * 1221. 分割平衡字符串
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * 返回可以通过分割得到的平衡字符串的最大数量。
     *
     * @param s 字符串
     * @return 返回切换最大数
     */
    private static int balancedStringSplit1(String s) {
        char[] all = s.toCharArray();
        int count = 0;
        int res = 0;
        for (char c : all) {
            if (c == 'L') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res++;
            }
        }
        return res;
    }

}
