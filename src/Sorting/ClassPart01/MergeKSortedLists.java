package Sorting.ClassPart01;

/*
Problem
  Feedback
Merge K Sorted Linked Lists

Given k linked lists where each one is sorted in the ascending order, merge all of them into a single sorted linked list.

Example

{
"lists: [
[1, 3, 5],
[3, 4],
[7]
]
}
Output:

[1, 3, 3, 4, 5, 7]
Notes

Constraints:

0 <= k <= 104
0 <= length of any given linked list <= 103
-109 <= node values <= 109
Sum of the lengths of all given lists won't exceed 105.

*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class LinkedListNode {
    Integer value;
    LinkedListNode next;

    LinkedListNode(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedListNodeComparator implements Comparator<LinkedListNode> {
    @Override
    public int compare(LinkedListNode node1, LinkedListNode node2) {
        // Compare the value field of the nodes
        return node1.value.compareTo(node2.value);
    }
}

public class MergeKSortedLists {
    static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {

        if(lists.isEmpty()) {
           return null;
        }

        PriorityQueue<LinkedListNode> minHeap=new PriorityQueue(lists.size(), new LinkedListNodeComparator() );

        lists.forEach(list -> {
            if(list != null)
                minHeap.add(list);
        });

        LinkedListNode temp = null;
        LinkedListNode head = null;
        LinkedListNode tail = null;

        while((temp = minHeap.poll()) != null) {
            System.out.println(temp.value);
            if(head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
            if(temp.next != null) {
                minHeap.add(temp.next);
            }
            tail.next = null;
        }
        return head;
    }

    static LinkedListNode createList(int a[]) {

        LinkedListNode head = null;
        LinkedListNode temp = null;

        for(int i = 0; i < a.length; i++) {
            if(head == null) {
                head = new LinkedListNode(a[i]);
                temp = head;
            } else {
               temp.next = new LinkedListNode(a[i]);
               temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String args[]) {

        ArrayList<LinkedListNode> lists = new ArrayList<>();

        int a[] = {1, 3, 5};
        int b[]  = {3, 4};
        int c[]  = {7};

        LinkedListNode l1 = createList(a);
        LinkedListNode l2 = createList(b);
        LinkedListNode l3 = createList(c);

        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        LinkedListNode head = merge_k_lists(lists);

        for(LinkedListNode temp = head; temp!= null; temp = temp.next) {
            System.out.println(" -> "+ temp.value);
        }


    }

}
