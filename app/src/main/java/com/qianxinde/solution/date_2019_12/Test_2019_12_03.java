package com.qianxinde.solution.date_2019_12;

/**
 * @author :yangbw
 * @date :2019-12-03
 */
public class Test_2019_12_03 {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }

    private static int islandPerimeter(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] line = grid[i];
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 1) {
                    if (j == 0 || line[j - 1] == 0) {
                        total += 2;
                    }
                    if (i == 0 || grid[i - 1][j] == 0) {
                        total += 2;
                    }
                }
            }
        }
        return total;
    }
}
