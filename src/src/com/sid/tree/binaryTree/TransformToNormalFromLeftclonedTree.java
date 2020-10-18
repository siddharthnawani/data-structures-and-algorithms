package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/transform-to-normal-from-left-cloned-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of transBackFromLeftClonedTree function. The function is expected to convert a left-cloned tree back to it's original form. The left cloned tree is dicussed in previous question. In a left-clone tree a new node for every node equal in value to it is inserted between itself and it's left child. For clarity check out the question video.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 37
 * 50 50 25 25 12 12 n n n n 37 37 30 30 n n n n n n 75 75 62 62 n n 70 70 n n n n 87 87 n n n
 * Sample Output
 * 25 <- 50 -> 75
 * 12 <- 25 -> 37
 * . <- 12 -> .
 * 30 <- 37 -> .
 * . <- 30 -> .
 * 62 <- 75 -> 87
 * . <- 62 -> 70
 * . <- 70 -> .
 * . <- 87 -> .
 **/
public class TransformToNormalFromLeftclonedTree {

    public static Node transBackFromLeftClonedTree(Node node) {

        if (node == null) {
            return null;
        }

        Node lnn = transBackFromLeftClonedTree(node.left.left);
        Node rnn = transBackFromLeftClonedTree(node.right);

        node.left = lnn;
        node.right = rnn;

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
        root = transBackFromLeftClonedTree(root);
        Node.display(root);
    }
}
