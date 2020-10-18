package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/transform-to-left-cloned-tree-official/ojquestion#
 *
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of createLeftCloneTree function. The function is expected to create a new node for every node equal in value to it and inserted between itself and it's left child. Check question video for clarity.
 * 3. Input and Output is managed for you.
 *
 * Sample Input
 * 15
 * 50 25 12 n n 37 n n 75 62 n n 87 n n
 * Sample Output
 * 50 <- 50 -> 75
 * 25 <- 50 -> .
 * 25 <- 25 -> 37
 * 12 <- 25 -> .
 * 12 <- 12 -> .
 * . <- 12 -> .
 * 37 <- 37 -> .
 * . <- 37 -> .
 * 75 <- 75 -> 87
 * 62 <- 75 -> .
 * 62 <- 62 -> .
 * . <- 62 -> .
 * 87 <- 87 -> .
 * . <- 87 -> .
 *
 * */
public class TransformToLeftclonedTree {

    public static Node createLeftCloneTree(Node node) {
        if (node == null) {
            return null;
        }
        Node lc = createLeftCloneTree(node.left);
        Node rc = createLeftCloneTree(node.right);

        Node nn = new Node(node.data, lc, null);
        node.left = nn;
        node.right = rc;

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
        root = createLeftCloneTree(root);
        Node.display(root);
    }
}
