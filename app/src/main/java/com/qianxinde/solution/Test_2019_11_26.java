package com.qianxinde.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-11-26
 */
public class Test_2019_11_26 {

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    /**
     * 119. 杨辉三角 II
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *
     * @param rowIndex 第几行
     * @return 返回结果
     */
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> data = new ArrayList<>();
        long nk = 1;
        for (int i = 0; i <= rowIndex; i++) {
            data.add((int) nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return data;
    }
}
