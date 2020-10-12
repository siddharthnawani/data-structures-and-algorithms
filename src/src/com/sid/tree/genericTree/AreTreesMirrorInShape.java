package src.com.sid.tree.genericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/are-trees-mirror-in-shape-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to complete the body of areMirror function. The function is expected to check if the two trees passed to it are mirror images of each other in shape (data not to be checked, just the shape of tree).
 * Note -> Watch the question video for clarity.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 12
 * 10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
 * 12
 * 100 200 -1 300 500 -1 600 -1 -1 400 -1 -1
 * Sample Output
 * true
 **/
public class AreTreesMirrorInShape {


    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            int j = n2.children.size() - 1 - i;

            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);

            if (areMirror(c1, c2) == false) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n1];
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(values1[i]);
        }
        Node root1 = Node.construct(arr1);

        int n2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[n2];
        String[] values2 = br.readLine().split(" ");
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(values2[i]);
        }
        Node root2 = Node.construct(arr2);

        boolean mirror = areMirror(root1, root2);
        System.out.println(mirror);
    }
}
