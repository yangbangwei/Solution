package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-27
 */
public class Test_2019_12_27 {

    public static void main(String[] args) {
        System.out.println(isLongPressedName("saeed", "ssaaeedde"));

        System.out.println(removeOuterParentheses("(()())(())"));

        System.out.println(tribonacci(25));
    }

    /**
     * 925. 长按键入
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     *
     * @param name  名字
     * @param typed 键盘输入后的字符
     * @return 是否正确
     */
    private static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        while (i < names.length && j < typeds.length) {
            if (names[i] == typeds[j]) {
                i++;
                j++;
            } else {
                if (j > 0 && typeds[j - 1] == typeds[j]) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        return i == names.length;
    }

    /**
     * 1021. 删除最外层的括号
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     *
     * @param S 字符串
     * @return 化解后的结果
     */
    private static String removeOuterParentheses(String S) {
        int stack = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack++;
                if (stack > 1) {
                    sb.append(c);
                }
            } else {
                stack--;
                if (stack > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 1137. 第 N 个泰波那契数
     * 泰波那契序列 Tn 定义如下： 
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     *
     * @param n 整数
     * @return Tn的值
     */
    private static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
        return nums[n];
    }
}


