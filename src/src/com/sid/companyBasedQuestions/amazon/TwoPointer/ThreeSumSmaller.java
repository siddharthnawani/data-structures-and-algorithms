package src.com.sid.companyBasedQuestions.amazon.TwoPointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-smaller/
 * <p>
 * 259. 3Sum Smaller
 * <p>
 * j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p>
 * Follow up: Could you solve it in O(n2) runtime?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 * Example 2:
 * <p>
 * Input: nums = [], target = 0
 * Output: 0
 * Example 3:
 * <p>
 * Input: nums = [0], target = 0
 * Output: 0
 **/
public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return res;

    }

    public int twoSumSmaller(int[] nums, int startIndex, int target) {

        int l = startIndex, h = nums.length - 1, res = 0;
        while (l < h) {

            if (nums[l] + nums[h] < target) {
                //accumulate all the lower index
                res += h - l;
                l++;
            } else {
                h--;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 0, -2};
        int target = 4;
        System.out.println(new ThreeSumSmaller().threeSumSmaller(nums, target));
    }
}
