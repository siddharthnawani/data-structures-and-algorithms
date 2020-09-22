package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of stairs in a staircase.
 * 2. You are on the 0th step and are required to climb to the top.
 * 3. You are given n numbers, where ith element's value represents - till how far from the step you
 * could jump to in a single move.
 * You can of course jump fewer number of steps in the move.
 * 4. You are required to print the number of different paths via which you can climb to the top.
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
 * 5
 */
public class ClimbStairsWithVariableJumps {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        /**
         * 1. Storage & Meaning
         * We declared and array of size n+1 because there are n+1
         * numbers from 0 to n and dp[n] will give us the answer,
         * we are looking for
         *
         * dp[i] will tell us all the path from i to n;
         *
         * 2. Direction :
         *
         * let's say for n=6
         * dp[6] will give us path from 6 to 6
         * dp[5] all paths from 5 to 6 and so on..
         *
         * so we will solve the problem from lower to higher direction
         *
         * 3. Travel and solve : Iterate and fill the dp array from the
         * back.
         *
         */
        int[] dp = new int[n + 1];
        //only 1 way to go from n to n
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }

        System.out.println(dp[0]);

    }
}
