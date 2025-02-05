package leetcode;

import java.util.Arrays;

public class MergeSortedArray88 {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;

        int k = nums1.length - 1;
        while ((i >= 0) && (j >= 0)) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        while (i >= 0) {
            nums1[k--] = nums2[j--];
        }
    }


    public static void main(String args[]) {
        int nums1[] = {0};
        int nums2[] = {1};

        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));


    }

}
