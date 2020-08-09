package src.com.sid.tree;

import java.util.HashMap;

/***
 *
 * 437. Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 *
 * **/

public class PathSumIII {

     static class TreeNode {
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

    int total;

    public int pathSumByRecursion(TreeNode root, int sum) {
        if (root == null)
            return 0;

        pathSumByRecursion(root, sum, 0);
        pathSumByRecursion(root.left, sum);
        pathSumByRecursion(root.right, sum);

        return total;
    }

    private void pathSumByRecursion(TreeNode root, int sum, int currentSum) {
        if (root == null) return;
        currentSum += root.val;
        if (currentSum == sum)
            total++;
        pathSumByRecursion(root.left, sum, currentSum);
        pathSumByRecursion(root.right, sum, currentSum);
    }

    public int pathSumUsingPrefixSum(TreeNode root, int sum) {
        if (root == null) return 0;
        HashMap<Integer,Integer> prefixSum=new HashMap<>();
        prefixSum.put(0,1);
        findPathSumUsingPrefixSum(root,0,sum,prefixSum);
        return total;
    }
    private void findPathSumUsingPrefixSum(TreeNode root,int currSum,int target,HashMap<Integer,Integer> prefixSum){

        if(root ==null)
            return;
        currSum += root.val;
        if(prefixSum.containsKey(currSum - target))
            total += prefixSum.get(currSum-target);

        prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);

        findPathSumUsingPrefixSum(root.left,currSum,target,prefixSum);
        findPathSumUsingPrefixSum(root.right,currSum,target,prefixSum);
        prefixSum.put(currSum,prefixSum.get(currSum)-1);//remove the key in backtracking

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);

        root.left=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        root.left.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(-2);
        root.left.right.right=new TreeNode(1);

        root.right=new TreeNode(-3);
        root.right.right=new TreeNode(11);

        int sum=8;
        System.out.println(new PathSumIII().pathSumByRecursion(root,sum));
        System.out.println(new PathSumIII().pathSumUsingPrefixSum(root,sum));

    }


}
