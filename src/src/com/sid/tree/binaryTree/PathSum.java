package src.com.sid.tree.binaryTree;

import javafx.util.Pair;

import java.util.Stack;

/**
 * https://leetcode.com/problems/path-sum/
 * 112. Path Sum
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * <p>
 * In this work will be done in preorder.
 **/
public class PathSum {
    //recursive
    //calulation will be done in pre order
    public boolean hasPathSum_recursive(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum = sum - root.val;
        if ((root.left == null) && (root.right == null)) //is leaf node
            return sum == 0;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }

    //iterative
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        //treenode and sum pair
        Stack<Pair<TreeNode, Integer>> stack = new Stack();
        stack.push(new Pair(root, sum - root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int remSum = pair.getValue();

            if (node.left == null && node.right == null && remSum == 0)
                return true;

            if (node.left != null) stack.push(new Pair(node.left, remSum - node.left.val));
            if (node.right != null) stack.push(new Pair(node.right, remSum - node.right.val));


        }

        return false;
    }
}
