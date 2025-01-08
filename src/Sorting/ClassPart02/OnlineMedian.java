package Sorting.ClassPart02;

/*

Problem
  Feedback
Online Median

Given a list of numbers, the task is to insert these numbers into a stream and find the median of the stream after each insertion. If the median is a non-integer, consider it’s floor value.

The median of a sorted array is defined as the middle element when the number of elements is odd and the mean of the middle two elements when the number of elements is even.

Example

{
"stream": [3, 8, 5, 2]
}
Output:

[3, 5, 5, 4]
Iteration	Stream	Sorted Stream	Median
1	[3]	[3]	3
2	[3, 8]	[3, 8]	(3 + 8) / 2 => 5
3	[3, 8, 5]	[3, 5, 8]	5
4	[3, 8, 5, 2]	[2, 3, 5, 8]	(3 + 5) / 2 => 4
Notes

Constraints:

1 <= length of stream <= 10^5
1 <= any value in the stream <= 10^5
The stream can contain duplicates.

*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OnlineMedian {

    static ArrayList<Integer> online_median(ArrayList<Integer> stream) {

        if (stream.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int median = 0;

        for(int i = 0; i < stream.size(); i++) {

            int ele = stream.get(i);

            if (ele >= median) {
                minHeap.add(ele);
            } else {
                maxHeap.add(ele);
            }

            if (minHeap.size() == (maxHeap.size() + 2)) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() == (minHeap.size() + 2)) {
                minHeap.add(maxHeap.poll());
            }

            if (minHeap.isEmpty()) {
                median = maxHeap.peek();
            } else if (maxHeap.isEmpty()) {
                median = minHeap.peek();
            } else if (minHeap.size() == maxHeap.size()) {
                median = (minHeap.peek() + maxHeap.peek()) / 2;
            } else if (minHeap.size() > maxHeap.size()) {
                median = minHeap.peek();
            } else if (minHeap.size() < maxHeap.size()) {
                median = maxHeap.peek();
            }
            result.add(median);
        }

        return result;
    }

    public static void main(String args[]) {

        ArrayList<Integer> stream = new ArrayList<>();
        stream.add(4);
        stream.add(3);
        stream.add(2);
        stream.add(1);
        System.out.println(online_median(stream));


    }

}
