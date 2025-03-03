package amazon.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

class KPair {
    int x;
    int y;

    KPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance() {
        return x * x + y * y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}

public class KClosestPairs {

    public static int[][] kClosestPair(int points[][], int k) {

        PriorityQueue<KPair> q = new PriorityQueue<>((a, b) -> Integer.compare(b.getDistance(), a.getDistance()));

        for (int i = 0; i < points.length; i++) {
            KPair pair = new KPair(points[i][0], points[i][1]);
            if (q.size() == k) {
                if (pair.getDistance() < q.peek().getDistance()) {
                    q.poll();
                    q.add(pair);
                }
            } else {
                q.add(pair);
            }
        }

        int[][] result = new int[q.size()][2];
        int i = 0;

        while (!q.isEmpty()) {
            KPair p = q.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }
        return result;
    }

    public static void main(String args[]) {
        int points[][] = {{3, 3}, {5, -1}, {-2, 4},};

        int result[][] = kClosestPair(points, 2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
