package Trees;

import java.lang.reflect.Array;
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

    static Integer get_max(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null) {
            return root.value;
        }
        return get_max(root.right);
    }

    static Integer get_maximum_value(BinaryTreeNode root) {
        BinaryTreeNode temp = root;

        if (root == null) {
            return 0;
        }
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.value;
    }


    static void preOrder(BinaryTreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    static ArrayList<Integer> preorder(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    static void postOrder(BinaryTreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.value);
    }

    static ArrayList<Integer> postorder(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    static void inOrder(BinaryTreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.value);
        inOrder(root.right, result);
    }

    static ArrayList<Integer> inorder(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }


    // Iterative method
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

    static class Pair {
        BinaryTreeNode node;
        int level;

        Pair(BinaryTreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static void recordLevel(Pair pair, ArrayList<ArrayList<Integer>> result) {
        int level = pair.level;

        if (level < result.size()) {
            result.get(level).add(pair.node.value);
        } else {
            result.add(new ArrayList<>(List.of(pair.node.value)));
        }
    }

    static ArrayList<ArrayList<Integer>> level_order_traversal(BinaryTreeNode root) {
        Pair pair;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while ((pair = q.poll()) != null) {
            recordLevel(pair, result);
            if (pair.node.left != null) {
                q.add(new Pair(pair.node.left, pair.level + 1));
            }
            if (pair.node.right != null) {
                q.add(new Pair(pair.node.right, pair.level + 1));
            }
        }
        return result;
    }


    static ArrayList<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        BinaryTreeNode node = root;

        int i = 0;

        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int qSize = q.size();
            i = 0;
            while(i < qSize) {
                node = q.poll();
                list.add(node.value);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                i++;
            }
            result.add(list);
        }
        return result;
    }

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
        ArrayList<Integer> values = new ArrayList<>(List.of(10, 5, 12, 67, 8, 99));

        System.out.println("Build BST");
        BinaryTreeNode root = build_a_bst(values);
        printBST(root);
        System.out.println(search_node_in_bst(root, 12));
        System.out.println(preorder(root));
        System.out.println(postorder(root));
        System.out.println(inorder(root));
        System.out.println(get_maximum_value(root));
        System.out.println(get_max(root));
        System.out.println(level_order_traversal(root).toString());
        System.out.println(levelOrderTraversal(root).toString());


    }
}
