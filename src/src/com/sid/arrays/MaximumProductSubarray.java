package src.com.sid.arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * <p>
 * 152. Maximum Product Subarray
 * Medium
 * <p>
 * 5577
 * <p>
 * 191
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 **/
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prev_max = max_so_far;
            //max_sum for +ve array
            //min sum for negative array - X - == +
            // nums[i] in case there is 0 in array; after that we will start from next element
            max_so_far = Math.max(nums[i], Math.max(nums[i] * max_so_far, nums[i] * min_so_far));
            min_so_far = Math.min(nums[i], Math.min(nums[i] * prev_max, nums[i] * min_so_far));
            res = Math.max(max_so_far, res);
        }


        return res;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }
}
