package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-10
 */
public class Test_2019_12_10 {

    public static void main(String[] args) {

    }

    /**
     * 999. 车的可用捕获量
     * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），
     * 然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
     * 另外，车不能与其他友方（白色）象进入同一个方格。
     * 返回车能够在一次移动中捕获到的卒的数量。
     *
     * @param board 象棋坐标
     * @return 捕获卒的个数
     */
    private static int numRookCaptures(char[][] board) {
        int ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        for (int i = x; i >= 0; i--) {
            if (board[i][y] == 'p') {
                ans++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = x; i < 8; i++) {
            if (board[i][y] == 'p') {
                ans++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = y; i >= 0; i--) {
            if (board[x][i] == 'p') {
                ans++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        for (int i = y; i < 8; i++) {
            if (board[x][i] == 'p') {
                ans++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        return ans;
    }
}
