package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/remove-leaves-binary-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of removeLeaves function. The function is expected to remove all leaf nodes from the tree.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * Sample Output
 * 25 <- 50 -> 75
 * . <- 25 -> 37
 * . <- 37 -> .
 * 62 <- 75 -> .
 * . <- 62 -> .
 **/
public class RemoveLeavesInBinaryTree {

    public static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

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

        Node root = Node.construct(arr);
        root = removeLeaves(root);
        Node.display(root);
    }
}
