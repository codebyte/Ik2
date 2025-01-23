package educative.twopointers;



class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveKthNode {

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode first = head;
        LinkedListNode second = null;
        LinkedListNode third = null;

        int i = 1;
        while ((first.next != null)) {
            if (i == n) {
                System.out.println(i);
                second = head;
            }
            first = first.next;
            if (second != null) {
                third = second;
                second = second.next;
            }
            i++;
        }

        if(i == n) {
            head = second.next;
        }

        if(third != null) third.next = second.next;
        return head;
    }
}
