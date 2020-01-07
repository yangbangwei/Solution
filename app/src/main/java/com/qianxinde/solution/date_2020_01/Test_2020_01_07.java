package com.qianxinde.solution.date_2020_01;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author :yangbw
 * @date :2020_01_07
 */
public class Test_2020_01_07 {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a' , 'b' , 'b' , 'c' , 'c' , 'c' }));

        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express",
                "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));
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
}

