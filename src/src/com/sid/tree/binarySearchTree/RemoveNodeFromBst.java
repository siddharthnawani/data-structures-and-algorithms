package src.com.sid.tree.binarySearchTree;

import src.com.sid.tree.binaryTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/remove-node-in-bst-official/ojquestion#
 *
 * Question
 * 1. You are given a partially written BST class.
 * 2. You are required to complete the body of remove function. "remove" function is expected to remove a new node with given data to the tree and return the new root.
 * 3. Input and Output is managed for you.
 *
 * Note -> Please watch the question video to figure out the algorithm required for deletion. It specifies some requirements of the question as well.
 *
 * Sample Input
 * 15
 * 50 25 12 n n 37 n n 75 62 n n 87 n n
 * 62
 * Sample Output
 * 25 <- 50 -> 75
 * 12 <- 25 -> 37
 * . <- 12 -> .
 * . <- 37 -> .
 * . <- 75 -> 87
 * . <- 87 -> .
 *
 * */
public class RemoveNodeFromBst {
    public static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        }
        return node.data;
    }

    public static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            //3 cases - 0 child , 1 child & 2 child
            if (node.left != null && node.right != null) {
                //get mac from left and replace it with node and then delete max from left
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                //when both are null
                return null;
            }
        }

        return node;

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

        int data = Integer.parseInt(br.readLine());

        Node root = Node.construct(arr);
        root = remove(root, data);

        Node.display(root);
    }
}
