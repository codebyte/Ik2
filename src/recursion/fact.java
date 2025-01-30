package recursion;

import java.util.*;

public class fact {

    public static int fact(int n) {
        if (n == 1) {
            return n;
        }
        return n * fact(n - 1);
    }

    public static int raiseToInt(int k, int n) {
        if (k == 0) {
            return 1;
        }
        return n * raiseToInt(n, k - 1);
    }

    public static int subsets(int n) {

        if (n == 0) {
            return 1;
        }
        return 2 * subsets(n - 1);
    }

    public static int fibonaci(int n, int a, int b) {
        if ((n == 1) || (n == 0)) {
            return a + b;
        }
        return fibonaci(n - 2, b, a + b);
    }


    static ArrayList<ArrayList<Integer>> find_combinations(Integer n, Integer k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combinations(n, k, result);
        return result;
    }

    public static void combinations(Integer n, Integer k, ArrayList<ArrayList<Integer>> result) {
        if ((k == 0) || (n == 0) || (k == n)) {
            return;
        }
        result.add(new ArrayList<>(List.of(n, k)));
        combinations(n - 1, k, result);
        combinations(n - 1, k - 1, result);
    }

    static void generateBinaryStrings(Integer n, String slate, ArrayList<String> result) {
        if (n == 0) {
            result.add(slate);
            return;
        }
        generateBinaryStrings(n - 1, slate + '0', result);
        generateBinaryStrings(n - 1, slate + '1', result);
    }

    static ArrayList<String> get_binary_strings(Integer n) {
        ArrayList<String> result = new ArrayList<>();
        generateBinaryStrings(n, "", result);
        return result;
    }

    static void generateDicimalNumber(ArrayList<Integer> arr, ArrayList<Integer> slate, boolean[] used, ArrayList<ArrayList<Integer>> result) {
        if (slate.size() == arr.size()) {
            result.add(new ArrayList<>(slate));
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (!used[i]) {
                slate.add(arr.get(i));
                used[i] = true;
                generateDicimalNumber(arr, slate, used, result);
                used[i] = false;
                slate.remove(slate.size() - 1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.size()];
        generateDicimalNumber(arr, new ArrayList<>(), used, result);
        return result;
    }


    public static void permute(int[] arr, ArrayList<Integer> slate, boolean[] used, List<List<Integer>> result) {

        if (slate.size() == arr.length) {
            result.add(new ArrayList<>(slate));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                slate.add(arr[i]);
                used[i] = true;
                permute(arr, slate, used, result);
                used[i] = false;
                slate.remove(slate.size() - 1);
            }
        }
    }

    static List<List<Integer>> get_permutations_(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        permute(arr, new ArrayList<>(), new boolean[arr.length], result);
        return result;
    }

    public static void compute(ArrayList<Integer> arr, ArrayList<Integer> slate, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(slate));
            return;
        }
        compute(arr, slate, index + 1, result);
        slate.add(arr.get(index));
        compute(arr, slate, index + 1, result);
        slate.remove(slate.size() - 1);
    }


    static ArrayList<ArrayList<Integer>> get_compute(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        compute(arr, new ArrayList<>(), 0, result);
        return result;
    }


    public static void compute_strings(String str, String slate, int index, ArrayList<String> result) {
        if (index == str.length()) {
            result.add(slate);
            return;
        }
        compute_strings(str, slate, index + 1, result);
        compute_strings(str, slate + str.charAt(index), index + 1, result);
    }


    static ArrayList<String> generate_all_subsets(String str) {
        ArrayList<String> result = new ArrayList<>();
        compute_strings(str, "", 0, result);
        return result;
    }

    public static void permuteLetters(String s, String slate, int index, ArrayList<String> result) {
        if (index == s.length()) {
            result.add(slate);
            return;
        }

        Character letter = s.charAt(index);
        if (Character.isAlphabetic(letter)) {
            permuteLetters(s, slate + Character.toUpperCase(letter), index + 1, result);
            permuteLetters(s, slate + Character.toLowerCase(letter), index + 1, result);
        } else {
            permuteLetters(s, slate + letter, index + 1, result);
        }
    }


    public static ArrayList<String> letter_case_permutations(String s) {
        ArrayList<String> result = new ArrayList<>();

        permuteLetters(s, "", 0, result);
        return result;
    }

    static void subset(String s, String slate, int index, ArrayList<String> result) {
        if (index == s.length()) {
            result.add(slate);
            return;
        }
        subset(s, slate, index + 1, result);
        subset(s, slate + s.charAt(index), index + 1, result);
    }

    static ArrayList<String> generate_all_subsets_(String s) {
        ArrayList<String> result = new ArrayList<>();
        subset("xy", "", 0, result);
        return result;
    }

    static void permutations_(ArrayList<Integer> arr, ArrayList<Integer> slate, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(slate));
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            slate.add(arr.get(i));
            Collections.swap(arr, i, index);
            permutations_(arr, slate, index + 1, result);
            slate.remove(slate.size() - 1);
            Collections.swap(arr, i, index);
        }
    }

    static ArrayList<ArrayList<Integer>> get_permutations_(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permutations_(arr, new ArrayList<>(), 0, result);
        return result;
    }


    static void permutations_duplicates(ArrayList<Integer> arr, ArrayList<Integer> slate, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(slate));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < arr.size(); i++) {
            if (set.contains(arr.get(i))) {
                continue;
            }
            set.add(arr.get(i));
            slate.add(arr.get(i));
            Collections.swap(arr, i, index);
            permutations_duplicates(arr, slate, index + 1, result);
            Collections.swap(arr, i, index);
            slate.remove(slate.size() - 1);
        }
    }


    static ArrayList<ArrayList<Integer>> get_permutations_duplicates(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permutations_duplicates(arr, new ArrayList<>(), 0, result);
        return result;
    }


    public static void get_distinct_subset(String s, String slate, int index, ArrayList<String> result) {
        if (index == s.length()) {
            result.add(slate);
            return;
        }
        Character prev = s.charAt(index);
        int count = 0;
        int i = 0;
        for (i = index; (i < s.length()) && (s.charAt(i) == prev); i++, count++) ;

        get_distinct_subset(s, slate, index + 1, result);
        get_distinct_subset(s, slate + prev, index + count, result);
        get_distinct_subset(s, slate + prev, index + count, result);
        get_distinct_subset(s, slate + prev, index + count, result);


    }


    static ArrayList<String> get_distinct_subsets(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        s = String.valueOf(str);

        ArrayList<String> result = new ArrayList<>();
        get_distinct_subset(s, "", 0, result);
        return result;
    }


    static Map<Integer, Long> memo = new HashMap<>();

    public static Long f(int n) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if ((n == 0) || (n == 1)) {
            return 1L;
        }

        Long value =  f(n - 1) + f(n - 2);

        memo.put(n, value);
        return memo.get(n);
    }


    public static void main(String args[]) {
        /*
        System.out.println(fact(5));
        System.out.println(raiseToInt(2, 8));
        System.out.println(subsets(50));
        System.out.println(fibonaci(4, 0, 1));
         */
        //System.out.println(find_combinations(5, 2).toString());

        ArrayList<String> result = new ArrayList<>();
        generateBinaryStrings(3, "", result);
        System.out.println(result.toString());
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(1);
        s.add(2);
        System.out.println(get_permutations(s).toString());

        int b[] = {1, 2, 3};
        System.out.println(get_permutations_(b).toString());
        System.out.println(get_compute(s).toString());
        System.out.println(generate_all_subsets("abc").toString());

        System.out.println(letter_case_permutations("a1z"));
        System.out.println(generate_all_subsets_("xz").toString());
        System.out.println(get_permutations_duplicates(s).toString());
        System.out.println(get_distinct_subsets("aab").toString());

        System.out.println(f(55));

    }

}
