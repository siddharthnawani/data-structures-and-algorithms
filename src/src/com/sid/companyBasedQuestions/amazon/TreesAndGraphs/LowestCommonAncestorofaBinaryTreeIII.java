package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
 * 1650. Lowest Common Ancestor of a Binary Tree III
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 * <p>
 * Each node will have a reference to its parent node. The definition for Node is below:
 * <p>
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node parent;
 * }
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Ref : https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
 **/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

public class LowestCommonAncestorofaBinaryTreeIII {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null) return null;

        Node a = p;
        Node b = q;

        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }

        return a;
    }
}
