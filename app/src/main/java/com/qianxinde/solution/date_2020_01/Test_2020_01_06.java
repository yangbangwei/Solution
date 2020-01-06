package com.qianxinde.solution.date_2020_01;

/**
 * @author :yangbw
 * @date :2020_01_03
 */
public class Test_2020_01_06 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog", "doracecar", "car"}));

        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

        System.out.println(isSubsequence("abc", "ahbgdc"));

        System.out.println(isHappy(19));

        System.out.println(toHex(26));
    }

    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs 字符串数组
     * @return 公共前缀
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param prices 股票价格
     * @return 最大利润
     */
    private int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    /**
     * 190. 颠倒二进制位
     * 颠倒给定的 32 位无符号整数的二进制位。
     *
     * @param n 32位无符号整数
     * @return 颠倒后的数
     */
    private static int reverseBits(int n) {
        int ans = 0;
        int count = 0;
        while (count < 32) {
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
            count++;
        }
        return ans;
    }

    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * @param nums 整数数组
     * @return 最高金额
     */
    private static int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + num, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * @param s 字符串
     * @param t 字符串
     * @return s是否为t的子序列
     */
    private static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char aChar : s.toCharArray()) {
            index = t.indexOf(aChar, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 202. 快乐数
     * 编写一个算法来判断一个数是不是“快乐数”。
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
     *
     * @param n 整数
     * @return 判断是否为快乐数
     */
    private static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    /**
     * 各位平方相加
     *
     * @param n 整数
     * @return 相加结果
     */
    private static int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    /**
     * 405. 数字转换为十六进制数
     * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
     * 注意:
     * 十六进制中所有字母(a-f)都必须是小写。
     * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，
     * 十六进制字符串中的第一个字符将不会是0字符。 
     * 给定的数确保在32位有符号整数范围内。
     * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
     *
     * @param num 整数
     * @return 转成16进制
     */
    private static String toHex(int num) {
        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(hex[num & 15]);
            num >>>= 4;
        }
        return sb.toString().isEmpty() ? "0" : sb.reverse().toString();
    }
}

