package src.com.sid.tree.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/path-sum-iv/
 * 666. Path Sum IV
 * <p>
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
 * <p>
 * For each integer in this list:
 * <p>
 * The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 * The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
 * The units digit represents the value V of this node, 0 <= V <= 9.
 * Given a list of ascending three-digits integers representing a binary tree with the depth smaller than 5, you need to return the sum of all paths from the root towards the leaves.
 * <p>
 * It's guaranteed that the given list represents a valid connected binary tree.
 * <p>
 * Example 1:
 * <p>
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation:
 * The tree that the list represents is:
 * 3
 * / \
 * 5   1
 * <p>
 * The path sum is (3 + 5) + (3 + 1) = 12.
 *
 * Solution Ref: https://leetcode.com/problems/path-sum-iv/discuss/106892/Java-solution-Represent-tree-using-HashMap
 **/
public class PathSumIV {
    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();

    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        //fill the tree into hash map
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }
        //then traverse recursively - this is sort of bfs
        traverse(nums[0] / 10, 0);
        return sum;
    }

    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;//this is 1 based index-- we need 0 based
        int leftChild = (level + 1) * 10 + (2 * pos) - 1; // key for left child-- always remember in 0 based index for parent p -> lc : 2p ; rc : 2p+1
        int rightChild = (level + 1) * 10 + (2 * pos);

        int currSum = preSum + tree.get(root);

        //check for leaf
        if (!tree.containsKey(leftChild) && !tree.containsKey(rightChild))
            sum += currSum;
        else {
            //otherwise recursively go inside
            if (tree.containsKey(leftChild)) traverse(leftChild, currSum);
            if (tree.containsKey(rightChild)) traverse(rightChild, currSum);
        }


    }
}
