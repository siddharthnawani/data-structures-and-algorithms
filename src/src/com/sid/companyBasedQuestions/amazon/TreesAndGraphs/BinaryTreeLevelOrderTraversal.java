package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 **/
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> levels = new ArrayList<>();

    //recrsive
    public List<List<Integer>> levelOrder_recursive(TreeNode root) {
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) return;

        if (levels.size() == level)
            levels.add(new ArrayList<>());

        levels.get(level).add(root.val);
        if (root.left != null)
            helper(root.left, level + 1);
        if (root.right != null)
            helper(root.right, level + 1);
    }

    //iterative
    public List<List<Integer>> levelOrder(TreeNode root) {
        //the idea is to perform a bfs
        if (root == null) return levels;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            levels.add(new ArrayList<>());
            int q_size = q.size();
            for (int i = 0; i < q_size; i++) {
                TreeNode tmp = q.poll();
                levels.get(levels.size() - 1).add(tmp.val);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
        }
        return levels;
    }
}
