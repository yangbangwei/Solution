package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-11
 */
public class Test_2019_12_16 {

    public static void main(String[] args) {

    }

    /**
     * 704. 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     * @param nums   数组
     * @param target 目标值
     * @return 下标
     */
    private static int search(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;
        while (low < hight) {
            int mid = (hight - low) + low;
            if (nums[mid] == target) {
                return target;
            } else if (nums[mid] > target) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
