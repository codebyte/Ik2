package Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int val = a[i];
            int j = i;
            for (; (j > 0) && (val < a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = val;
        }
    }


    public static void main(String args[]) {
        int a[] = {23, 5, 7, 89, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
