package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/size-sum-max-height-binarytree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of size, sum, max and height function. The functions are expected to
 * 2.1. size - return the number of nodes in BinaryTree
 * 2.2. sum - return the sum of nodes in BinaryTree
 * 2.3. max - return the highest node in BinaryTree
 * 2.4. height - return the height of tree in terms of edges
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * Sample Output
 * 9
 * 448
 * 87
 * 3
 **/
public class SizeSumMaximumAndHeight {


    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if (node == null)
            return 0;

        int ls = size(node.left);
        int rs = size(node.right);

        return ls + rs + 1;
    }

    public static int sum(Node node) {
        if (node == null)
            return 0;

        int ls = sum(node.left);
        int rs = sum(node.right);

        return ls + rs + node.data;
    }

    public static int max(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int lm = max(node.left);
        int rm = max(node.right);

        return Math.max(node.data, Math.max(lm, rm));
    }

    public static int height(Node node) {
        if (node == null)
            return -1;

        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = Node.construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }
}
