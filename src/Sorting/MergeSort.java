package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int a[], int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);

        int i = start;
        int j = mid + 1;

        int k = 0;
        int aux[] = new int[end - start + 1];

        while ((i <= mid) && (j <= end)) {
            if (a[i] <= a[j]) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }

        while (i <= mid) {
            aux[k++] = a[i++];
        }

        while (j <= end) {
            aux[k++] = a[j++];
        }

        for (k = 0, i = start; (k < aux.length) && (i <= end); k++, i++) {
            a[i] = aux[k];
        }
    }

    public static void main(String args[]) {

        int a[] = {213, 5, 67, 68, 8, 9, 2, 4};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));


    }
}