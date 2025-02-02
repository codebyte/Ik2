package leetcode.backtracking;

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

    public static void main(String args[]) {

        System.out.println(generateParenthesis(5).toString());


    }

}
