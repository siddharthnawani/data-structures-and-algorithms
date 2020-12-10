package src.com.sid.algorithms.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 **/
public class BinaryTreeInorderTraversal {
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

    public List<Integer> inorderTraversal_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;

        if (root.left != null)
            helper(root.left, res);
        res.add(root.val);
        if (root.right != null)
            helper(root.right, res);
    }

    public List<Integer> inorderTraversal_Iterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;// move to next right node
            } else {// has a left subtree
                pre = curr.left;
                while (pre.right != null) {// find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr;// store cur node
                curr = curr.left;// move cur to the top of the new tree
                temp.left = null;// original cur left be null, avoid infinite loops

            }
        }

        return res;
    }


}
