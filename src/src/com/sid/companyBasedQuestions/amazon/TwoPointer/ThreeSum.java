package src.com.sid.companyBasedQuestions.amazon.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 ***/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        //sort the array
        Arrays.sort(nums);
        //run loop from i and inside it check for the remaining sum to be 0 for the remaining elements
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                checkForRemainingSum(nums, i, res);
            }
        }
        return res;

    }

    void checkForRemainingSum(int[] nums, int i, List<List<Integer>> res) {

        int lo = i + 1, h = nums.length - 1;
        int target = 0;
        while (lo < h) {
            target = nums[i] + nums[lo] + nums[h];
            if (target < 0) {
                lo++;
            } else if (target > 0) {
                h--;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo], nums[h]));
                lo++;
                h--;
                while (lo < h && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
                while (lo < h && nums[h + 1] == nums[h]) {
                    h--;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
