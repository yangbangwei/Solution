package com.qianxinde.solution.date_2020_01;

import androidx.annotation.NonNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author :yangbw
 * @date :2020_01_07
 */
public class Test_2020_01_07 {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a' , 'b' , 'b' , 'c' , 'c' , 'c' }));

        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express",
                "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));

        System.out.println(dominantIndex(new int[]{0, 0, 0, 1}));

        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"}));
    }

    /**
     * 443. 压缩字符串
     * 给定一组字符，使用原地算法将其压缩。
     * 压缩后的长度必须始终小于或等于原数组长度。
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     * 在完成原地修改输入数组后，返回数组的新长度。
     *
     * @param chars 字符串
     * @return 压缩后长度
     */
    private static int compress(@NonNull char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read == chars.length - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    /**
     * 599. 两个列表的最小索引总和
     * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
     * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。
     * 你可以假设总是存在一个答案。
     *
     * @param list1 数组1
     * @param list2 数组2
     * @return 相同的相加最小的索引和
     */
    @SuppressWarnings("ConstantConditions")
    private static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i], i);
        }
        List<String> data = new ArrayList<>();
        int min = 2000;
        for (int i = 0; i < list2.length; i++) {
            if (hashMap.containsKey(list2[i])) {
                int value = hashMap.get(list2[i]) + i;
                if (value < min) {
                    min = value;
                    data.clear();
                    data.add(list2[i]);
                } else if (value == min) {
                    data.add(list2[i]);
                }
            }
        }
        return data.toArray(new String[]{});
    }

    /**
     * 665. 非递减数列
     * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
     *
     * @param nums 数组
     * @return 是否为非递减数列
     */
    private boolean checkPossibility(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                num++;
                if (num > 1) {
                    return false;
                }
                if (i >= 1 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

    /**
     * 747. 至少是其他数字两倍的最大数
     * 在一个给定的数组nums中，总是存在一个最大元素 。
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     * 如果是，则返回最大元素的索引，否则返回-1。
     *
     * @param nums 数组
     * @return 最大元素索引
     */
    private static int dominantIndex(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != max && nums[i] * 2 > nums[max]) {
                return -1;
            }
        }
        return max;
    }

    /**
     * 929. 独特的电子邮件地址
     * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
     * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
     * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
     * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），
     * 则发往那里的邮件将会转发到本地名称中没有点的同一地址。
     * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
     * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。
     * 这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
     * 可以同时使用这两个规则。
     * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
     *
     * @param emails 邮件地址
     * @return 不同的地址数
     */
    private static int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();
        for (String email : emails) {
            String[] words = email.split("@");
            String s = words[0].replace(".", "");
            if (s.contains("+")) {
                s = s.substring(0, s.indexOf("+"));
            }
            hashSet.add(s.concat("@").concat(words[1]));
        }
        return hashSet.size();
    }

    /**
     * 933. 最近的请求次数
     * 写一个 RecentCounter 类来计算最近的请求。
     * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
     * 返回从 3000 毫秒前到现在的 ping 数。
     * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
     * 保证每次对 ping 的调用都使用比之前更大的 t 值。
     */
    class RecentCounter {

        private Queue<Integer> mQueue;

        public RecentCounter() {
            mQueue = new ArrayDeque<>();
        }

        public int ping(int t) {
            mQueue.offer(t);
            while (!mQueue.isEmpty() && t - mQueue.peek() > 3000) {
                mQueue.poll();
            }
            return mQueue.size();
        }
    }

    /**
     * 703. 数据流中的第K大元素
     * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
     * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
     * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
     */
    class KthLargest {

        private PriorityQueue<Integer> mPriorityQueue;
        private int mK;

        public KthLargest(int k, int[] nums) {
            mK = k;
            mPriorityQueue = new PriorityQueue<>();
            for (int num : nums) {
                if (mPriorityQueue.size() < k) {
                    mPriorityQueue.add(num);
                } else {
                    if (num > mPriorityQueue.peek()) {
                        mPriorityQueue.poll();
                        mPriorityQueue.add(num);
                    }
                }
            }
        }

        public int add(int val) {
            if (mPriorityQueue.size() < mK || val > mPriorityQueue.peek()) {
                if (mPriorityQueue.size() == mK) {
                    mPriorityQueue.poll();
                }
                mPriorityQueue.add(val);
            }
            return mPriorityQueue.peek();
        }
    }
}
