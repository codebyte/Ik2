package Dp;

import java.util.ArrayList;
import java.util.List;

public class Dp {


    static Integer maximum_path_sum(ArrayList<ArrayList<Integer>> grid) {

        for (int i = 1; i < grid.size(); i++) {
            int prev = grid.get(i - 1).get(0);
            int curr = grid.get(i).get(0);
            ArrayList<Integer> l = grid.get(i);
            l.set(0, prev + curr);
        }

        for (int j = 1; j < grid.get(0).size(); j++) {
            int prev = grid.get(0).get(j - 1);
            int curr = grid.get(0).get(j);
            ArrayList<Integer> l = grid.get(0);
            l.set(j, prev + curr);
        }

        for (int i = 1; i < grid.size(); i++) {
            for (int j = 1; j < grid.get(0).size(); j++) {
                int up = grid.get(i - 1).get(j);
                int left = grid.get(i).get(j - 1);
                int curr = grid.get(i).get(j);
                if (up > left) {
                    curr += up;
                } else {
                    curr += left;
                }
                grid.get(i).set(j, curr);
            }
        }


        return grid.get(grid.size() - 1).get(grid.get(0).size() - 1);
    }


    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

        grid.add(new ArrayList<>(List.of(4, 5, 8)));
        grid.add(new ArrayList<>(List.of(3, 6, 4)));
        grid.add(new ArrayList<>(List.of(2, 4, 7)));

        System.out.println(grid.get(grid.size() - 1).get(grid.get(0).size() - 1));

        System.out.println(maximum_path_sum(grid));

        System.out.println(grid.toString());
    }


}
