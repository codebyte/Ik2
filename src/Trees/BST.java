package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeNode {
    Integer value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BST {

    // Recursive methods
    static BinaryTreeNode insert(BinaryTreeNode node, int ele) {
        if (node == null) {
            return new BinaryTreeNode(ele);
        }
        if (ele <= node.value) {
            node.left = insert(node.left, ele);
        } else {
            node.right = insert(node.right, ele);
        }
        return node;
    }

    static Boolean search(BinaryTreeNode root, Integer value) {
        if (root == null) {
            return false;
        }
        if (value.equals(root.value)) {
            return true;
        }

        if (value < root.value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    static void insertNode(BinaryTreeNode root, int ele) {
        BinaryTreeNode node = root;
        while (node != null) {
            if (ele <= node.value) {
                if (node.left == null) {
                    node.left = new BinaryTreeNode(ele);
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new BinaryTreeNode(ele);
                    return;
                }
                node = node.right;
            }
        }
    }

    static BinaryTreeNode build_a_bst(ArrayList<Integer> values) {
        BinaryTreeNode root = null;

        for (int i = 0; i < values.size(); i++) {
            if (root == null) {
                root = new BinaryTreeNode(values.get(i));
            } else {
                //insertNode(root, values.get(i));
                insert(root, values.get(i));
            }
        }
        return root;
    }

    static Boolean searchBST(BinaryTreeNode root, Integer value) {
        BinaryTreeNode node = root;
        while (node != null) {
            if (value.equals(node.value)) {
                return true;
            }
            if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    static Boolean search_node_in_bst(BinaryTreeNode root, Integer value) {

        //return searchBST(root, value);
        return search(root, value);
    }


    /*
    static ArrayList<ArrayList<Integer>> level_order_traversal(BinaryTreeNode root) {
        BinaryTreeNode node;
        ArrayList<Integer> result = new ArrayList<>();

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while ((node = q.poll()) != null) {

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return result;
    }
    */

    static void printBST(BinaryTreeNode root) {

        BinaryTreeNode node;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while ((node = q.poll()) != null) {
            System.out.println(node.value);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    public static void main(String args[]) {
        ArrayList<Integer> values = new ArrayList<>(List.of(10, 5, 12, 67, 8));

        System.out.println("Build BST");
        BinaryTreeNode root = build_a_bst(values);
        printBST(root);
        System.out.println(search_node_in_bst(root, 12));


    }
}
