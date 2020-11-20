package src.com.sid.arrays;

/**
 * 674. Longest Continuous Increasing Subsequence
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
 * <p>
 * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
 * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
 * 4.
 **/
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS_2(int[] num) {
        if (num.length == 0) return 0;
        int len = 1;
        int res = 1;
        for (int i = 1; i < num.length; i++) {

            if (num[i] > num[i - 1]) {
                len++;
                res = Math.max(res, len);
            } else {
                len = 1;
            }

        }
        return res;
    }

    public int findLengthOfLCIS(int[] num) {
        if (num.length == 0) return 0;
        int len = 1;
        int res = 1;
        for (int i = 1; i < num.length; i++) {

            if (num[i] > num[i - 1]) {
                len++;

            } else {
                res = Math.max(res, len);
                len = 1;
            }

        }
        return Math.max(res, len);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(nums));
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS_2(nums));
    }
}
