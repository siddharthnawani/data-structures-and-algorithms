package src.com.sid.companyBasedQuestions.amazon.TwoPointer;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/3sum-closest/
 * 16. 3Sum Closest
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * **/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {

            int l = i + 1, h = nums.length - 1;

            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                int diff = target - sum;

                if (Math.abs(diff) < Math.abs(val)) {
                    val = diff;
                }

                if (sum < target) {
                    l++;
                } else {
                    h--;
                }
            }
        }

        return target - val;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}
