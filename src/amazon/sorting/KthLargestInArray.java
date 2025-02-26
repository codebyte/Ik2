package amazon.sorting;

import java.util.Arrays;
import java.util.Random;

public class KthLargestInArray {

    private static Random rand = new Random();

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static int random(int start, int end) {
        return rand.nextInt(end - start + 1) + start;
    }


    public static int partition(int a[], int start, int end) {

        int par = random(start, end);
        swap(a, start, par);

        int left = start;
        int right = start + 1;
        for (; right <= end; right++) {
            if (a[right] < a[start]) {
                left++;
                swap(a, right, left);
            }
        }
        swap(a, left, start);

        return left;
    }


    public static void quickSort(int a[], int start, int end, int k) {
        if (start >= end) {
            return;
        }

        int pivot = partition(a, start, end);
        if (pivot == k) {
            return;
        }

        if (pivot > k) {
            quickSort(a, start, pivot - 1, k);
        } else {
            quickSort(a, pivot + 1, end, k);
        }
    }


    public static void main(String args[]) {
        int a[] = {-1, 2, 0};

        int k = 2;
        quickSort(a, 0, a.length - 1, a.length - k);
        System.out.println(a[a.length - k]);
    }
}
