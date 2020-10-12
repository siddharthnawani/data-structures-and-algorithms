package src.com.sid.tree.genericTree.travelAndChange;

import src.com.sid.tree.genericTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/pred-succ-generic-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to find the preorder predecessor and successor of a given element. Use the "travel and change" strategy explained in the earlier video. The static properties have been declared for you. You can declare more if you want.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 24
 * 10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
 * -120
 * Sample Output
 * Predecessor = 110
 * Successor = 90
 **/
public class PredecessorAndSuccessorOfAnElement {

    static Node predecessor;
    static Node successor;
    static int state = 0;

    public static void predecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            state = 2;
            successor = node;
        }

        for (Node child : node.children) {
            predecessorAndSuccessor(child, data);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = Node.construct(arr);
        predecessor = null;
        successor = null;
        predecessorAndSuccessor(root, data);
        if (predecessor == null) {
            System.out.println("Predecessor = Not found");
        } else {
            System.out.println("Predecessor = " + predecessor.data);
        }

        if (successor == null) {
            System.out.println("Successor = Not found");
        } else {
            System.out.println("Successor = " + successor.data);
        }
    }
}
