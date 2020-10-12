package src.com.sid.tree.genericTree.travelAndChange;

import src.com.sid.tree.genericTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/kth-largest-element-generic-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are given a number k. You are required to find and print the kth largest value in the tree.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 24
 * 10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
 * 8
 * Sample Output
 * 10
 **/
public class KthLargestElementInTree {

    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }

        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }

        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k) {
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            ceilAndFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }

        return factor;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int k = Integer.parseInt(br.readLine());

        Node root = Node.construct(arr);
        int kthLargest = kthLargest(root, k);
        System.out.println(kthLargest);
    }
}
