package amazon.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


class Pair {
    public Integer id;
    public Integer val;

    Pair(int id, int val) {
        this.id = id;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "id=" + id +
                ", val=" + val +
                '}';
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair n1, Pair n2) {
        return n1.val.compareTo(n2.val);
    }
}

public class TopFrequent1 {

    public static int[] topKFrequents(int a[], int k) {

        Arrays.sort(a);
        PriorityQueue<Pair> q = new PriorityQueue<>(k, new PairComparator());

        for (int i = 0; i < a.length; i++) {
            int nCount = 0;
            int j = i;
            for (; (j < a.length) && (a[i] == a[j]); j++) {
                nCount++;
            }
            Pair p = new Pair(a[i], nCount);
            if (q.size() == k) {
                if (nCount > q.peek().val) {
                    q.poll();
                    q.add(p);
                }
            } else {
                q.add(p);
            }
            i = j - 1;
        }

        /*
        while(!q.isEmpty()) {
            System.out.println(q.poll().toString());
        }
         */

        int topN[] = new int[q.size()];

        int i = 0;
        while (!q.isEmpty()) {
            topN[i++] = q.poll().id;
        }
        return topN;
    }


    public static void main(String args[]) {

        int a[] = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequents(a, k)));

    }
}

