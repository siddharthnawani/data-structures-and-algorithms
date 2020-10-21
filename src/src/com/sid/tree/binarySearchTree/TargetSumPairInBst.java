package src.com.sid.tree.binarySearchTree;

import src.com.sid.tree.binaryTree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/tsp-bst-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written BST class.
 * 2. You are given a value. You are required to print all pair of nodes which add up to the given value. Make sure all pairs print the smaller value first and avoid duplicacies. Make sure to print the pairs in increasing order. Use the question video to gain clarity.
 * <p>
 * Sample Input
 * 21
 * 50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
 * 100
 * Sample Output
 * 25 75
 * 30 70
 **/
public class TargetSumPairInBst {

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }

    public static void targetSumPair(Node root, Node node, int tar) {

        if (node == null) {
            return;
        }

        targetSumPair(root, node.left, tar);

        int rem = tar - node.data;
        if (rem > node.data) {
            if (find(root, rem) == true) {
                System.out.println(node.data + " " + rem);
            }
        }

        targetSumPair(root, node.right, tar);
    }

    public static void tnf1(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        tnf1(node.left, list);
        list.add(node.data);
        tnf1(node.right, list);

    }

    static class IPair {
        Node node;
        int state;

        IPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node getNextFromNormalInorder(Stack<IPair> st) {

        while (st.size() > 0) {

            IPair top = st.peek();

            //preorder - sine visiting the node for the first time
            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new IPair(top.node.left, 0));
                }
                top.state++;
            }//in order - since vising the node for the secod time
            else if (top.state == 1) {
                if (top.node.right != null) {
                    st.push(new IPair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            }//postorder - since visiting the node for the third time
            else {
                st.pop();
            }

        }

        return null;
    }

    public static Node getNextFromReverseInorder(Stack<IPair> st) {

        while (st.size() > 0) {

            IPair top = st.peek();

            //preorder - sine visiting the node for the first time
            if (top.state == 0) {
                if (top.node.right != null) {
                    st.push(new IPair(top.node.right, 0));
                }
                top.state++;
            }//in order - since vising the node for the secod time
            else if (top.state == 1) {
                if (top.node.left != null) {
                    st.push(new IPair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            }//postorder - since visiting the node for the third time
            else {
                st.pop();
            }

        }

        return null;
    }

    public static void bestApproach(Node node, int tar) {
        Stack<IPair> ls = new Stack<>();
        Stack<IPair> rs = new Stack<>();

        ls.push(new IPair(node, 0));
        rs.push(new IPair(node, 0));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);

        while (left.data < right.data) {

            if (left.data + right.data > tar) {
                right = getNextFromReverseInorder(rs);

            } else if (left.data + right.data < tar) {
                left = getNextFromNormalInorder(ls);
            } else {
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
            }

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

        //Approach 1
        // Space  : O(h)  Time : O(nh)
        targetSumPair(root, root, data);

        //Approach 2
        // Space  : O(n)  Time : O(n)
        ArrayList<Integer> list = new ArrayList<>();
        tnf1(root, list);

        int li = 0, ri = list.size() - 1;

        while (li < ri) {

            int left = list.get(li);
            int right = list.get(ri);
            if (left + right > data) {
                ri--;

            } else if (left + right < data) {
                li++;
            } else {
                System.out.println(left + " " + right);
                li++;
                ri--;
            }

        }

        //Approach 3
        // Space  : O(H)  Time : O(n)
        bestApproach(root,data);

    }
}
