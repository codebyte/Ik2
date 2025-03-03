package concurrency;


class LinkNode {
    int val;
    LinkNode left;
    LinkNode right;

    LinkNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class LRUCache {

    LinkNode head;
    LinkNode tail;

    LRUCache() {
        this.head = null;
        this.tail = null;
    }

    public void updateNode(LinkNode temp) {
        if (head == null) {
            head = temp;
            tail = temp;
            System.out.println("UpdateNode : " + temp.val);
        } else {
            temp.right = head;
            head.left = temp;
            head = temp;
        }
    }

    public void insert(int ele) {
        LinkNode node = new LinkNode(ele);
        updateNode(node);
    }

    public LinkNode searchNode(int ele) {
        boolean found = false;
        LinkNode temp = head;

        while (temp != null) {
            if (ele == temp.val) {
                return temp;
            }
            temp = temp.right;
        }
        return null;
    }

    public void update(int ele) {
        LinkNode temp = searchNode(ele);
        if (temp != null) {
            updateNode(temp);
        }
    }

    public void delete(int ele) {
        LinkNode temp = searchNode(ele);
        if (temp.left != null) {
            temp.left.right = temp.right;
        }
        if (temp.right != null) {
            temp.right.left = temp.left;
        }
    }

    public int get(int ele) {
        LinkNode temp = searchNode(ele);
        if (temp != null) {
            return temp.val;
        }
        return -1;
    }

    public void display() {
        LinkNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.right;
        }
    }

    public static void main(String args[]) {
        LinkNode head = null;

        LRUCache lruCache = new LRUCache();
        for (int i = 0; i < 10; i++) {
            lruCache.insert(i);
        }

        lruCache.display();


    }
}
