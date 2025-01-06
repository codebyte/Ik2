package Sorting.ClassPart02;

/*
Problem
  Feedback
Kth Largest In An Array

Given an array of integers, find the k-th largest number in it.

Example One

{
"numbers": [5, 1, 10, 3, 2],
"k": 2
}
Output:

5
Example Two

{
"numbers": [4, 1, 2, 2, 3],
"k": 4
}
Output:

2
Notes

Constraints:

1 <= array size <= 3 * 105
-109 <= array elements <= 109
1 <= k <= array size
*/

import java.util.Arrays;
import java.util.Random;

public class KthLargestInArray {

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
        for(int right = start+1; right <= end; right++) {
            if(a[right] < a[start]) {
                left++;
                swap(a, left, right);
            }
        }
        swap(a, start, left);
        return left;
    }

    public static void qSelect(int a[], int start, int end, int k) {
        if(start >= end) {
            return;
        }
        int pivot = partition(a, start, end);
        if(pivot == k) {
            return;
        }
        if(k < pivot) {
            qSelect(a, start, pivot - 1, k);
        }  else {
            qSelect(a, pivot + 1, end, k);
        }
    }

    public static void main(String args[]) {

        int a[] = {4, 1, 2, 2, 3};
        int k = 4;

        System.out.println(Arrays.toString(a));
        qSelect(a, 0, a.length-1, a.length-k);
        System.out.println(Arrays.toString(a));
        System.out.println(a[a.length-k]);


    }

}
