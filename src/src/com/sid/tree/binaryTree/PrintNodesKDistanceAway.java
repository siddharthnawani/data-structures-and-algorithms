package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/print-nodes-k-away-binary-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are given a value data and a value k.
 * 3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
 * 4. Input is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * 37
 * 2
 * Sample Output
 * 12
 * 50
 **/
public class PrintNodesKDistanceAway {

    //path from root to node
    static ArrayList<Node> path = new ArrayList<>();

    public static boolean printRootToNodePath(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path.add(node);
            return true;
        }

        boolean lt = printRootToNodePath(node.left, data);
        if (lt) {
            path.add(node);
            return true;
        }
        boolean rt = printRootToNodePath(node.right, data);
        if (rt) {
            path.add(node);
            return true;
        }

        return false;

    }


    //print elements which are at dostance of k

    static void printKlevel(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKlevel(node.left, k - 1, blocker);
        printKlevel(node.right, k - 1, blocker);


    }

    public static void printKNodesFar(Node node, int data, int k) {
        printRootToNodePath(node, data);
        for (int i = 0; i < path.size(); i++) {
            printKlevel(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
        }
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

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = Node.construct(arr);
        printKNodesFar(root, data, k);
    }
}
