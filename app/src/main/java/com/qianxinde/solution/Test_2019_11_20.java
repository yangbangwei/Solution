package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-20
 */
public class Test_2019_11_20 {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    /**
     * 67. 二进制求和
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     *
     * @param a 字符串a
     * @param b 字符串b
     * @return 求和值
     */
    private static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int flag = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = flag;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            result.append(sum % 2);
            flag = sum / 2;
        }
        result.append(flag == 1 ? 1 : "");
        return result.reverse().toString();
    }
}
