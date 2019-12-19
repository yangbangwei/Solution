package com.qianxinde.solution.date_2019_12;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-12-19
 */
public class Test_2019_12_19 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0, 2})));
    }

    /**
     * 905. 按奇偶排序数组
     * 给定一个非负整数数组 A，返回一个数组，在该数组中，
     * A 的所有偶数元素之后跟着所有奇数元素。
     * 你可以返回满足此条件的任何数组作为答案。
     *
     * @param A 数组
     * @return 是否满足条件
     */
    private static int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            while (A[left] % 2 == 0 && left < right) {
                left++;
            }
            while (A[right] % 2 != 0 && left < right) {
                right--;
            }
            int temp = A[right];
            A[right] = A[left];
            A[left] = temp;
            left++;
            right--;
        }
        return A;
    }


    /**
     * 1047. 删除字符串中的所有相邻重复项
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * 方法1，截取方式
     *
     * @param S 字符串s
     * @return 去重后字符串
     */
    private static String removeDuplicates(String S) {
        if (S.length() == 1) {
            return S;
        }
        char[] s = S.toCharArray();
        int i = 1;
        while (i < s.length) {
            if (s[i] == s[i - 1]) {
                S = String.valueOf(s);
                s = (S.substring(0, i - 1) + S.substring(i + 1, s.length)).toCharArray();
                i = 1;
            } else {
                i++;
            }
        }
        return String.valueOf(s);
    }

    /**
     * 1047. 删除字符串中的所有相邻重复项
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * 方法2，通过栈的方式
     *
     * @param S 字符串s
     * @return 去重后字符串
     */
    private static String removeDuplicates1(String S) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : S.toCharArray()) {
            if (i != 0 && c == sb.charAt(i - 1)) {
                sb.deleteCharAt(i-- - 1);
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    /**
     * 1108. IP 地址无效化
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     *
     * @param address ip地址
     * @return 无效化的ip地址
     */
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
