package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-permutations-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of coins.
 * 2. You are given n numbers, representing the denominations of n coins.
 * 3. You are given a number "amt".
 * 4. You are required to calculate and print the number of permutations of the n coins using which the
 * amount "amt" can be paid.
 * <p>
 * Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
 * used for many installments in payment of "amt"
 * Note2 -> You are required to find the count of permutations and not combinations i.e.
 * 2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
 * combination. You should treat them as 3 and not 1.
 * <p>
 * Sample Input
 * 4
 * 2
 * 3
 * 5
 * 6
 * 7
 * Sample Output
 * 5
 **/
public class CoinChangePermutations {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int noOfCoins = in.nextInt();

        int[] coins = new int[noOfCoins];
        for (int i = 0; i < noOfCoins; i++)
            coins[i] = in.nextInt();

        int tar = in.nextInt();

        int dp[] = new int[tar + 1];
        dp[0] = 1;

        /**
         *This loop is equivalent to
         * for(int amt=1;amt<dp.lengthj;amt++)
         * Simply we are tarversing all the amount till target.
         *
         * How this is different from previous question on combinations;
         * In that, we were first doing loop fo 2 then 3 then 5 then 7 etc
         *
         * so 3 was onky getting options of change with 2 similarly 5 ws
         * getting only options with 2 and 3... and so on;
         *
         * but here for each amount we are checking all the possible chnges
         * with all coins so that the next coin can also avail these options
         */
        for (int amt = 1; amt <= tar; amt++) {
            for (int coin : coins) {

                if (amt >= coin) {

                    int ramt = amt - coin;
                    dp[amt] += dp[amt - coin];
                }
            }
        }

        System.out.println(dp[tar]);

    }
}
