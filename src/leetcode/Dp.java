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
        System.out.println(a[(i-1)%3]);
        System.out.println(Arrays.toString(a));
    }


    public static void main(String args[]) {
        climbStairs(4);

    }
}
