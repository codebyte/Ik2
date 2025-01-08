package Sorting.PracticeSet02;

/*

Sort All Characters

Given a list of characters, sort it in the non-decreasing order based on ASCII values of characters.

Example

{
    "arr": ["a", "s", "d", "f", "g", "*", "&", "!", "z", "y"]
}
Output:

        ["!", "&", "*", "a", "d", "f", "g", "s", "y", "z"]
Notes

Constraints:

        1 <= length of the list <= 100000
Input list consists of alphanumeric characters and these ones: !, @, #, $, %, ^, &, *, (, ).

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortAllCharacters {
    public static int randomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start) + start;
    }

    public static void swap(Character c[], int i, int j) {
        Character temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static int partition(ArrayList<Character> c, int start, int end) {
        int seedPivot = randomNumber(start, end);
        Collections.swap(c, start, seedPivot);
        int left = start;
        for(int right = start+1; right <= end; right++) {
            if(c.get(right) < c.get(start)) {
                left++;
                Collections.swap(c, left, right);
            }
        }
        Collections.swap(c, start, left);
        return left;
    }

    public static void qSort(ArrayList<Character> c, int start, int end) {
        if(start >= end) {
            return ;
        }
        int pivot = partition(c, start, end);
        qSort(c, start, pivot-1);
        qSort(c, pivot+1, end);
    }

    public static void main(String args[]) {
        Character c[] = { 'a', 's', 'd', 'f', 'g', '*', '&', '!', 'z', 'y'};

        ArrayList<Character> b = new ArrayList<>();

        for(int i = 0; i < c.length; i++) {
            b.add(c[i]);
        }

        qSort(b, 0, b.size()-1);
        System.out.println(b.toString());
    }


}
