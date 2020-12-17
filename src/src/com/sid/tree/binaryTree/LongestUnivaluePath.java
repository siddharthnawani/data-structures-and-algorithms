package src.com.sid.tree.binaryTree;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 * 687. Longest Univalue Path
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * The length of the path between two nodes is represented by the number of edges between them.
 * Input: root = [5,4,5,1,1,5]
 * Output: 2
 **/
public class LongestUnivaluePath {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return ans;
    }

    //this qustn is similar ot max path sum so again we have to checkfor 3 cases.
    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left_path = helper(node.left);
        int right_path = helper(node.right);

        //start from 1 node before leaf
        int left_edge = 0, right_edge = 0;
        if (node.left != null && node.left.val == node.val)
            left_edge = left_path + 1;
        if (node.right != null && node.right.val == node.val)
            right_edge = right_path + 1;

        //update max answer to check if we have the longest path
        ans = Math.max(ans, left_edge + right_edge);

        //return a continous path
        return Math.max(left_edge, right_edge);


    }
}
