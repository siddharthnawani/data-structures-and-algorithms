package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of stairs in a staircase.
 * 2. You are on the 0th step and are required to climb to the top.
 * 3. You are given n numbers, where ith element's value represents - till how far from the step you
 * could jump to in a single move.  You can of-course fewer number of steps in the move.
 * 4. You are required to print the number of minimum moves in which you can reach the top of
 * staircase.
 * <p>
 * Sample Input
 * 10
 * 3
 * 3
 * 0
 * 2
 * 1
 * 2
 * 4
 * 2
 * 0
 * 0
 * Sample Output
 * 4
 */
public class ClimbStairsWithMinimumMoves {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        /**
         * each element will represet the min moves from that
         * element to last element
         */
        Integer dp[] = new Integer[n + 1];
        //there will be 0 move from last to last element
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                int min = Integer.MAX_VALUE;

                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE)
                    dp[i] = min + 1;
            }
        }

        System.out.println(dp[0]);

    }
}
