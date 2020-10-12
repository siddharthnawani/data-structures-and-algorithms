package src.com.sid.tree.genericTree.travelAndChange;

import src.com.sid.tree.genericTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/node-with-maximum-subtree-sum-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to find and print the node which has the subtree with largest sum. Also print the sum of the concerned subtree separated from node's value by an '@'. Refer the question video for clarity.
 * 3. Input is managed for you.
 * <p>
 * Sample Input
 * 20
 * 10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
 * Sample Output
 * 30@130
 **/
public class NodeWithMaximumSubtreeSum {

    static int msn = 0;
    static int ms = Integer.MIN_VALUE;

    public static int retSumAndCalcMSS(Node node) {
        int sum = 0;

        for (Node child : node.children) {
            sum += retSumAndCalcMSS(child);
        }

        sum += node.data;

        if (sum > ms) {
            ms = sum;
            msn = node.data;
        }

        return sum;
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
        retSumAndCalcMSS(root);
        System.out.println(msn + "@" + ms);
        // write your code here
    }
}
