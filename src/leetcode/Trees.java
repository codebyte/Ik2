package leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

class Pair {
    TreeNode node;
    int x;

    Pair(TreeNode node, int x) {
        this.node = node;
        this.x = x;
    }
}

class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer val) {
        this.val = val;
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
            if (i < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (i < curr.val) {
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
        System.out.print(" " + head.val);
        print(head.left);
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
            result.add(q.peekLast().val);
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
                levelTotal += child.val;
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
                result.add(child.val);
                if (child.left != null) {
                    q.add(child.left);
                }
                if (child.right != null) {
                    q.add(child.right);
                }
            }
            /*
            if (flip) {
                Collections.reverse(result);
                flip = false;
            } else {
                flip = true;
            }
             */
            level.add(result);
        }
        return level;
    }

    public static void printALlPaths(TreeNode node, String slate) {
        if ((node.left == null) && (node.right == null)) {
            System.out.println(slate + " -> " + node.val);
            return;
        }
        if (node.left != null) {
            printALlPaths(node.left, slate + " -> " + node.val);
        }
        if (node.right != null) {
            printALlPaths(node.right, slate + " -> " + node.val);
        }
    }

    public static boolean pathSum(TreeNode node, int targetSum) {
        if ((node.left == null) && (node.right == null)) {
            if (node.val == targetSum) {
                return true;
            }
        }
        if (node.left != null) {
            if (pathSum(node.left, targetSum - node.val)) {
                return true;
            }
        }
        if (node.right != null) {
            if (pathSum(node.right, targetSum - node.val)) {
                return true;
            }
        }
        return false;
    }


    static int max_path_length = 0;

    public static void longestConsecutive(TreeNode root, int parent, int seqLength) {

        System.out.print("Parent : " + parent + " Child : " + root.val + " SeqLength : " + seqLength);
        if ((parent + 1) == root.val) {
            seqLength += 1;
        } else {
            seqLength = 1;
        }
        max_path_length = Math.max(max_path_length, seqLength);

        if ((root.left == null) && (root.right == null)) {
            return;
        }

        if (root.left != null) {
            longestConsecutive(root.left, root.val, seqLength);
        }
        if (root.right != null) {
            longestConsecutive(root.right, root.val, seqLength);
        }
    }


    static int path_sum = 0;

    public static void pathSumIII(TreeNode root, int target, ArrayList<Integer> slate) {
        int sum = 0;
        slate.add(root.val);
        for (int i = slate.size() - 1; i >= 0; i--) {
            sum += slate.get(i);
            if (sum == target) {
                path_sum++;
                break;
            } else if ((sum + root.val) > target) {
                break;
            }
        }

        if (root.left != null) {
            pathSumIII(root.left, target, slate);
        }
        if (root.right != null) {
            pathSumIII(root.right, target, slate);
        }
        slate.remove(slate.size() - 1);
    }

    public static void sumNumbers(TreeNode node, int slate, ArrayList<Integer> result) {
        if ((node.left == null) && (node.right == null)) {
            if (!result.isEmpty()) {
                result.set(0, result.get(0) + slate + node.val);
            } else {
                result.add(slate + node.val);
            }
            return;
        }

        if (node.left != null) {
            sumNumbers(node.left, slate + node.val, result);
        }
        if (node.right != null) {
            sumNumbers(node.right, slate + node.val, result);
        }
    }

    public static TreeNode invertBinaryTree(TreeNode root) {
        if ((root.left == null) && (root.right == null)) {
            return root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = right;

        if (root.left != null) {
            invertBinaryTree(root.left);
        }
        if (root.right != null) {
            invertBinaryTree(root.right);
        }
        return root;
    }

    public static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if ((root.left == null) && (root.right == null)) {
            return 0;
        }

        int lh = 0;
        int rh = 0;
        if (root.left != null) {
            lh = diameterOfBinaryTree(root.left) + 1;
        }

        if (root.right != null) {
            rh = diameterOfBinaryTree(root.right) + 1;
        }

        diameter = Math.max(diameter, lh + rh);

        return Math.max(lh, rh);
    }


    static TreeNode lcaNode = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) {
            return lcaNode;
        }
        findLCA(root, p, q);
        return lcaNode;
    }

    public static ArrayList<Boolean> findLCA(TreeNode node, int p, int q) {
        ArrayList<Boolean> leftVal = null;
        ArrayList<Boolean> rightVal = null;
        Boolean pFound = false;
        Boolean qFound = false;

        if (node.val == p) pFound = true;
        if (node.val == q) qFound = true;

        if ((node.left == null) && (node.right == null)) {
            return new ArrayList<>(List.of(pFound, qFound));
        }

        if (node.left != null) {
            leftVal = findLCA(node.left, p, q);
        }
        if (node.right != null) {
            rightVal = findLCA(node.right, p, q);
        }


        if ((leftVal.get(0) == true) || (rightVal.get(0) == true)) {
            pFound = true;
        }
        if ((leftVal.get(1) == true) || (rightVal.get(1) == true)) {
            qFound = true;
        }

        if ((pFound == true) && (qFound == true) && (lcaNode == null)) {
            lcaNode = node;
        }

        return new ArrayList<>(List.of(pFound, qFound));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if ((p == null) && (q == null)) {
            return true;
        } else {
            if ((p == null) && (q != null)) {
                return false;
            }
            if ((p != null) && (q == null)) {
                return false;
            }
        }

        if (p.val != q.val) {
            return false;
        }

        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }


    public static boolean isSymmetric(TreeNode root) {
        Queue<ArrayList<TreeNode>> queue = new LinkedList<>();

        queue.add(new ArrayList<>(Arrays.asList(root, root)));

        boolean isSymmetric = true;
        while (!queue.isEmpty()) {

            int qSize = queue.size();

            while (qSize > 0) {
                qSize--;
                ArrayList<TreeNode> node = queue.poll();

                if (node.size() == 2) {
                    TreeNode p = node.get(0);
                    TreeNode q = node.get(1);

                    if ((p == null) && (q == null)) {
                        continue;
                    }
                    if ((p.left != null) && (q.right == null)) {
                        return false;
                    }
                    if ((p.right != null) && (q.left == null)) {
                        return false;
                    }
                    if ((q.left != null) && (p.right == null)) {
                        return false;
                    }
                    if ((q.right != null) && (p.left == null)) {
                        return false;
                    }

                    if (p.val != q.val) {
                        return false;
                    }

                    queue.add(new ArrayList<>(Arrays.asList(p.left, q.right)));
                    queue.add(new ArrayList<>(Arrays.asList(p.right, q.left)));

                } else {
                    return false;
                }
            }

        }
        return isSymmetric;
    }

    public static boolean isSymmetricDFS(TreeNode p, TreeNode q) {

        if ((p == null) && (q == null)) {
            return true;
        } else {
            if ((p != null) && (q == null)) {
                return false;
            }
            if ((p == null) && (q != null)) {
                return false;
            }
        }

        if (p.val != q.val) {
            return false;
        }

        if (!isSymmetricDFS(p.left, q.left)) {
            return false;
        }
        if (!isSymmetricDFS(p.right, q.right)) {
            return false;
        }

        return true;
    }


    static class BstNode {
        boolean isBst;
        int smallest;
        int largest;

        BstNode(boolean isBst, int smallest, int largest) {
            this.isBst = isBst;
            this.smallest = smallest;
            this.largest = largest;
        }
    }

    public static BstNode isValidBst(TreeNode node) {

        if ((node.left == null) && (node.right == null)) {
            return new BstNode(true, node.val, node.val);
        }

        boolean isBst = true;
        int smallest = node.val;
        int largest = node.val;

        if (node.left != null) {
            BstNode leftNode = isValidBst(node.left);
            isBst = leftNode.isBst;
            smallest = Math.min(smallest, leftNode.smallest);
            largest = Math.max(largest, leftNode.largest);

            if (!isBst || leftNode.largest >= node.val) {
                return new BstNode(false, smallest, largest);
            }
        }

        if (node.right != null) {
            BstNode rightNode = isValidBst(node.right);
            isBst = rightNode.isBst;
            smallest = Math.min(smallest, rightNode.smallest);
            largest = Math.max(largest, rightNode.largest);

            if (!isBst || rightNode.smallest <= node.val) {
                return new BstNode(false, smallest, largest);
            }
        }
        return new BstNode(true, smallest, largest);
    }


    public static void updateMap(Map<Integer, List<Integer>> map, TreeNode node, int x) {
        if (map.containsKey(x)) {
            map.get(x).add(node.val);
        } else {
            map.put(x, new ArrayList<>(List.of(node.val)));
        }
    }

    public static List<List<Integer>> verticalOrderTraversal(TreeNode root, int x) {

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        q.add(new Pair(root, x));

        while (!q.isEmpty()) {

            Pair pair = q.poll();
            updateMap(map, pair.node, pair.x);

            if (pair.node.left != null) {
                q.add(new Pair(pair.node.left, pair.x - 1));
            }

            if (pair.node.right != null) {
                q.add(new Pair(pair.node.right, pair.x + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        map.values().forEach(list -> {
            Collections.sort(list);
            result.add(list);
        });
        return result;
    }

    static int max_path_sum = Integer.MIN_VALUE;

    public static int longestPathMaximumSum(TreeNode root) {
        if ((root.left == null) && (root.right == null)) {
            max_path_sum = Math.max(max_path_sum, root.val);
            return root.val;
        }

        int leftSum = 0;
        int rightSum = 0;

        if (root.left != null) {
            leftSum = Math.max(0, longestPathMaximumSum(root.left));
        }

        if (root.right != null) {
            rightSum = Math.max(0, longestPathMaximumSum(root.right));
        }

        max_path_sum = Math.max(max_path_sum, leftSum + root.val + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }


    public static void kthSmallestNumber(TreeNode node, ArrayList<Integer> result) {
        if ((node.left == null) && (node.right == null)) {
            result.add(node.val);
            return;
        }

        if (node.left != null) {
            kthSmallestNumber(node.left, result);
        }

        result.add(node.val);

        if (node.left != null) {
            kthSmallestNumber(node.right, result);
        }
    }


    public static int getMinimumDiff(TreeNode node, ArrayList<Integer> result) {

        getMinimumDifference(node, result);
        System.out.println(" ===> " + result.toString());
        int min = 0;
        if (result.size() > 1) {
            min = result.get(1) - result.get(0);
        }
        for (int i = 1; i < result.size(); i++) {
            Math.min(min, result.get(i) - result.get(i - 1));
        }
        return min;
    }

    public static void getMinimumDifference(TreeNode node, ArrayList<Integer> result) {
        if ((node.left == null) && (node.right == null)) {
            result.add(node.val);
            return;
        }
        if (node.left != null) {
            getMinimumDifference(node.left, result);
        }

        result.add(node.val);

        if (node.right != null) {
            getMinimumDifference(node.right, result);
        }
    }


    public static TreeNode flattenTree(TreeNode node) {
        if ((node.left == null) && (node.right == null)) {
            return node;
        }

        TreeNode lTemp = null;
        TreeNode rTemp = null;
        if (node.left != null) {
            lTemp = flattenTree(node.left);
        }
        if (node.right != null) {
            rTemp = flattenTree(node.right);
        }

        if (lTemp != null) {
            node.right = lTemp;
            lTemp.right = rTemp;
            node.left = null;
        }
        return node;
    }

    public static TreeNode createBst(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = createBst(nums, start, mid - 1);
        node.right = createBst(nums, mid + 1, end);

        return node;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return createBst(nums, 0, nums.length - 1);
    }

    public static TreeNode merge(int[] inOrder, int[] preOrder, int inStart, int inEnd, int preStart, int preEnd) {

        if (inEnd == inStart) {
            return new TreeNode(preOrder[preStart]);
        }

        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preStart]);

        int k = inOrderIndexMap.get(preOrder[preStart]);

        int numLeft = k - inStart;
        int numRight = inEnd - k;

        node.left = merge(inOrder, preOrder, inStart, k - 1, preStart + 1, preStart + numLeft);
        node.right = merge(inOrder, preOrder, k + 1, inEnd, preStart + numLeft + 1, numRight);

        return node;

    }

    static Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    public static TreeNode buildTreeFromPreOrder(int[] preOrder, int[] inOrder) {

        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }

        return merge(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);

    }


    public static TreeNode mergePostOrder(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {

        if (postEnd < 0) {
            return null;
        }

        if(inStart > inEnd) {
            return null;
        }

        if (inEnd == inStart) {
            return new TreeNode(postOrder[postEnd]);
        }


        TreeNode node = new TreeNode(postOrder[postEnd]);

        int k = inOrderIndexMap_.get(postOrder[postEnd]);

        int numLeft = k - inStart;
        int numRight = inEnd - k;

        node.left = mergePostOrder(inOrder, postOrder, inStart, k - 1, postStart, postStart + numLeft - 1);
        node.right = mergePostOrder(inOrder, postOrder, k + 1, inEnd, postEnd - numRight, postEnd -1);

        return node;

    }

    static Map<Integer, Integer> inOrderIndexMap_ = new HashMap<>();

    public static TreeNode buildTreeFromPostOrder(int[] postOrder, int[] inOrder) {

        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap_.put(inOrder[i], i);
        }

        return mergePostOrder(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);

    }


    public static void main(String[] args) {

        TreeNode head = null;


        head = insertBST(head, 4);
        head = insertBST(head, 2);
        head = insertBST(head, 7);
        head = insertBST(head, 6);
        head = insertBST(head, 1);
        head = insertBST(head, 3);

        print(head);

        /*
        maxDepth(head, 0);
        System.out.println(max_depth);
        System.out.println(rightSideView(head).toString());
        System.out.println(averageLevels(head).toString());
         */

        printALlPaths(head, "");
        /*
        System.out.println(pathSum(head, 60));

        longestConsecutive(head, head.val, 0);
        System.out.println(" LCM : " + max_path_length);
        ArrayList<Integer> result = new ArrayList<>();
        sumNumbers(head, 0, result);
        System.out.println(result.get(0));
         */

        /*
        pathSumIII(head, 5, new ArrayList<>());
        System.out.println(path_sum);
        print(head);
        System.out.println(levelOrderTraversal(head).toString());
        head = invertBinaryTree(head);
        System.out.println(levelOrderTraversal(head).toString());
        print(head);

        diameterOfBinaryTree(head);
        System.out.println("Diameter : ");
        System.out.println(diameter);

        lowestCommonAncestor(head, 1, 9);
        System.out.println(lcaNode.val);



         */

        TreeNode head2 = null;
        head2 = insertBST(head2, 384);
        head2 = insertBST(head2, 445);
        head2 = insertBST(head2, 543);
        head2 = insertBST(head2, 652);
        head2 = insertBST(head2, 699);

        //System.out.println(isSameTree(head, head2));
        //System.out.println(isSymmetric(head));

        //System.out.println(isSymmetricDFS(head, head2));

        BstNode node = isValidBst(head);
        System.out.println("isBst : " + node.isBst + " smallest : " + node.smallest + " largest : " + node.largest);

        System.out.println(verticalOrderTraversal(head, 0));

        max_path_sum = head2.val;
        longestPathMaximumSum(head2);
        System.out.println(max_path_sum);

        ArrayList<Integer> result = new ArrayList<>();
        //kthSmallestNumber(head, result);
        //System.out.println(result.get(2 - 1));

        System.out.println(getMinimumDiff(head2, result));

        System.out.println(flattenTree(head));
        print(head);

        int a[] = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(a);
        System.out.println(" Printing BST Converted from Sorted Array :");
        print(root);

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode inode = buildTreeFromPreOrder(preorder, inorder);
        System.out.println("Inode : ");
        print(inode);

        int[] postOrder = {9, 15, 7, 20, 3};

        TreeNode post = buildTreeFromPostOrder(postOrder, inorder);
        System.out.println("P Inode : ");
        print(post);


    }


}
