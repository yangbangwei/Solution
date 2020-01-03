package com.qianxinde.solution.date_2020_01;

/**
 * @author :yangbw
 * @date :2020_01_03
 */
public class Test_2020_01_03 {

    public static void main(String[] args) {

    }

    /**
     * 860. 柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，
     * 也就是说净交易是每位顾客向你支付 5 美元。
     * 注意，一开始你手头没有任何零钱。
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *
     * @param bills 账单
     * @return 是否正确找零
     */
    private boolean lemonadeChange(int[] bills) {
        int num5 = 0;
        int num10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                num5++;
            } else if (bill == 10) {
                if (num5 >= 1) {
                    num5--;
                    num10++;
                } else {
                    return false;
                }
            } else {
                if (num5 >= 1 && num10 >= 1) {
                    num5--;
                    num10--;
                } else if (num5 >= 3) {
                    num5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

