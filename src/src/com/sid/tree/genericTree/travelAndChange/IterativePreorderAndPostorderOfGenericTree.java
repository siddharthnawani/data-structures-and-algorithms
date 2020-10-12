package src.com.sid.tree.genericTree.travelAndChange;

import src.com.sid.tree.genericTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/iterative-preorder-postorder-generic-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.
 * 3. Input and Output is managed for you.
 * <p>
 * Sample Input
 * 24
 * 10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
 * Sample Output
 * 10 20 -50 60 30 70 -80 110 -120 90 40 -100
 * -50 60 20 70 110 -120 -80 90 30 -100 40 10
 **/
public class IterativePreorderAndPostorderOfGenericTree {
    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(node, -1));

        String pre = "";
        String post = "";
        while (s.size() > 0) {
            Pair top = s.peek();

            if (top.state == -1) {
                pre += top.node.data + " ";
                top.state++;
            } else if (top.state == top.node.children.size()) {
                post += top.node.data + " ";
                s.pop();
            } else {
                s.push(new Pair(top.node.children.get(top.state), -1));
                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = Node.construct(arr);
        IterativePreandPostOrder(root);
    }
}
