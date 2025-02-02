package Array;

import java.util.Arrays;

public class PrefixSum {

    public static void runningSum(int num[]) {
        int prefixSum = 0;

        for (int i = 0; i < num.length; i++) {
            prefixSum += num[i];
            num[i] = prefixSum;
        }
    }


    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5};

        runningSum(a);
        System.out.println(Arrays.toString(a));

    }
}
