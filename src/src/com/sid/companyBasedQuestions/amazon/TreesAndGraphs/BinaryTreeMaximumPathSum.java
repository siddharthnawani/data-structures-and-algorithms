package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 124. Binary Tree Maximum Path Sum
 * <p>
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * Output: 6
 * Example 2:
 * <p>
 * <p>
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * <p>
 * Ref : https://www.youtube.com/watch?v=TO5zsKtc1Ic
 *
 * the first step is always to identify whether the word need to be done in pre order or post order; this is post order because we need vaues from the root first.
 ***/
public class BinaryTreeMaximumPathSum {

    int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max_sum;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        //3 cases we have to handle:
        /**
         *Case 1: Path could either be continuing from left subtree or right subtree or could be starting from current node.
         *
         case 2: either we have to build a continious path ie case 1 or there is a max path sum by joining left and right subtree.
         *
         case 3: we already have found a path earlier or it could be from case 1 or 2
         **/


        //left_path_sum
        int left_path_sum = helper(node.left);
        //right_oath_sum
        int right_path_sum = helper(node.right);

        //case1: continue building continous path either by building a new path from node or continuing left or right path
        int straight_path_sum = Math.max(node.val, node.val + Math.max(left_path_sum, right_path_sum));

        //case 2 : current node is included in the path and it may include left and right as well
        int sum_inc_node = node.val + left_path_sum + right_path_sum;
        int max_combination_sum = Math.max(straight_path_sum, sum_inc_node);

        //case 3: max sum so far
        max_sum = Math.max(max_sum, max_combination_sum);

        //return the sum which could extend the current path further
        return straight_path_sum;


    }
}
