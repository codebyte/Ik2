package LinkedList;


import java.util.PriorityQueue;

class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    public static LinkedListNode insert(LinkedListNode head, int data) {
        LinkedListNode temp = new LinkedListNode(data);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public static void display(LinkedListNode head) {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.print("--> " + temp.data);
            temp = temp.next;
        }
    }

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        return head;
    }


    public static LinkedListNode middleElement(LinkedListNode head) {
        LinkedListNode first = head;
        LinkedListNode second = head;

        while ((second.next != null) && (second.next.next != null)) {
            second = second.next.next;
            first = first.next;
        }
        if (second.next != null) {
            first = first.next;
        }
        return first;
    }

    public static boolean detectCycle(LinkedListNode head) {
        LinkedListNode first = head;
        LinkedListNode second = head;

        if (head == null) {
            return false;
        }
        while ((second.next != null) && (second.next.next != null)) {
            second = second.next.next;
            first = first.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        LinkedListNode head = new LinkedListNode(12);
        LinkedListNode tail = head;

        for (int i = 0; i < 7; i++) {
            head = insert(head, i * 10);
        }
        display(head);
        removeNthLastNode(head, 6);
        System.out.println();
        display(head);
        System.out.println();
        System.out.println(middleElement(head).data);
        tail.next = head;
        System.out.println("Head : " + head.data);
        System.out.println("Tail : " + tail.data);
        System.out.println(detectCycle(head));


    }
}
