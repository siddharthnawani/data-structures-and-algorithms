package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * 314. Binary Tree Vertical Order Traversal
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Examples 1:
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9  20
 * /\
 * /  \
 * 15   7
 * <p>
 * Output:
 * <p>
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 **/
public class BinaryTreeVerticalOrderTraversal {
    //using BFS
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //the idea is do a column wise sorting of the tree, with the nodes itself ordered within the column as row wise ordered

        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;

        Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();//for storing column wise ordering
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();//for BFS
        q.add(new Pair(root, 0));
        int minColumn = 0, maxColumn = 0;

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            root = p.getKey();
            int column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column))
                    columnTable.put(column, new ArrayList<>());

                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                q.add(new Pair(root.left, column - 1));
                q.add(new Pair(root.right, column + 1));
            }

        }
        for (int i = minColumn; i <= maxColumn; i++) {
            output.add(columnTable.get(i));
        }

        return output;
    }
}
