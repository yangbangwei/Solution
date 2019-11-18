package com.qianxinde.solution;

/**
 * @author :yangbw
 * @date :2019-11-18
 */
public class Test_2019_11_18 {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 38. 报数
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     * 注意：整数顺序将表示为一个字符串。
     *
     * @param n 报数
     * @return 返回转换后的字符串
     */
    private static String countAndSay(int n) {
        StringBuffer result = new StringBuffer();
        if (1 <= n && n <= 30) {
            //n=1
            if (n == 1) {
                return result.append("1").toString();
            }
            //n=2
            result.append("11");
            int num = 1;
            for (int i = 2; i < n; i++) {
                char[] s = result.toString().toCharArray();
                result = new StringBuffer();
                for (int j = 0; j < s.length; j++) {
                    if (j != s.length - 1 && s[j] == s[j + 1]) {
                        num++;
                    } else {
                        result.append(num).append(s[j]);
                        num = 1;
                    }
                }
            }
        }
        return result.toString();
    }

    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums 整数数组
     * @return 返回最大序和
     */
    private static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int total = 0;
        for (int num : nums) {
            if (total > 0) {
                total += num;
            } else {
                total = num;
            }
            ans = Math.max(ans, total);
        }

        return ans;
    }
}
