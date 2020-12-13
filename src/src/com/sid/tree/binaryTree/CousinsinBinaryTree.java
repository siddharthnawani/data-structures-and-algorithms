package src.com.sid.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * 993. Cousins in Binary Tree
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * Example 1:
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 **/
public class CousinsinBinaryTree {
    //using DFS recursive
    int xDepth = -1, yDepth = -2;
    TreeNode xparent = null, yparent = null;

    public boolean isCousins_recursive(TreeNode root, int x, int y) {
        if (root == null) return false;
        dfs_helper(root, x, y, 0, null);
        return xparent != yparent && xDepth == yDepth;
    }

    private void dfs_helper(TreeNode node, int x, int y, int depth, TreeNode parent) {
        if (node == null)
            return;

        if (node.val == x) {
            xparent = parent;
            xDepth = depth;
        } else if (node.val == y) {
            yparent = parent;
            yDepth = depth;
        } else {
            // if we found x node or found y node then we don't need to dfs deeper
            //     because x and y must be the same depth
            dfs_helper(node.left, x, y, depth + 1, node);
            dfs_helper(node.right, x, y, depth + 1, node);
        }
    }

    //using bfs - iterative
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isxExist = false;
            boolean isyExist = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                //do a pre check
                if (curr.val == x)
                    isxExist = true;
                if (curr.val == y)
                    isyExist = true;

                //now check for siblings
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) return false;
                    if (curr.right.val == x && curr.left.val == y) return false;
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);

            }

            if (isxExist && isyExist) return true;
            else if (isxExist || isyExist) return false;//dont check futher depth
        }
        return false;
    }
}
