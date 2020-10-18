package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/is-balanced-binary-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to check if the tree is balanced. A binary tree is balanced if for every node the gap between height's of it's left and right subtree is not more than 1.
 * 3. Input is managed for you.
 * <p>
 * Sample Input
 * 21
 * 50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n n
 * Sample Output
 * false
 **/
public class IsBalancedTree {
    static boolean isBal = true;

    static int isBalanced(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);

        int gap = Math.abs(lh - rh);
        if (gap > 1) {
            isBal = false;
        }

        int ht = Math.max(lh, rh) + 1;
        return ht;
    }

    static class BalPair {
        int ht;
        boolean isBal;
    }

    static BalPair isBal(Node node) {
        if (node == null) {
            BalPair bp = new BalPair();
            bp.ht = 0;
            bp.isBal = true;
            return bp;
        }


        BalPair lp = isBal(node.left);
        BalPair rp = isBal(node.right);

        BalPair mp = new BalPair();
        mp.isBal = Math.abs(lp.ht - rp.ht) <= 1 && lp.isBal && rp.isBal;

        mp.ht = Math.max(lp.ht, rp.ht) + 1;

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
        isBalanced(root);
        System.out.println(isBal);


        BalPair p = isBal(root);
        System.out.println(p.isBal);
    }
}
