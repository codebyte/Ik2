package leetcode;

import java.util.ArrayList;

public class Combinations {

    public static void combinationSum(int[] candidates, ArrayList<Integer> slate, int target, int index, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(slate));
            return;
        }
        if (target < 0) {
            return;
        }

        combinationSum(candidates, slate, target - candidates[index], index + 1, result);
        slate.add(candidates[index]);
        combinationSum(candidates, slate, target - candidates[index], index + 1, result);
        slate.remove(slate.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> combinations(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combination(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public static void combination(int n, int k, int index, ArrayList<Integer> slate, ArrayList<ArrayList<Integer>> result) {

        if (slate.size() == k) {
            result.add(new ArrayList<>(slate));
            return;
        }
        if (slate.size() > k) {
            return;
        }

        if (index > n) {
            return;
        }

        combination(n, k, index + 1, slate, result);
        slate.add(index);
        combination(n, k, index + 1, slate, result);
        slate.remove(slate.size() - 1);
    }

    public static void main(String args[]) {
        int[] candidates = {2, 3, 6, 7};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combinationSum(candidates, new ArrayList<>(), 7, 0, result);
        System.out.println(result.toString());
        System.out.println(combinations(4, 2).toString());


    }

}