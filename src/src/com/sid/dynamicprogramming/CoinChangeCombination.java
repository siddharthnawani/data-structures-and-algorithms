package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-combination-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of coins.
 * 2. You are given n numbers, representing the denominations of n coins.
 * 3. You are given a number "amt".
 * 4. You are required to calculate and print the number of combinations of the n coins using which the
 * amount "amt" can be paid.
 * <p>
 * Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
 * used for many installments in payment of "amt"
 * Note2 -> You are required to find the count of combinations and not permutations i.e.
 * 2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
 * combination. You should treat them as 1 and not 3.
 * <p>
 * Sample Input
 * 4
 * 2
 * 3
 * 5
 * 6
 * 7
 * Sample Output
 * 2
 */
public class CoinChangeCombination {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int noOfcoins = in.nextInt();
        int[] coins = new int[noOfcoins];

        for (int i = 0; i < noOfcoins; i++)
            coins[i] = in.nextInt();

        int amt = in.nextInt();

        /**
         *Make dp array having elelments from 0 to amt ie amt+1
         */
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        /**
         *Traverse the whole dp array for each coin to check the
         * combinations.
         * Male sure to traverse further from the current coint value
         * to avoid permutations
         *
         *  1 way to make 0 coins; don't give any coin
         *
         */

        for (int coin = 0; coin < noOfcoins; coin++) {
            for (int j = coins[coin]; j < dp.length; j++) {

                /**
                 *Subtract the current amount which is j from the
                 * coin in hand i.e coins[coin]  amnd check if there
                 *is any way of making the reamining change,
                 * if yes then simply add those as well because
                 * by adding current coin to change we will achieve
                 * the current amount j.
                 **/
                dp[j] += dp[j - coins[coin]];


            }
        }

        System.out.println(dp[amt]);
    }
}
