package src.com.sid.tree.genericTree.travelAndChange;

import src.com.sid.tree.genericTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/ceil-and-floor-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to find the ceil and floor value of a given element. Use the "travel and change" strategy explained in the earlier video. The static properties - ceil and floor have been declared for you. You can declare more if you want. If the element is largest ceil will be largest integer value (32 bits), if element is smallest floor will be smallest integer value (32 bits). Watch the question video for clarity.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 24
 * 10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
 * 70
 * Sample Output
 * CEIL = 90
 * FLOOR = 60
 **/
public class CeilAndFloorInGenericTree {

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
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        ceilAndFloor(root, data);
        System.out.println("CEIL = " + ceil);
        System.out.println("FLOOR = " + floor);
    }
}
