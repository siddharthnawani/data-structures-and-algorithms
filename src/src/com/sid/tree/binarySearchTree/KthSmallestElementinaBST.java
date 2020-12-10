package src.com.sid.tree.binarySearchTree;


/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
 * <p>
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 ***/

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class KthSmallestElementinaBST {


    int counter = 0, v = 0;

    public int kthSmallest_Recursive(TreeNode root, int k) {
        if (root == null)
            return 0;

        kthSmallest(root.left, k);
        counter++;
        if (k == counter)
            v = root.val;
        kthSmallest(root.right, k);
        return v;
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            --k;
            if (k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}
