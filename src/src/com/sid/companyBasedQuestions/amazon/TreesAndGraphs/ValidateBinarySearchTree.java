package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.Stack;

/***
 * https://leetcode.com/problems/validate-binary-search-tree/
 *98. Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * **/
public class ValidateBinarySearchTree {

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

    public boolean isValidBST_Recursive(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer left, Integer right) {
        if (root == null) return true;

        if (left != null && root.val <= left) return false;
        if (right != null && root.val >= right) return false;

        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;

        }

        return true;
    }
}
