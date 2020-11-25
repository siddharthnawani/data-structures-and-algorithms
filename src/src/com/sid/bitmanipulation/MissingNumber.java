package src.com.sid.bitmanipulation;

/**
 * https://leetcode.com/problems/missing-number/
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 ***/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        //the idea is: a^b^b = a
        //so we simple xor index and values to cancel out
        int res = nums.length;//since we now this exists
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(new MissingNumber().missingNumber(nums));
    }
}
