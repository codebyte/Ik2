package Sorting.ClassPart01;

/*
Given a list of meeting intervals where each interval consists of a start and an end time, check if a person can attend all the given meetings such that only one meeting can be attended at a time.

        Example One

{
        "intervals": [
        [1, 5],
        [5, 8],
        [10, 15]
        ]
        }
Output:

        1
As the above intervals are non-overlapping intervals, it means a person can attend all these meetings.

Example Two

{
        "intervals": [
        [1, 5],
        [4, 8]
        ]
        }
Output:

        0
Time 4 - 5 is overlapping in the first and second intervals.

Notes

A new meeting can start at the same time the previous one ended.
        Constraints:

        1 <= number of intervals <= 10^5
        0 <= start time < end time <= 10^9
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class ColumnComparator implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> ar1, ArrayList<Integer> ar2) {
        return ar1.get(0).compareTo(ar2.get(0));
    }
}

public class AttendMeetings {
    static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {
        Collections.sort(intervals, new ColumnComparator());
        for (int i = 1; i < intervals.size(); i++) {
            Integer prevEndTime = intervals.get(i - 1).get(1);
            Integer currStartTime = intervals.get(i).get(0);
            if (prevEndTime > currStartTime) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        intervals.add(new ArrayList<>(Arrays.asList(1, 5)));
        intervals.add(new ArrayList<>(Arrays.asList(4, 8)));
        System.out.println(can_attend_all_meetings(intervals));
    }
}