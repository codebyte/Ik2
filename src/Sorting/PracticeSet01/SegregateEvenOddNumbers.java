package Sorting.PracticeSet01;

/*

Problem
  Feedback
Segregate Even And Odd Numbers

Given an array of numbers, rearrange them in-place so that even numbers appear before odd ones.

Example

{
"numbers": [1, 2, 3, 4]
}
Output:

[4, 2, 3, 1]
The order within the group of even numbers does not matter; same with odd numbers. So the following are also correct outputs: [4, 2, 1, 3], [2, 4, 1, 3], [2, 4, 3, 1].

Notes

It is important to practice solving this problem by rearranging numbers in-place.
There is no need to preserve the original order within the even and within the odd numbers.
We look for a solution of the linear time complexity that uses constant auxiliary space.
Constraints:

1 <= length of the array <= 105
1 <= element of the array <= 109

*/


import java.util.Arrays;
import java.util.Collections;

public class SegregateEvenOddNumbers {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void evenOdd(int a[]) {
        int even = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                even++;
                swap(a, even, i);
            }
        }
    }

    public static void main(String args[]) {

        int a[] = {1, 2, 3, 4};
        evenOdd(a);
        System.out.println(Arrays.toString(a));
    }

}
