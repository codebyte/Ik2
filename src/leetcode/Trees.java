package leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

class TreeNode {
    Integer value;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public class Trees {
    }


    public static TreeNode insertBST(TreeNode head, int i) {
        if (head == null) {
            head = new TreeNode(i);
            return head;
        }

        TreeNode temp = head;
        TreeNode curr = temp;

        while (temp != null) {
            curr = temp;
            if (i < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (i < curr.value) {
            curr.left = new TreeNode(i);
        } else {
            curr.right = new TreeNode(i);
        }
        return head;
    }

    public static void print(TreeNode head) {
        if (head == null) {
            return;
        }
        print(head.left);
        System.out.println(head.value);
        print(head.right);

    }

    static int max_depth = 0;

    public static void maxDepth(TreeNode node, int level) {
        if (node == null) {
            max_depth = Math.max(max_depth, level);
            return;
        }

        maxDepth(node.left, level + 1);
        maxDepth(node.right, level + 1);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> level = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int qSize = 0;
        TreeNode child = null;

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            qSize = q.size();
            result.add(q.peekLast().value);
            while (qSize > 0) {
                child = q.poll();
                qSize--;
                if (child.left != null) {
                    q.add(child.left);
                }
                if (child.right != null) {
                    q.add(child.right);
                }
            }
        }

        return result;
    }

    public static List<Double> averageLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> level = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int qSize = 0;
        TreeNode child = null;

        List<Double> result = new ArrayList<>();
        while (!q.isEmpty()) {
            qSize = q.size();
            int i = 0;
            Long levelTotal = 0L;
            while (i < qSize) {
                child = q.poll();
                levelTotal += child.value;
                i++;
                if (child.left != null) {
                    q.add(child.left);
                }
                if (child.right != null) {
                    q.add(child.right);
                }
            }
            result.add((double) levelTotal / qSize);
        }

        return result;
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> level = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int qSize = 0;
        TreeNode child = null;
        boolean flip = false;

        while (!q.isEmpty()) {
            qSize = q.size();

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                child = q.poll();
                result.add(child.value);
                if (child.left != null) {
                    q.add(child.left);
                }
                if (child.right != null) {
                    q.add(child.right);
                }
            }
            if (flip) {
                Collections.reverse(result);
                flip = false;
            } else {
                flip = true;
            }
            level.add(result);
        }
        return level;
    }


    public static void main(String[] args) {

        TreeNode head = null;
        head = insertBST(head, 10);
        head = insertBST(head, 5);
        head = insertBST(head, 2);
        head = insertBST(head, 40);

        print(head);

        maxDepth(head, 0);
        System.out.println(max_depth);
        System.out.println(rightSideView(head).toString());
        System.out.println(averageLevels(head).toString());
        System.out.println(levelOrderTraversal(head).toString());

    }


}
