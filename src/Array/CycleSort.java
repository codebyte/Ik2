package Array;

import java.util.ArrayList;
import java.util.List;

public class CycleSort {


    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void findDuplicates(int a[]) {
        int last = -1;

        for (int i = 0; i < a.length; i++) {

            // duplicate
            while (a[i] != (i + 1)) {
                if (last == a[i]) {
                    break;
                }

                last = a[i];
                swap(a, a[i] - 1, i);
            }

        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != (i + 1)) {
                System.out.println("Found : " + (i + 1) + " : " + a[i]);
                break;
            }
        }
    }

    public static int[] findAllDuplicates(int nums[]) {
        int[] duplicates = new int[nums.length];

        int last = -1;

        for (int i = 0; i < nums.length; i++) {

        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {

                if (last == nums[i]) {
                    break;
                }

                last = nums[i];
                swap(nums, nums[i] - 1, i);
            }
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                duplicates[k++] = nums[i];
                duplicates[k++] = i + 1;
            }
        }
        return duplicates;
    }

    public static int findPositiveNumber(int[] nums) {

        int last = 0;

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != (i + 1)) {

                if ((nums[i] < 0) || (nums[i] > (nums.length))) {
                    break;
                }

                if (last == nums[i]) {
                    break;
                }
                last = nums[i];
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                return (i + 1);
            }
        }
        return 0;
    }


    public static int findMissingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i) {

                if (nums[i] >= nums.length) {
                    return i;
                }
                swap(nums, nums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return -1;
    }


    public static List<Integer> firstKMissingNumbers(int[] arr, int k) {
        List<Integer> bag = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {

                if ((arr[i] < 0) || (arr[i] >= arr.length)) {
                    break;
                }
                swap(arr, arr[i], i);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                bag.add(i);
            }
        }

        return bag;
    }

    public static void main(String args[]) {
        int a[] = {0, 1, 2, 4};

        //System.out.println(findPositiveNumber(a));
        System.out.println(java.util.Arrays.toString(a));
        System.out.println(findMissingNumber(a));
        System.out.println(firstKMissingNumbers(a, 3));

    }
}
