package src.com.sid.tree.binarySearchTree;

import src.com.sid.tree.binaryTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/size-sum-max-min-find-in-bst-official/ojquestion#
 *
 * Question
 * 1. You are given a partially written BST class.
 * 2. You are required to complete the body of size, sum, max, min and find function. The functions are expected to:
 *     2.1. size - return the number of nodes in BST
 *     2.2. sum - return the sum of nodes in BST
 *     2.3. max - return the value of node with greatest value in BST
 *     2.4. min - return the value of node with smallest value in BST
 *     2.5. find - return true if there is node in the tree equal to "data"
 * 3. Input and Output is managed for you.
 *
 * Sample Input
 * 19
 * 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 * 70
 * Sample Output
 * 9
 * 448
 * 87
 * 12
 * true
 *
 *
 *
 * **/
public class SizeSumMaxMinFind {

    public static int size(Node node) {
        if(node ==null){
            return 0;
        }
        int ls=size(node.left);
        int rs=size(node.right);

        return ls+rs+1;

    }

    public static int sum(Node node) {
        if(node ==null){
            return 0;
        }
        int ls=sum(node.left);
        int rs=sum(node.right);

        return ls+rs+node.data;
    }

    public static int max(Node node) {
        if(node.right !=null){
            return max(node.right);
        }
        else{
            return node.data;
        }
    }

    public static int min(Node node) {
        if(node.left !=null){
            return min(node.left);
        }
        else{
            return node.data;
        }
    }

    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        if(data > node.data){
            return find(node.right,data);
        }else if(data < node.data){
            return find(node.left,data);
        }else{
            return true;
        }

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

        int data = Integer.parseInt(br.readLine());

        Node root = Node.construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        boolean found = find(root, data);

        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(found);
    }
}
