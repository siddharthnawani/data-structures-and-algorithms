package src.com.sid.String.TwoPointers;

import src.com.sid.companyBasedQuestions.amazon.SlidingWindow.MinimumWindowSubstring;

/***
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59103/Two-AC-solutions-in-Java-with-time-complexity-of-N-and-NLogN-with-explanation
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 * **/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLenInNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];

        //store contiguous sum
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        //since this is a incresing sum array you can do binary search on it - take hint that only _ve numbers are there
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length)
                break;
            if (end - i < minLen) minLen = end - i;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    private int binarySearch(int lo, int h, int key, int[] nums) {

        while (lo <= h) {
            int mid = (lo + h) / 2;
            if (nums[mid] >= key) {
                h = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;

    }


    public int minSubArrayLen_N(int s, int[] nums) {
        int start = 0, end = 0, minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end];
                end++;
            }
            if (sum < s) break;

            while (start < end && sum >= s) {
                sum = sum - nums[start];
                start++;
            }

            minLen = (end - start + 1) < minLen ? (end - start + 1) : minLen;

        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen_N(s, nums));
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLenInNLogN(s, nums));
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s, nums));
    }

}
