package Sorting.ClassPart02;

/*
Kth Largest In A Stream

Given an initial list along with another list of numbers to be appended with the initial list and an integer k, return an array consisting of the k-th largest element after adding each element from the first list to the second list.

Example

{
"k": 2,
"initial_stream": [4, 6],
"append_stream": [5, 2, 20]
}
Output:

[5, 5, 6]
Append	Stream	Sorted Stream	2nd largest
5	[4, 6, 5]	[4, 5, 6]	5
2	[4, 6, 5, 2]	[2, 4, 5, 6]	5
20	[4, 6, 5, 2, 20]	[2, 4, 5, 6, 20]	6
Notes

The stream can contain duplicates.
Constraints:

1 <= length of both lists <= 105
1 <= k <= length of initial list + 1
0 <= any value in the list <= 109

*/

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInStream {

    static void insertIntoHeap(Queue<Integer> minHeap, int ele, int k) {
        if (minHeap.size() == k) {
            if (minHeap.peek() < ele) {
                minHeap.poll();
                minHeap.add(ele);
            }
        } else {
            minHeap.add(ele);
        }
    }

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        ArrayList<Integer> result = new ArrayList<>();

        initial_stream.forEach(ele -> {
            insertIntoHeap(minHeap, ele, k);
        });

        append_stream.forEach(ele -> {
            insertIntoHeap(minHeap, ele, k);
            result.add(minHeap.peek());
        });
        return result;
    }

    public static void main(String args[]) {
        ArrayList<Integer> initial_stream = new ArrayList<>();
        initial_stream.add(4);
        initial_stream.add(6);

        ArrayList<Integer> append_stream = new ArrayList<>();
        append_stream.add(5);
        append_stream.add(2);
        append_stream.add(20);

        ArrayList<Integer> result = kth_largest(2, initial_stream, append_stream);

        System.out.println(result.toString());

    }
}
