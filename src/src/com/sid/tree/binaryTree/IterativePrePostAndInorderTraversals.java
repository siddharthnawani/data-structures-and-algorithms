package src.com.sid.tree.binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

import static src.com.sid.tree.binaryTree.Node.construct;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/iterative-pre-post-in-binary-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BinaryTree class.
 * 2. You are required to complete the body of iterativePrePostInTraversal function. The function is expected to print pre order, in order and post order of the tree in separate lines (first pre, then in and finally post order). All elements in an order must be separated by a space.
 * 3. Input is managed for you.
 * <p>
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * <p>
 * <p>
 * Sample Output
 * 50 25 12 37 30 75 62 70 87
 * 12 25 30 37 50 62 70 75 87
 * 12 30 37 25 70 62 87 75 50
 ***/
public class IterativePrePostAndInorderTraversals {


    public static void iterativePrePostInTraversal(Node node) {
        Stack<Node.Pair> st = new Stack<>();
        st.push(new Node.Pair(node, 1));

        String pre = "", in = "", post = "";

        while (st.size() > 0) {
            Node.Pair top = st.peek();
            if (top.state == 1) {
                top.state++;
                pre += top.node.data + " ";

                if (top.node.left != null) {
                    st.push(new Node.Pair(top.node.left, 1));
                }
            } else if (top.state == 2) {
                top.state++;
                in += top.node.data + " ";

                if (top.node.right != null) {
                    st.push(new Node.Pair(top.node.right, 1));
                }
            } else {
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

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

        Node root = construct(arr);
        iterativePrePostInTraversal(root);
    }
}
