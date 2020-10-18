package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/tilt-of-binary-tree/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of tilt function. The function is expected to set the value of data member "tilt". "tilt" of a node is the absolute value of difference between sum of nodes in it's left subtree and right subtree. "tilt" of the whole tree is represented as the sum of "tilt"s of all it's nodes.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * Sample Output
 * 390
 **/
public class TiltOfBinaryTree {
    static int tilt = 0;

    public static int tilt(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = tilt(node.left);
        int rs = tilt(node.right);

        int localTilt = Math.abs(ls - rs);

        tilt += localTilt;

        return ls + rs + node.data;


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

        tilt(root);
        System.out.println(tilt);
    }
}
