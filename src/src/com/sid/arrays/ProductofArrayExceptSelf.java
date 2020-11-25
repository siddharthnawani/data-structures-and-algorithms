package src.com.sid.arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * <p>
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 **/
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        //first cal left sum
        answer[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        //then right sum
        int rightSum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightSum;
            rightSum *= nums[i];
        }


        return answer;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new ProductofArrayExceptSelf().productExceptSelf(nums));
    }
}
