package src.com.sid.companyBasedQuestions.amazon.ArraysAndStrings;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * <p>
 * 41. First Missing Positive
 * <p>
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * <p>
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * <p>
 * <p>
 * Further Reading :
 * <p>
 * https://leetcode.com/problems/first-missing-positive/discuss/17080/Python-O(1)-space-O(n)-time-solution-with-explanation
 ***/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //check if 1 is present
        //Convert all -ve, 0 , val>n to 1
        //keep 0 index for n
        //if even 0 index is -ve then n+1 else n

        int n = nums.length;

        //base case
        int contains = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }

        }

        if (contains == 0) {
            return 1;
        }

        // nums = [1]
        if (n == 1) {
            return 2;
        }

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);

            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (num == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[num] = -Math.abs(nums[num]);
            }
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        } else
            return n + 1;


    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}
