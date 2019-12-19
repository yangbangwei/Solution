package com.qianxinde.solution.date_2019_12;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-12-19
 */
public class Test_2019_12_19 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0, 2})));

        System.out.println(Arrays.toString(duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0})));

        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
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

    /**
     * 1089. 复写零
     * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
     * 注意：请不要在超过该数组长度的位置写入元素。
     * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
     *
     * @param arr 整数数组
     */
    private static int[] duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                System.arraycopy(arr, i + 1, arr, i + 2, arr.length - i - 2);
                arr[i + 1] = 0;
                i++;
            }
        }
        return arr;
    }

    /**
     * 1046. 最后一块石头的重量
     * 有一堆石头，每块石头的重量都是正整数。
     * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。
     * 那么粉碎的可能结果如下：
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     *
     * @param stones 数组
     * @return 最后剩下的石头
     */
    private static int lastStoneWeight(int[] stones) {
        int length = stones.length;
        if (length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        int temp = stones[length - 1] - stones[length - 2];
        int[] newStones;
        if (temp == 0) {
            if (length == 2) {
                return 0;
            }
            newStones = new int[length - 2];
            System.arraycopy(stones, 0, newStones, 0, length - 2);
        } else {
            stones[length - 2] = temp;
            newStones = new int[length - 1];
            System.arraycopy(stones, 0, newStones, 0, length - 1);
        }
        return lastStoneWeight(newStones);
    }

    /**
     * 1160. 拼写单词
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），
     * 那么我们就认为你掌握了这个单词。
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     * 返回词汇表 words 中你掌握的所有单词的 长度之和
     *
     * @param words 词汇表
     * @param chars 字母表
     * @return 掌握单词长度
     */
    private static int countCharacters(String[] words, String chars) {
        int[] bucket = new int[26];
        for (char c : chars.toCharArray()) {
            bucket[c - 'a']++;
        }
        int ans = 0;
        for (String word : words) {
            int[] temp = new int[26];
            System.arraycopy(bucket, 0, temp, 0, temp.length);
            boolean isAdd = true;
            for (char c : word.toCharArray()) {
                if (temp[c - 'a'] > 0) {
                    temp[c - 'a']--;
                } else {
                    isAdd = false;
                }
            }
            if (isAdd) {
                ans += word.length();
            }
        }
        return ans;
    }
}
