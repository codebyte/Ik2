package leetcode;

import java.util.Arrays;

public class Bsearch {


    public static int[] searchRange(int[] a, int target) {

        int start = 0;
        int end = a.length - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if ((start == a.length) || (target != a[start])) {
            return new int[]{-1, -1};
        }

        end = a.length - 1;
        int first = start;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return new int[]{first, start - 1};
    }


    public static boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;

        int end = (maxRows * maxCols) - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            int midRow = mid / maxCols;
            int midCol = mid % maxCols;

            if (matrix[midRow][midCol] == target) {
                return true;
            }

            if (matrix[midRow][midCol] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void search(int a[]) {

        int start = 0;
        int end = a.length - 1;

        int ele = 15;
        int index = 0;

        while (true) {

            if (start > end) {
                System.out.println("Start : " + start);
                index = start;
                break;
            }


            int mid = start + (end - start) / 2;
            if (a[mid] == ele) {
                break;
            }
            if (ele < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    public static int bSearch(int a[]) {
        int i = 0;
        int j = a.length - 1;

        for (i = 0; i < a.length; i++) {
            if (a[i] > a[i + 1]) {
                break;
            }
        }

        for (; j > 0; j--) {
            if (a[j] > a[j - 1]) {
                break;
            }
        }

        System.out.println("I : " + i);
        System.out.println("J : " + j);

        if (i == j) {
            return i;
        }
        return 0;
    }

    public static int mountainIndex(int a[]) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == 0) || (mid == a.length - 1)) {
                return mid;
            }

            if ((a[mid] > a[mid - 1]) && (a[mid] > a[mid + 1])) {
                return mid;
            }
            if (a[mid] > a[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }


    public static int findPeakElement(int a[]) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid < a.length - 1) && (a[mid] < a[mid + 1])) {
                start = mid + 1;
            } else if ((mid > 0) && (a[mid] > a[mid - 1])) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray(int[] a) {

        int start = 0;
        int end = a.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if ((mid > 0) && (mid < a.length - 1) && (a[mid] > a[mid - 1]) && (a[mid] > a[mid + 1])) {
                return mid;
            }

            if ((mid < a.length - 1) && (a[mid] < a[mid + 1])) {
                start = mid + 1;
            } else if ((mid > 0) && (a[mid] < a[mid - 1])) {
                end = mid - 1;
            }

        }

        return -1;
    }


    public static void main(String args[]) {
        int a[] = {10, 20, 30, 40, 50};

        System.out.println(Arrays.toString(searchRange(a, 3)));

        int matrix[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println(searchMatrix(matrix, 16));


        int b[] = {24,69,100,99,79,78,67,36,26,19};
        //System.out.println(mountainIndex(b));
        System.out.println(findPeakElement(b));

        System.out.println(peakIndexInMountainArray(b));

    }
}
