package com.qianxinde.solution;

import java.util.Arrays;

/**
 * @author :yangbw
 * @date :2019-11-12
 */
public class Test_2019_11_13 {

    public static void main(String[] args) {
        game();
        uniqueOccurrences();
        System.out.println(isValid());
        System.out.println(removeElement());
    }

    /**
     * LCP 1. 猜数字
     * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3
     * 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
     *
     * @return
     */
    public static int game() {
        int[] guess = {1, 2, 3};
        int[] answer = {1, 2, 3};
        int num = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                num++;
            }
        }
        return num;
    }

    /**
     * 1207. 独一无二的出现次数
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     *
     * @return
     */
    public static boolean uniqueOccurrences() {
        int[] arr = {1, 2, 2, 3, 3, 3};
//        Map<Integer, Integer> counter = new HashMap<>();
//        for (int elem : arr) {
//            counter.put(elem, counter.getOrDefault(elem, 0) + 1);
//        }
//        return counter.size() == new HashSet<>(counter.values()).size();

        Arrays.sort(arr);
        if (arr.length <= 1) {
            return true;
        }
        int a[] = new int[arr.length];
        int nTime = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                nTime++;
            } else {
                if (a[nTime] == 1) {
                    return false;
                } else {
                    a[nTime] = 1;
                    nTime = 1;
                }
                if (i == arr.length - 2) {
                    if (a[1] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @return
     */
    public static boolean isValid() {
        String s = "{[]{}}";
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            String a = String.valueOf(s.charAt(i));
//            if (stack.empty()) {
//                stack.push(a);
//            } else {
//                String last = stack.peek();
//                if (last.equals("{")
//                        || a.equals("(")
//                        || a.equals("[")) {
//                    stack.push(a);
//                } else {
//                    if ((last.equals("{") && a.equals("}"))
//                            || (last.equals("[") && a.equals("]"))
//                            || (last.equals("(") && a.equals(")"))) {
//                        stack.push(a);
//                    }else {
//                        stack.pop();
//                    }
//                }
//            }
//        }
//        return stack.empty();

        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        int stackIndex = 0;
        char[] data = s.toCharArray();
        char[] stack = new char[data.length];
        stack[0] = '0';

        for (int i = 0; i < data.length; i++) {
            if (data[i] == '[' || data[i] == '{' || data[i] == '(') {
                stack[stackIndex++] = data[i];
            } else if (stackIndex == 0
                    || data[i] == ']' && stack[stackIndex - 1] != '['
                    || data[i] == '}' && stack[stackIndex - 1] != '{'
                    || data[i] == ')' && stack[stackIndex - 1] != '(') {
                return false;
            } else {
                stack[--stackIndex] = '0';
            }
        }
        return stackIndex == 0;
    }

    /**
     * 27. 移除元素
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @return
     */
    public static int removeElement() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int index = 0;
        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i] != val){
                int temp =
                nums[index] =  nums[i];
                index++;
            }
        }
        return index;
    }
}
