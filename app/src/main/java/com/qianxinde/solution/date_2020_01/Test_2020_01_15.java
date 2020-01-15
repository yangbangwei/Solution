package com.qianxinde.solution.date_2020_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :yangbw
 * @date :2020_01_10
 */
public class Test_2020_01_15 {

    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2, 3, 10));
    }

    /**
     * 970. 强整数
     * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，
     * 其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
     * 返回值小于或等于 bound 的所有强整数组成的列表。
     * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
     *
     * @param x     正整数
     * @param y     正整数
     * @param bound 边界
     * @return 强整数列表
     */
    private static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        //以2，3，10为例题。
        //a的值为1,2,4,8，b的值为1，3，9。实则为x，y符合条件的平方数。省略每次中间多余运算部分。
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
                //为了y的多次平方都为1的情况。
                if (y == 1) {
                    break;
                }
            }
            //为了x的多次平方都为1的情况。
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }
}
