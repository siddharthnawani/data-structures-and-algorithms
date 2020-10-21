package src.com.sid.tree.binarySearchTree;

import src.com.sid.tree.binaryTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/replace-with-sum-of-larger-official/ojquestion#
 *
 *Question
 * 1. You are given a partially written BST class.
 * 2. You are required to complete the body of rwsol function. "rwsol" function is expected to replace a node's value with sum of all nodes greater than it.
 * 3. Input and Output is managed for you.
 *
 * Sample Input
 * 15
 * 50 25 12 n n 37 n n 75 62 n n 87 n n
 * Sample Output
 * 311 <- 224 -> 87
 * 336 <- 311 -> 274
 * . <- 336 -> .
 * . <- 274 -> .
 * 162 <- 87 -> 0
 * . <- 162 -> .
 * . <- 0 -> .
 *
 * **/
public class ReplaceWithSumOfLarger {

    static int sum = 0;
    public static void rwsol(Node node){
        if(node == null){
            return;
        }
        /**
         *The idea os to do a reverse in order to get the sum in
         * decresing order
         *
         **/
        rwsol(node.right);
        int tmp=node.data;
        node.data = sum;
        sum += tmp;
        rwsol(node.left);

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
        rwsol(root);

        Node.display(root);
    }
}
