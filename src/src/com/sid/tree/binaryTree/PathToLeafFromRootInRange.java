package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/binary-tree-path-to-leaves-from-root-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are given a value lo and a value hi
 * 3. You are required to complete the body of pathToLeafFromRoot function. The function is expected to print all paths from root to leaves which have sum of nodes in range from lo to hi (both inclusive). The elements in path should be separated by spaces. Each path should be in a separate line.
 * 4. Input is managed for you.
 * <p>
 * Sample Input
 * 23
 * 50 25 12 n n 37 30 n n 40 n n 75 62 60 n n 70 n n 87 n n
 * 150
 * 250
 * Sample Output
 * 50 25 37 40
 * 50 75 62 60
 * 50 75 87
 **/
public class PathToLeafFromRootInRange {
    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += node.data;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);

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

        int lo = Integer.parseInt(br.readLine());
        int hi = Integer.parseInt(br.readLine());

        Node root = Node.construct(arr);
        pathToLeafFromRoot(root, "", 0, lo, hi);
    }
}
