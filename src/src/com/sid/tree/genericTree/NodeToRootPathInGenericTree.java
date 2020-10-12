package src.com.sid.tree.genericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/node-to-root-path-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to complete the body of nodeToRootPath function. The function is expected to return in form of linked list the path from element to root, if the element with data is found.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 24
 * 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
 * 120
 * Sample Output
 * [120, 80, 30, 10]
 **/
public class NodeToRootPathInGenericTree {

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(data);
            return list;
        }

        for (Node child : node.children) {
            ArrayList<Integer> listTillChild = nodeToRootPath(child, data);
            if (!listTillChild.isEmpty()) {
                listTillChild.add(node.data);
                return listTillChild;
            }
        }

        return new ArrayList<>();


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = Node.construct(arr);
        ArrayList<Integer> path = nodeToRootPath(root, data);
        System.out.println(path);
        // display(root);
    }
}
