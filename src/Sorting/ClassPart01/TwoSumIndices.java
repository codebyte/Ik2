package Sorting.ClassPart01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIndices {

    public static ArrayList<Integer> two_sum(ArrayList<Integer> a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();


        for (int i = 0; i < a.size(); i++) {
            int complement = target - a.get(i);
            if (map.containsKey(complement)) {
                result.add(map.get(complement));
                result.add(i);
                return result;
            } else {
                map.put(a.get(i), i);
            }
        }

        if (result.size() != 2) {
            result.add(-1);
            result.add(-1);
        }
        return result;
    }


    public static void main(String args[]) {

        int a[] = {4, 1, 5, 0, -1};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        System.out.println(two_sum(list, 6));


    }
}
