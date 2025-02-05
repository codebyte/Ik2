package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class generateParanthesis {


    public static void generate(int n, int left, int right, String slate, ArrayList<String> result) {

        if (right < left) {
            return;
        }

        if ((left == 0) && (right == 0)) {
            result.add(slate);
            return;
        }

        if (left > 0) {
            generate(n, left - 1, right, slate + "(", result);
        }
        if (right > 0) {
            generate(n, left, right - 1, slate + ")", result);
        }
    }


    public static List<String> generateParenthesis(int n) {

        ArrayList<String> result = new ArrayList<>();

        generate(n, n, n, "", result);

        return result;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void permuteeee(int[] nums, ArrayList<Integer> slate, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(slate));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            slate.add(nums[i]);
            swap(nums, i, index);
            permuteeee(nums, slate, index + 1, result);
            swap(nums, i, index);
            slate.remove(slate.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        permuteeee(nums, new ArrayList<>(), 0, result);
        return result;

    }

    public static void main(String args[]) {

        System.out.println(generateParenthesis(5).toString());
        int nums[] = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
