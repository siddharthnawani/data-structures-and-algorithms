package src.com.sid.tree.genericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/are-generic-trees-similar-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to complete the body of areSimilar function. The function is expected to check if the two trees passed to it are similar in shape or not.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 24
 * 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
 * 24
 * 1 2 5 -1 6 -1 -1 3 7 -1 8 11 -1 12 -1 -1 9 -1 -1 4 10 -1 -1 -1
 * Sample Output
 * true
 **/
public class AreTreesSimilarInShape {


    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if (areSimilar(c1, c2) == false) {
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

        boolean similar = areSimilar(root1, root2);
        System.out.println(similar);
    }
}
