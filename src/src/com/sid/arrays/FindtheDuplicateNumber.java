package src.com.sid.arrays;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * <p>
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one duplicate number in nums, return this duplicate number.
 * <p>
 * Follow-ups:
 * <p>
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem without modifying the array nums?
 * Can you solve the problem using only constant, O(1) extra space?
 * Can you solve the problem with runtime complexity less than O(n2)?
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Further Reading:
 *
 * https://www.youtube.com/watch?v=-YiQZi3mLq0
 **/
public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;

    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(new FindtheDuplicateNumber().findDuplicate(nums));
    }
}
