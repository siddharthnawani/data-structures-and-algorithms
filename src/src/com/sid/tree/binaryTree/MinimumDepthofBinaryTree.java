package src.com.sid.tree.binaryTree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 **/
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

public class MinimumDepthofBinaryTree {

    //using dfs
    public int minDepth_dfs_recursive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;//isleaf

        int left_depth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int right_depth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        return Math.min(left_depth, right_depth) + 1;
    }

    //iterative using bfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 1));//pair class containing treenode and level
        int min_depth = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> current = q.poll();
            TreeNode node = current.getKey();
            min_depth = current.getValue();
            if (node.left == null && node.right == null)//AS soon as first leaf is foud break;
                break;
            if (node.left != null) q.add(new Pair(node.left, current.getValue() + 1));
            if (node.right != null) q.add(new Pair(node.right, current.getValue() + 1));

        }

        return min_depth;

    }
}

