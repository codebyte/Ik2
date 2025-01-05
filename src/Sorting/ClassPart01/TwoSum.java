/*
    
2 Sum In An Array

Given an array and a target number, find the indices of the two values from the array that sum up to the given target number.

Example One

{
"numbers": [5, 3, 10, 45, 1],
"target": 6
}
Output:

[0, 4]
Sum of the elements at index 0 and 4 is 6.

Example Two

{
"numbers": [4, 1, 5, 0, -1],
"target": 10
}
Output:

[-1, -1]
*/
package Sorting.ClassPart01;

import java.util.Arrays;
import java.util.Random;

public class TwoSum {
    public static boolean twoSum(int a[], int target) {
        qSort(a, 0, a.length);
        int i = 0;
        int j = a.length-1;
        while(i < j) {
            int sum = a[i] + a[j];
            if(sum == target) {
                return true;
            }
            if(sum > target) {
                j--;
            } else {
               i++;
            }
        }
        return false;
    }

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
        System.out.println("Start : " + start + "end : " + end + "seed Pivot : " + seedPivot);
        swap(a, start, seedPivot);
        int left = start;
        for(int right = start+1; right < a.length; right++) {
            if(a[right] < a[start]) {
                left++;
                swap(a, left, right);
            }
        }
        swap(a, left, start);
        return left;
    }

    public static void qSort(int a[], int start, int end) {
        if(start >= end) {
            return;
        }
        int pivot = partition(a, start, end);
        qSort(a, start, pivot-1);
        qSort(a, pivot+1, end);
    }

    public static void main(String args[]) {
        int a[] = {10, 34, 456, 5, 7, 78, 0};
        qSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
        System.out.println(twoSum(a, 87));
    }
}
