package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * Follow up: Solve it both recursively and iteratively.
 **/
public class SymmetricTree {
    public boolean isSymmetric_Recursive(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            //push the elements
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);

        }

        return true;

    }
}
