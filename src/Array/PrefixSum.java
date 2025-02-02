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

    public static int rangeSumQuery(int num[], int range[]) {

        int[] prefixSum = new int[num.length];


        for (int i = 0; i < num.length; i++) {
            prefixSum[i] += num[i];
        }

        int start = range[0];
        int end = range[1];

        int sum = prefixSum[end] - prefixSum[start - 1];

        return sum;
    }

    public static int subArraySum(int num[], int k) {

        int preSum = 0;
        int sIndex = 0;
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            preSum += num[i];
            if (preSum == k) {
                count++;
                preSum -= num[sIndex];
                sIndex++;
            }
            if (preSum > k) {
                preSum -= num[sIndex];
                sIndex++;
            }
        }
        return count;
    }


    public static void main(String args[]) {
        int a[] = {1, 2, 3};

        //runningSum(a);
        System.out.println(Arrays.toString(a));
        //System.out.println(rangeSumQuery(a, new int[]{2, 5}));
        System.out.println(subArraySum(a, 3));
    }
}
