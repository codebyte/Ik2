package Sorting.ClassPart02;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    Integer value;
    Integer id;
    Pair(Integer id, Integer value) {
        this.value = value;
        this.id = id;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair n1, Pair n2) {
        // Compare the value field of the nodes
        return n1.value.compareTo(n2.value);
    }
}

public class TopKFrequentElements {
    public static ArrayList<Integer> topK(ArrayList<Integer> a, Integer k) {
        Collections.sort(a);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, new PairComparator());

        int prevNum = 0;
        int nCount = 0;
        for(int i = 0; i < a.size(); ) {

            prevNum = a.get(i);
            nCount=1;
            int j = i + 1;
            for (; (i < a.size()) && (a.get(i) == prevNum); i++) {
                nCount++;
            }
            if (minHeap.size() == k) {
                if (nCount > minHeap.peek().value) {
                    minHeap.poll();
                    minHeap.add(new Pair(prevNum, nCount));
                }
            } else {
                minHeap.add(new Pair(prevNum, nCount));
            }
        }

        Pair p = null;
        ArrayList<Integer> l = new ArrayList<>();
        while((p = minHeap.poll() )!= null) {
           l.add(p.id);
        }
        return l;
    }

    public static void main(String args[]) {
        int a[] = {5, 4, 1, 3, 2, 7, 6};

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            numbers.add(a[i]);
        }
        System.out.println(topK(numbers, 7).toString());


    }

}
