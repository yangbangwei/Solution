package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-02
 */
public class Test_2019_12_02 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray1 obj = new NumArray1(nums);
        int param = obj.sumRange(0, 2);
        System.out.println(param);
    }

    public static class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int total = 0;
            for (int k = i; k <= j; k++) {
                total += nums[k];
            }
            return total;
        }
    }

    private static class NumArray1 {

        private int[] sum;

        private NumArray1(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        private int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    /**
     * 389. 找不同
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 添加的字母
     */
    private static char findTheDifference(String s, String t) {
        char[] oldChar = s.toCharArray();
        char[] newChar = t.toCharArray();
        int[] nums = new int[26];
        for (char c : oldChar) {
            nums[c - 'a']++;
        }
        for (char c : newChar) {
            if (nums[c - 'a'] == 0) {
                return c;
            }
            nums[c - 'a']--;
        }

        return ' ';
    }
}
