package src.com.sid.tree.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * 501. Find Mode in Binary Search Tree
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 *
 *
 * **/
public class FindModeinBinarySearchTree {

    TreeNode prev = null;//this can be further optimized by just storing val as Integer.
    int count = 0;
    int max = -1;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int[] ary = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ary[i] = res.get(i);
        }
        return ary;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);

        if (prev != null && root.val == prev.val) {
            count++;
        } else {
            count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root;
        inorder(root.right, list);
    }
}
