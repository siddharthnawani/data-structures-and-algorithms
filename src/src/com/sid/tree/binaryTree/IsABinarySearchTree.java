package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/is-bst-official/ojquestion#
 *
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to check if the tree is a Binary Search Tree (BST) as well. In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
 * 3. Input is managed for you.
 *
 * Sample Input
 * 15
 * 50 25 12 n n 37 n n 75 62 n n 87 n n
 * Sample Output
 * true
 *
 * **/
public class IsABinarySearchTree {

    static class BSTPair {
        boolean isBST;
        int min;
        int max;
    }

    static BSTPair isBST(Node node) {

        if (node == null) {
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            return bp;
        }

        BSTPair lt = isBST(node.left);
        BSTPair rt = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lt.isBST && rt.isBST &&
                (node.data >= lt.max && node.data <= rt.min);

        mp.min = Math.min(node.data, Math.min(lt.min, rt.min));
        mp.max = Math.max(node.data, Math.max(lt.max, rt.max));

        return mp;
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
        BSTPair p = isBST(root);
        System.out.println(p.isBST);
        // write your code here
    }
}
