package src.com.sid.tree.genericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/levelorder-linewise-generic-tree-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a partially written GenericTree class.
 * 2. You are required to complete the body of levelorderLineWise function. The function is expected to visit every node in "levelorder fashion" and print them from left to right (level by level). All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
 * 3. Input is managed for you.
 * <p>
 * Sample Input
 * 24
 * 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
 * Sample Output
 * 10
 * 20 30 40
 * 50 60 70 80 90 100
 * 110 120
 **/
public class LevelorderLinewise {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);

        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }

    public static void levelOrderLinewise(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        Queue<Node> cq = new ArrayDeque<>();
        while (!mq.isEmpty()) {
            node = mq.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                cq.add(child);
            }

            if (mq.isEmpty()) {
                System.out.println();
                mq = cq;
                cq = new ArrayDeque<>();
            }


        }

    }

    public static void levelOrderLinewise2(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        mq.add(new Node(-1));

        while (!mq.isEmpty()) {
            node = mq.remove();

            if (node.data != -1) {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    mq.add(child);
                }
            } else {
                if (!mq.isEmpty()) {
                    mq.add(new Node(-1));
                    System.out.println();
                }
            }

        }

    }

    public static void levelOrderLinewise3(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while (!mq.isEmpty()) {
            int size = mq.size();

            for (int i = 0; i < size; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    mq.add(child);
                }
            }

            System.out.println();
        }


    }

    static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void levelOrderLinewise4(Node node) {
        Queue<Pair> mq = new ArrayDeque<>();
        int level = 1;

        mq.add(new Pair(node, level));
        while (!mq.isEmpty()) {

            Pair p = mq.remove();
            if (p.level > level) {
                level = p.level;
                System.out.println();
            }

            System.out.print(p.node.data + " ");

            int size = mq.size();
            for (Node child : p.node.children) {
                mq.add(new Pair(child, p.level + 1));
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        levelOrderLinewise(root);
        levelOrderLinewise2(root);
        levelOrderLinewise3(root);
        levelOrderLinewise4(root);

    }
}
