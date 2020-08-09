package src.com.sid.arrays;

import java.util.HashMap;

/***
 *
 * 560. Subarray Sum Equals K
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * Accepted
 *
 *
 *
 * **/
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int result=0,sum=0;
        HashMap<Integer,Integer> prefixSum=new HashMap<>();

        prefixSum.put(0,1); //.it is for those (sum - k) == 0 calculations which are valid subarrays but need to get counted

        for(int i=0;i<nums.length;i++)
        {
            sum +=nums[i];
            if(prefixSum.containsKey(sum-k))
                result += prefixSum.get(sum-k);
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums={1,1,1};
        int k=2;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums,k));
    }

}
