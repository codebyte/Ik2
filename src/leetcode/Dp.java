package leetcode;

import java.util.Arrays;

public class Dp {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + (n - 2);
    }


    static int a[] = {0, 1, 2};

    public static void climbStairs(int n) {
        int i = 0;
        for (i = 3; i <= n; i++) {
            a[i % 3] = a[(i - 1) % 3] + a[(i - 2) % 3];
        }
        System.out.println(a[(i - 1) % 3]);
        System.out.println(Arrays.toString(a));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }

        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][i] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


    public static void main(String args[]) {
        climbStairs(4);
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(uniquePathsWithObstacles(grid));

    }
}
