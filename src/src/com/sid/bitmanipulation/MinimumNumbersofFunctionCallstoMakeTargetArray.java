package src.com.sid.bitmanipulation;

/**
 * 1558. Minimum Numbers of Function Calls to Make Target Array
 * <p>
 * Your task is to form an integer array nums from an initial array of zeros arr that is the same size as nums.
 * <p>
 * Return the minimum number of function calls to make nums from arr.
 * <p>
 * The answer is guaranteed to fit in a 32-bit signed integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5]
 * Output: 5
 * Explanation: Increment by 1 (second element): [0, 0] to get [0, 1] (1 operation).
 * Double all the elements: [0, 1] -> [0, 2] -> [0, 4] (2 operations).
 * Increment by 1 (both elements)  [0, 4] -> [1, 4] -> [1, 5] (2 operations).
 * Total of operations: 1 + 2 + 2 = 5.
 * Example 2:
 * <p>
 * Input: nums = [2,2]
 * Output: 3
 * Explanation: Increment by 1 (both elements) [0, 0] -> [0, 1] -> [1, 1] (2 operations).
 * Double all the elements: [1, 1] -> [2, 2] (1 operation).
 * Total of operations: 2 + 1 = 3.
 * Example 3:
 * <p>
 * Input: nums = [4,2,5]
 * Output: 6
 * Explanation: (initial)[0,0,0] -> [1,0,0] -> [1,0,1] -> [2,0,2] -> [2,1,2] -> [4,2,4] -> [4,2,5](nums).
 ***/
public class MinimumNumbersofFunctionCallstoMakeTargetArray {

    public int minOperationsUsingBits(int[] nums) {
        int addOperation = 0;
        int highestSetBit = 0;
        for (int bit = 0; bit <= 30; bit++) {
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    addOperation++;
                    highestSetBit = bit;
                }
            }
        }
        return addOperation + highestSetBit;
    }

    public int minOperationsWithoutBits(int[] nums) {
        // WORK BACKWARDS
        //number of add operations and multiply ops
        int addOneOperation = 0, multiplyOperation = 0;
        int currDivides = 0; // how many times have we currently divided by 2

        // The most a number has been divided by 2
        int maxDivides = Integer.MIN_VALUE;//(basically dependant on the largest number)

        for (int num : nums) {
            currDivides = 0; //reset to 0
            while (num > 0) {
                if (num % 2 == 0) {
                    num = num / 2;
                    currDivides++;
                    // if our current number of divides is greater than the max, we can increase our count
                    if (currDivides > maxDivides) {
                        multiplyOperation++;
                        maxDivides = currDivides;
                    }
                } else {// if its odd, subtract 1
                    num--;
                    addOneOperation++;
                }

            }
        }
        return addOneOperation + multiplyOperation;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5};
        System.out.println(new MinimumNumbersofFunctionCallstoMakeTargetArray().minOperationsUsingBits(nums));
        System.out.println(new MinimumNumbersofFunctionCallstoMakeTargetArray().minOperationsWithoutBits(nums));
    }
}
