package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/levelorder-binarytree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of levelorder function. The function is expected to print tree level by level, left to right. Each level must be on a separate line and elements of same level should be separated by space
 * 3. Input is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * Sample Output
 * 50
 * 25 75
 * 12 37 62 87
 * 30 70
 **/
public class LevelorderTraversal {

    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }
            System.out.println();
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

        Node root = Node.construct(arr);
        levelOrder(root);
    }
}
