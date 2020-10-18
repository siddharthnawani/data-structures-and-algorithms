package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/diameter-of-binary-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of diameter1 function. The function is expected to return the number of edges between two nodes which are farthest from each other in terms of edges.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * Sample Output
 * 6
 **/
public class DiameterOfABinaryTree {


    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static int diameter1(Node node) {
        if (node == null) {
            return 0;
        }

        int ld = diameter1(node.left);
        int rd = diameter1(node.right);
        int f = height(node.left) + height(node.right) + 2;

        int dia = Math.max(f, Math.max(ld, rd));

        return dia;

    }

    static class DiaPair {
        int dia;
        int ht;
    }

    static DiaPair diameter2(Node node) {

        if (node == null) {
            DiaPair bp = new DiaPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }

        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();

        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        int f = lp.ht + rp.ht + 2;

        mp.dia = Math.max(f, Math.max(lp.dia, rp.dia));

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

        int diameter = 0;
        diameter = diameter1(root);
        System.out.println(diameter);

        DiaPair d = diameter2(root);
        System.out.println(d.dia);


    }
}
