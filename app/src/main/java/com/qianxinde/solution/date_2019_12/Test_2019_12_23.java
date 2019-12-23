package com.qianxinde.solution.date_2019_12;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author :yangbw
 * @date :2019-12-23
 */
public class Test_2019_12_23 {

    public static void main(String[] args) {

    }

    /**
     * 884. 两句话中的不常见单词
     * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
     * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
     * 返回所有不常用单词的列表。
     * 您可以按任何顺序返回列表。
     *
     * @param A 字符串A
     * @param B 字符串B
     * @return 不常用的单词
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String c : A.split(" ")) {
            int time = hashMap.getOrDefault(c, 0);
            hashMap.put(c, ++time);
        }
        for (String c : B.split(" ")) {
            int time = hashMap.getOrDefault(c, 0);
            hashMap.put(c, ++time);
        }
        List<String> data = new ArrayList<>();
        for (String s : hashMap.keySet()) {
            if (hashMap.get(s) == 1) {
                data.add(s);
            }
        }
        return data.toArray(new String[0]);
    }
}
