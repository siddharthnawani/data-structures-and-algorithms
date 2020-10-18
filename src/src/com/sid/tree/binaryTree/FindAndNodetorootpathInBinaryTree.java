package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/find-nodetorootpath-binary-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are given an element.
 * 3. You are required to complete the body of find and nodeToRoot function. The functions are expected to
 * 3.1. find -> return true or false depending on if the data is found in binary tree.
 * 3.2. nodeToRoot -> returns the path from node (correspoding to data) to root in
 * form of an arraylist (root being the last element)
 * 4. Input iand Output is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * 30
 * Sample Output
 * true
 * [30, 37, 25, 50]
 **/
public class FindAndNodetorootpathInBinaryTree {

    static ArrayList<Integer> path = new ArrayList<>();

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            path.add(node.data);
            return true;
        }
        boolean leftTree = find(node.left, data);
        if (leftTree) {
            path.add(node.data);
            return true;
        }
        boolean rightTree = find(node.right, data);
        if (rightTree) {
            path.add(node.data);
            return true;
        }
        return false;
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

        Node root = Node.construct(arr);
        boolean found = find(root, data);
        System.out.println(found);
        System.out.println(path);
    }
}
