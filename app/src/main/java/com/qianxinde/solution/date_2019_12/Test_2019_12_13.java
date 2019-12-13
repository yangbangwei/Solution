package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-11
 */
public class Test_2019_12_13 {

    public static void main(String[] args) {


    }

    /**
     * 299. 猜数字游戏
     * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
     * 每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
     * 有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     *
     * @param secret 数字
     * @param guess  要猜的数字
     * @return 返回结果
     */
    private static String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] bucket = new int[10];
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                bulls++;
                continue;
            }
            bucket[s[i] - '0']++;
            bucket[g[i] - '0']--;
        }
        for (int i : bucket) {
            if (i > 0) {
                cows += i;
            }
        }
        cows = s.length - cows - bulls;
        return bulls + "A" + cows + "B";
    }
}
