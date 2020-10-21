package src.com.sid.tree.binarySearchTree;

import src.com.sid.tree.binaryTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/pir-bst-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BST class.
 * 2. You are required to complete the body of pir function. "pir" function is expected to print all nodes between d1 and d2 (inclusive and in increasing order).
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 21
 * 50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
 * 12
 * 65
 * Sample Output
 * 12
 * 25
 * 30
 * 37
 * 50
 * 60
 * 62
 **/
public class PrintInRange {

    public static void pir(Node node, int d1, int d2) {
        if (node == null) {
            return;
        }
        if (d1 < node.data && d2 < node.data) {
            pir(node.left, d1, d2);
        } else if (d1 > node.data && d2 > node.data) {
            pir(node.right, d1, d2);
        } else {
            //in range
            //inorder since we have to print in increasing order
            pir(node.left, d1, d2);
            System.out.println(node.data);
            pir(node.right, d1, d2);

        }
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

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        Node root = Node.construct(arr);
        pir(root, d1, d2);
    }
}
