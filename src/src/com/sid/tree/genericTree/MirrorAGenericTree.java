package src.com.sid.tree.genericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/mirror-generic-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to complete the body of mirror function. The function is expected to create a mirror image of the tree. For more details, check out the question video.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 24
 * 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
 * Sample Output
 * 10 -> 20, 30, 40, .
 * 20 -> 50, 60, .
 * 50 -> .
 * 60 -> .
 * 30 -> 70, 80, 90, .
 * 70 -> .
 * 80 -> 110, 120, .
 * 110 -> .
 * 120 -> .
 * 90 -> .
 * 40 -> 100, .
 * 100 -> .
 * 10 -> 40, 30, 20, .
 * 40 -> 100, .
 * 100 -> .
 * 30 -> 90, 80, 70, .
 * 90 -> .
 * 80 -> 120, 110, .
 * 120 -> .
 * 110 -> .
 * 70 -> .
 * 20 -> 60, 50, .
 * 60 -> .
 * 50 -> .
 **/
public class MirrorAGenericTree {

    public static void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = Node.construct(arr);
        Node.display(root);
        mirror(root);
        Node.display(root);
    }
}
