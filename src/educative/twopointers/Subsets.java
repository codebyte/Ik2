package educative.twopointers;

import java.util.*;

public class Subsets {

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void permute(char[] s, String slate, int index, ArrayList<String> result) {
        if (index == s.length) {
            result.add(new String(slate));
            return;
        }

        for (int i = index; i < s.length; i++) {
            slate += s[i];
            swap(s, i, index);
            permute(s, slate, index + 1, result);
            swap(s, i, index);
            slate = slate.substring(0, slate.length() - 1);
        }
    }

    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> result = new ArrayList<>();
        if (word.isEmpty()) {
            return result;
        }

        permute(word.toCharArray(), "", 0, result);
        return result;
    }


    public static void distinct_subsets(char[] s, StringBuilder slate, int index, ArrayList<String> result) {
        if (index == s.length) {
            result.add(slate.toString());
            return;
        }

        char letter = s[index];
        int count = 1;
        int i = 0;
        for (i = index + 1; (i < s.length) && (s[i] == letter); i++, count++) ;

        distinct_subsets(s, slate, index + count, result);
        for (i = 1; i <= count; i++) {
            slate.append(letter);
            distinct_subsets(s, slate, index + count, result);
        }
        slate.setLength(slate.length() - count);
    }

    static ArrayList<String> get_distinct_subsets(String s) {
        ArrayList<String> result = new ArrayList<>();

        char[] str = s.toCharArray();
        Arrays.sort(str);

        distinct_subsets(str, new StringBuilder(), 0, result);

        return result;
    }

    public static void subsets(int[] nums, ArrayList<Integer> slate, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(slate));
            return;
        }
        subsets(nums, slate, index + 1, result);
        slate.add(nums[index]);
        subsets(nums, slate, index + 1, result);
        slate.removeLast();
    }

    public static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();
        subsets(nums, new ArrayList<>(), 0, setsList);
        return setsList;
    }


    static void dial(Map<Character, String> dial, String number, StringBuilder slate, int index, ArrayList<String> result) {
        if (index == number.length()) {
            result.add(slate.toString());
            return;
        }

        char letter = number.charAt(index);
        if (Character.isDigit(letter)) {
            if (dial.containsKey(letter)) {
                String str = dial.get(letter);
                for (int j = 0; j < str.length(); j++) {
                    slate.append(str.charAt(j));
                    dial(dial, number, slate, index + 1, result);
                    slate.setLength(slate.length() - 1);
                }
            }
        }
    }

    public static void generateParenthesis(int numLeft, int numRight, String slate, ArrayList<String> result) {

        if (numLeft > numRight) {
            return;
        }

        if ((numLeft == 0) && (numRight == 0)) {
            result.add(slate);
            return;
        }

        if (numLeft > 0)
            generateParenthesis(numLeft - 1, numRight, slate + '(', result);
        if (numRight > 0)
            generateParenthesis(numLeft, numRight - 1, slate + ')', result);

    }


    public static void getKSubsets(int[] nums, ArrayList<Integer> slate, int index, List<List<Integer>> result, int k) {

        int sum = 0;
        for (int i = 0; i < slate.size(); i++) {
            sum += slate.get(i);
        }
        if (sum == k) {
            result.add(new ArrayList<>(slate));
            return;
        } else if (sum > k) {
            return;
        }

        if (index == nums.length) {
            return;
        }

        getKSubsets(nums, slate, index + 1, result, k);
        slate.add(nums[index]);
        getKSubsets(nums, slate, index + 1, result, k);
        slate.remove(slate.size() - 1);

    }

    public static List<List<Integer>> getKSumSubsets(int[] nums, int k) {
        // Replace this placeholder return statement with your code

        List<List<Integer>> result = new ArrayList<>();

        getKSubsets(nums, new ArrayList<>(), 0, result, k);

        return result;
    }


    public static ArrayList<String> generateCombinations(int n) {

        ArrayList<String> result = new ArrayList<String>();

        generateParenthesis(n, n, "", result);

        return result;
    }


    static ArrayList<String> get_words_from_phone_number(String phone_number) {
        Map<Character, String> dialpad = new HashMap<>();
        dialpad.put('2', "abc");
        dialpad.put('3', "def");
        dialpad.put('4', "ghi");
        dialpad.put('5', "jkl");
        dialpad.put('6', "mno");
        dialpad.put('7', "pqrs");
        dialpad.put('8', "tuv");
        dialpad.put('9', "wxyz");

        ArrayList<String> result = new ArrayList<>();

        if (phone_number.isEmpty()) {
            return new ArrayList<>(List.of(""));
        }


        String new_phone_number = phone_number.replace("0", "").replace("1", "");


        dial(dialpad, new_phone_number, new StringBuilder(), 0, result);

        if (result.size() == 0) {
            return new ArrayList<>(List.of(""));
        }

        return result;
    }

    static ArrayList<ArrayList<Integer>> getNeighbours(char[][] grid, int i, int j) {
        ArrayList<ArrayList<Integer>> neighbours = new ArrayList<>();

        if ((i + 1) < grid.length) {
            neighbours.add(new ArrayList<>(List.of(i + 1, j)));
        }
        if ((i - 1) >= 0) {
            neighbours.add(new ArrayList<>(List.of(i - 1, j)));
        }
        if ((j + 1) < grid[0].length) {
            neighbours.add(new ArrayList<>(List.of(i, j + 1)));
        }
        if ((j - 1) >= 0) {
            neighbours.add(new ArrayList<>(List.of(i, j - 1)));
        }

        return neighbours;
    }

    static final int[][] DIRECTIONS = {
            {1, 0},   // Down
            {-1, 0},  // Up
            {0, 1},   // Right
            {0, -1}   // Left
    };

    public static boolean search_(char[][] grid, StringBuilder slate, int row, int col, String word, boolean[][] visited) {

        if (word.equals(slate.toString())) {
            return true;
        }

        if ((row >= grid.length) || (col >= grid[0].length)) {
            return false;
        }

        visited[row][col] = true;
        slate.append(grid[row][col]);


        for (int i = 0; i < DIRECTIONS.length; i++) {
            int x = row + DIRECTIONS[i][0];
            int y = col + DIRECTIONS[i][1];

            if ((x < grid.length) && (x >= 0) && (y < grid[0].length) && (y >= 0)) {

                if (!visited[x][y]) {
                    if (search_(grid, slate, x, y, word, visited)) {
                        return true;
                    }
                }
            }
        }
        slate.setLength(slate.length() - 1);
        visited[row][col] = false;
        return false;
    }

    public static boolean search(char[][] grid, StringBuilder slate, int row, int col, String word, boolean[][] visited) {

        if (slate.length() == word.length()) {
            return slate.toString().equals(word);
        }

        if ((row >= grid.length) || (col >= grid[0].length)) {
            return false;
        }

        ArrayList<ArrayList<Integer>> neighbours = getNeighbours(grid, row, col);

        visited[row][col] = true;
        slate.append(grid[row][col]);


        for (int i = 0; i < neighbours.size(); i++) {

            int x = neighbours.get(i).get(0);
            int y = neighbours.get(i).get(1);

            if (!visited[x][y]) {
                if (search(grid, slate, x, y, word, visited)) {
                    return true;
                }
            }
        }
        slate.setLength(slate.length() - 1);
        visited[row][col] = false;
        return false;
    }

    public static boolean wordSearch(char[][] grid, String word) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == word.charAt(0)) {
                        if (search_(grid, new StringBuilder(), i, j, word, visited)) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }


    public static void main(String args[]) {
        System.out.println(permuteWord("abc").toString());
        System.out.println(get_distinct_subsets("aab").toString());

        int num[] = {3, 6, 9, 4, 6, 8};
        System.out.println(findAllSubsets(num).toString());

        System.out.println(get_words_from_phone_number("234").toString());

        System.out.println(generateCombinations(3).toString());

        System.out.println(getKSumSubsets(num, 9));

        char[][] grid = {
                {'h', 'e', 'c', 'm', 'l'},
                {'w', 'l', 'i', 'e', 'u'},
                {'a', 'r', 'r', 's', 'n'},
                {'h', 'e', 'i', 'o', 'r'}
        };

        char[][] grid_ = {{'H', 'I'}};

        System.out.println(wordSearch(grid_, "HI"));


    }
}
