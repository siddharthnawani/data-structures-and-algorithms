package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/print-single-child-nodes-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of printSingleChildNodes function. The function is expected to print in separate lines, all such nodes which are only child of their parent. Use preorder for traversal.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * Sample Output
 * 30
 * 70
 **/
public class PrintSingleChildNodes {

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null) {
            return;
        }

        if (parent != null && ((parent.left == node && parent.right == null)
                || (parent.left == null && parent.right == node))) {
            System.out.println(node.data);
        }


        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);


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
        printSingleChildNodes(root, null);
    }
}
