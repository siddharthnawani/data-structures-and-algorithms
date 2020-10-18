package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/largest-bst-subtree-official/ojquestion#
 *
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
 * 3. Input is managed for you.
 *
 * Sample Input
 * 15
 * 50 25 12 n n 37 n n 75 62 n n 87 n n
 * Sample Output
 * 50@7
 *
 * */
public class LargestBstSubtree {
    static class BSTPair {
        boolean isBST;
        int min;
        int max;
        Node root;
        int size;
    }

    static BSTPair isBST(Node node) {

        if (node == null) {
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.root = null;
            bp.size = 0;
            return bp;
        }

        BSTPair lt = isBST(node.left);
        BSTPair rt = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lt.isBST && rt.isBST &&
                (node.data >= lt.max && node.data <= rt.min);

        mp.min = Math.min(node.data, Math.min(lt.min, rt.min));
        mp.max = Math.max(node.data, Math.max(lt.max, rt.max));

        if (mp.isBST) {
            mp.root = node;
            mp.size = lt.size + rt.size + 1;
        } else if (lt.size > rt.size) {
            mp.root = lt.root;
            mp.size = lt.size;
        } else {
            mp.root = rt.root;
            mp.size = rt.size;
        }

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
        System.out.println(p.root.data + "@" + p.size);
        // write your code here
    }
}
