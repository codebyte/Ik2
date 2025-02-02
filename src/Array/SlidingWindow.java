package Array;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow {

    public static float averageStream(int num[], int k) {

        Queue<Integer> q = new LinkedList<>();
        float max = 0;

        int total = 0;

        for (int i = 0; i < num.length; i++) {

            q.add(num[i]);
            total += num[i];

            if (q.size() > k) {
                total -= q.poll();
                float average = (float) total / q.size();
                max = Math.max(average, max);
            }
        }
        System.out.println(max);
        return 0;
    }

    public static float maxAverageWindowSum(int num[], int k) {

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += num[i];
        }
        int globalSum = windowSum;

        for(int i = k; i < num.length; i++) {
            windowSum += num[i];
            windowSum -= num[i-k];
            globalSum = Math.max(windowSum, globalSum);
        }

        return (float)globalSum/k;
    }


    public static void main(String args[]) {
        int num[] = {1, 12, -5, -6, 50, 3};

        averageStream(num, 4);
        System.out.println(maxAverageWindowSum(num, 4));

    }

}
