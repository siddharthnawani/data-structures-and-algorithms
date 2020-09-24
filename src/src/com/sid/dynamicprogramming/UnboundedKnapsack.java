package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/unbounded-knapsack-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of items.
 * 2. You are given n numbers, representing the values of n items.
 * 3. You are given n numbers, representing the weights of n items.
 * 3. You are given a number "cap", which is the capacity of a bag you've.
 * 4. You are required to calculate and print the maximum value that can be created in the bag without
 * overflowing it's capacity.
 * Note -> Each item can be taken any number of times. You are allowed to put the same item again
 * and again.
 * <p>
 * <p>
 * Sample Input
 * 5
 * 15 14 10 45 30
 * 2 5 1 3 4
 * 7
 * Sample Output
 * 100
 **/
public class UnboundedKnapsack {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] wts = new int[n];
        int[] vals = new int[n];

        for (int i = 0; i < n; i++)
            vals[i] = in.nextInt();

        for (int i = 0; i < n; i++)
            wts[i] = in.nextInt();

        int cap = in.nextInt();

        int[] dp = new int[cap + 1];
        dp[0] = 0;

        /**
         *You can also write
         * for(int dp=1;bagc<dp.length;bagc++)
         *
         */
        for (int bagc = 1; bagc <= cap; bagc++) {
            int max = 0;
            for (int i = 0; i < wts.length; i++) {

                if (wts[i] <= bagc) {
                    int rbagc = bagc - wts[i];
                    int rbagv = dp[rbagc];
                    int tbagv = rbagv + vals[i];

                    max = Math.max(tbagv, max);
                }

            }

            dp[bagc] = max;
        }

        System.out.println(dp[cap]);
    }
}
