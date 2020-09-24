package src.com.sid.dynamicprogramming.group1;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/zero-one-knapsack-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of items.
 * 2. You are given n numbers, representing the values of n items.
 * 3. You are given n numbers, representing the weights of n items.
 * 3. You are given a number "cap", which is the capacity of a bag you've.
 * 4. You are required to calculate and print the maximum value that can be created in the bag without
 * overflowing it's capacity.
 * <p>
 * Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item
 * again and again.
 * <p>
 * Sample Input
 * 5
 * 15 14 10 45 30
 * 2 5 1 3 4
 * 7
 * Sample Output
 * 75
 **/
public class ZeroOneKnapsack {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }

        int[] wts = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = in.nextInt();
        }

        int cap = in.nextInt();

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                int currItemVal = values[i - 1];
                int currItemWt = wts[i - 1];

                if (j >= currItemWt) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - currItemWt] + currItemVal);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }


            }
        }

        System.out.println(dp[n][cap]);
    }
}
