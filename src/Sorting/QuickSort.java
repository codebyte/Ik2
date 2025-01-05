package Sorting;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static int randomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start) + start;
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int a[], int start, int end) {
        int seedPivot = randomNumber(start, end);
        swap(a, start, seedPivot);
        int left = start;
        for(int right = start + 1; right <= end; right++) {
            if(a[right] < a[start]) {
                left++;
                swap(a, left, right);
            }
        }
        swap(a, start, left);
        return left;
    }

    public static void quickSort(int a[], int start, int end) {
        if(start >= end) {
            return;
        }
        int pivot = partition(a, start, end);
        quickSort(a, start, pivot-1);
        quickSort(a, pivot+1, end);
    }

    public static void main(String args[]) {
        int a[] = {12, 45, 56, 8, 58, 9, 2};
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
