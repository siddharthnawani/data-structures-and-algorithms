package src.com.sid.tree.genericTree.travelAndChange;

import src.com.sid.tree.genericTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/diameter-of-generic-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree. Check the question video for clarity.
 * 3. Input is managed for you.
 * <p>
 * Sample Input
 * 20
 * 10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
 * Sample Output
 * 4
 **/
public class DiameterOfGenericTree {

    static int dia = 0;

    public static int calculateDiaAndReturnHeight(Node node) {
        int ht = -1;
        int sdch = -1;

        for (Node child : node.children) {
            int ch = calculateDiaAndReturnHeight(child);
            if (ch > ht) {
                sdch = ht;
                ht = ch;
            } else if (ch > sdch) {
                sdch = ch;
            }
        }

        if (ht + sdch + 2 > dia) {
            dia = ht + sdch + 2;
        }

        //update height to include current  element

        return ht + 1;
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
        calculateDiaAndReturnHeight(root);
        System.out.println(dia);
        // write your code here
    }
}
