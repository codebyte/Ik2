package Sorting.PracticeSet01;

/*

Dutch National Flag

Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.

Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.

This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).

Example

{
"balls": ["G", "B", "G", "G", "R", "B", "R", "G"]
}
Output:

["R", "R", "G", "G", "G", "G", "B", "B"]
There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.

Notes

Constraints:

1 <= n <= 100000
Do this in ONE pass over the array, NOT TWO passes
Solution is only allowed to use constant extra memory

*/


import java.util.ArrayList;
import java.util.Collections;

public class DutchNationalFlag {

    public static void flag(ArrayList<Character> balls) {
        int red = -1;
        int green = -1;
        for(int i = 0; i < balls.size(); i++) {
            if(balls.get(i) == 'G') {
                green++;
                Collections.swap(balls, i, green);
            } else if(balls.get(i) == 'R') {
                green++;
                Collections.swap(balls, i, green);
                red++;
                Collections.swap(balls, red, green);
            }
        }
    }

    public static void main(String args[]) {

        Character balls[] = {'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'};

        ArrayList<Character> b = new ArrayList<>();

        for(int i = 0; i < balls.length; i++) {
            b.add(balls[i]);
        }
        System.out.println(b.toString());
        flag(b);
        System.out.println(b.toString());


    }
}
