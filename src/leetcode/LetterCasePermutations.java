package leetcode;

import java.util.*;

public class LetterCasePermutations {


    public static void combinations(String number, Map<Character, String> dial, StringBuilder slate, int index, ArrayList<String> result) {
        if (index == number.length()) {
            result.add(slate.toString());
            return;
        }

        char letter = number.charAt(index);

        if (dial.containsKey(letter)) {
            String str = dial.get(letter);
            for (int i = 0; i < str.length(); i++) {
                slate.append(str.charAt(i));
                combinations(number, dial, slate, index + 1, result);
                slate.setLength(slate.length() - 1);
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();

        Map<Character, String> dial = new HashMap<>();
        dial.put('2', "abc");
        dial.put('3', "def");
        dial.put('4', "ghi");
        dial.put('5', "jkl");
        dial.put('6', "mno");
        dial.put('7', "pqrs");
        dial.put('8', "tuv");
        dial.put('9', "wxyz");

        combinations(digits, dial, new StringBuilder(), 0, result);

        if(result.isEmpty()) {
            return new ArrayList<>();
        }

        return result;
    }


    public static void main(String args[]) {

        System.out.println(letterCombinations("23").toString());


    }

}
