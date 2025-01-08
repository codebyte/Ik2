package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(int a[]) {
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            idx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[idx]) {
                    idx = j;
                }
            }
            swap(a, idx, i);
        }
    }

    public static void main(String args[]) {
        int a[] = {10, 4, 6, 78, 2, 67, 8};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
