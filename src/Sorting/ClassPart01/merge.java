package Sorting.ClassPart01;

import java.util.Arrays;
import java.util.Random;

public class merge {


    public static void sort(int a[], int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        sort(a, start, mid);
        sort(a, mid + 1, end);

        int i = start;
        int j = mid + 1;

        int aux[] = new int[end - start + 1];
        int k = 0;
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


        k = 0;
        for (int x = start; (x <= end) && (k < aux.length); x++) {
            a[x] = aux[k++];
        }
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static int random(int start, int end) {
        return new Random().nextInt(end - start + 1) + start;
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


    public static void quickSort(int a[], int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    public static void main(String args[]) {
        int a[] = {10, 3, 6, 67, 8, 9};

        //sort(a, 0, a.length - 1);
        //System.out.println(Arrays.toString(a));

        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }
}
