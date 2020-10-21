package src.com.sid.tree.binarySearchTree;

import src.com.sid.tree.binaryTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/add-node-to-bst-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BST class.
 * 2. You are required to complete the body of add function. "add" function is expected to add a new node with given data to the tree and return the new root.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 23
 * 50 25 12 n n 37 30 n n 40 n n 75 62 60 n n 70 n n 87 n n
 * 61
 * Sample Output
 * 25 <- 50 -> 75
 * 12 <- 25 -> 37
 * . <- 12 -> .
 * 30 <- 37 -> 40
 * . <- 30 -> .
 * . <- 40 -> .
 * 62 <- 75 -> 87
 * 60 <- 62 -> 70
 * . <- 60 -> 61
 * . <- 61 -> .
 * . <- 70 -> .
 * . <- 87 -> .
 **/
public class AddNodeToBst {

    public static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data, null, null);
        }
        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        } else {
            //its same just return it upstrea,
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
        root = add(root, data);

        Node.display(root);
    }
}
