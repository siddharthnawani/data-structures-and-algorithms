package src.com.sid.companyBasedQuestions.amazon.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.youtube.com/watch?v=TCHSXAu5pls
 * https://leetcode.com/problems/sliding-window-maximum/
 * <p>
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 **/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];

        if (nums.length == 1 || k == 1)
            return nums;

        //the idea is to maintain a deque or a linked list which will hole only the indexes of current window and the first element will be the biggest and last will be smallest

        //this will store index and not elements for quick access
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[n - k + 1];

        for (int i = 0; i < nums.length; i++) {
            //remove indexes which are not in window
            //indexes less than i-k+1 are not part of window
            if (!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();//poll removes first element from queue

            //push as to maintain decreasing order of queue
            //for that we have to check we are always pushing if the last element if greater than current element
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.pollLast();

            dq.addLast(i);//we can also write offer

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.peek()];
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(new SlidingWindowMaximum().maxSlidingWindow(nums, k));
    }
}
