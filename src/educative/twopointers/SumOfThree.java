package educative.twopointers;

/*

Statement
Given an array of integers, nums, and an integer value, target, determine if there are any three integers in nums whose sum is equal to the target, that is, nums[i] + nums[j] + nums[k] == target. Return TRUE if three such integers exist in the array. Otherwise, return FALSE.

Note: A valid triplet consists of elements with distinct indexes. This means, for the triplet nums[i], nums[j], and nums[k], i

*/


import java.util.Arrays;
import java.util.Collections;

public class SumOfThree {
    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        int j = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int two_sum_target = target - nums[i];
            if (twoSum(nums, i + 1, two_sum_target)) {
                return true;
            }

        }
        return false;
    }

    public static boolean twoSum(int[] nums, int j, int target) {
        int k = nums.length - 1;
        while (j < k) {

            if (target == (nums[j] + nums[k])) {
                return true;
            }
            if ((target - nums[j]) < nums[k]) {
                k--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        int[] nums = {-1, 2, 1, -4, 5, -3};

        System.out.println(findSumOfThree(nums, 0));

    }
}