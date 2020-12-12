package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 **/
public class BinaryTreeZigzagLevelOrderTraversal {
    private List<List<Integer>> res = new LinkedList<>();

    //recursive solution
    public List<List<Integer>> zigzagLevelOrder_recursive(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level)
            res.add(new LinkedList<>());

        if (level % 2 == 0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    //iterative
    public List<List<Integer>> zigzagLevelOrder_ITERATIVE1(TreeNode root) {
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            res.add(new LinkedList<>());
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (res.size() % 2 != 0) {
                    res.get(res.size() - 1).add(node.val);
                } else
                    res.get(res.size() - 1).add(0, node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }
        }

        return res;

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);//null will be our delimiter

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                // we finish the scan of one level
                res.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return res;
    }
}
