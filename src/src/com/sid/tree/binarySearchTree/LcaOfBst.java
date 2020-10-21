package src.com.sid.tree.binarySearchTree;

import src.com.sid.tree.binaryTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/lca-bst-official/ojquestion#
 *
 * Question
 * 1. You are given a partially written BST class.
 * 2. You are required to complete the body of lca function. "lca" function is expected to find the lowest commong ancestor of d1 and d2.
 * 3. Input and Output is managed for you.
 *
 * Sample Input
 * 21
 * 50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
 * 12
 * 30
 * Sample Output
 * 25
 *
 * */
public class LcaOfBst {
    public static int lca(Node node, int d1, int d2) {
        if (d1 > node.data && d2 > node.data) {
            return lca(node.right, d1, d2);
        } else if (d1 < node.data && d2 < node.data) {
            return lca(node.left, d1, d2);
        } else {
            return node.data;
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
        int lca = lca(root, d1, d2);
        System.out.println(lca);
    }
}
