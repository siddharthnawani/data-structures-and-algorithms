package src.com.sid.dynamicprogramming.buyAndSellStocks;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-kta---official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are given a number k, representing the number of transactions allowed.
 * 3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
 * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 * <p>
 * Sample Input
 * 6
 * 9
 * 6
 * 7
 * 6
 * 3
 * 8
 * 1
 * <p>
 * Sample Output
 * 5
 */
public class BuyAndSellStocksKTransactionsAllowed {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int k = in.nextInt();

        /**
         *The idea is to have a 2D dp, where the row denites the transaction
         * from 0 to k and column denotes day from 0 to n-1;
         *
         * Each i,jth entry can be found bu comparing 2 things, max of below:
         *
         * i transactions till j-1 day
         *
         * or
         * Max of k where k:0 -> j-1
         *
         * till kth transaction value + Sell on j and buy on k
         *
         * PLus first row would be 0 since with no transaction
         * max profit could be 0
         *
         * and first column would be 0 since if there is only one day
         * whayt so ever transactions you do profit will always be 0
         ***/

        int[][] dp = new int[k + 1][n];

        new BuyAndSellStocksKTransactionsAllowed().solveInNCube(n, arr, k, dp);

        System.out.println(dp[k][n - 1]);

        dp = new int[k + 1][n];

        new BuyAndSellStocksKTransactionsAllowed().solveInNSquare(n, arr, k, dp);


        System.out.println(dp[k][n - 1]);


    }

    private void solveInNSquare(int n, int[] arr, int k, int[][] dp) {

        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < n; d++) {

                //Mainitainng previous max
                if (dp[t - 1][d - 1] - arr[d - 1] > max) {
                    max = dp[t - 1][d - 1] - arr[d - 1];
                }

                //compare with previous transction

                if (max + arr[d] > dp[t][d - 1]) {
                    dp[t][d] = max + arr[d];
                } else {
                    dp[t][d] = dp[t][d - 1];
                }


            }
        }
    }

    private void solveInNCube(int n, int[] arr, int k, int[][] dp) {
        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < n; d++) {

                //all transaction till previous day
                int max = dp[t][d - 1];

                //or max of ,t-1 th transaction + that transacion, till date
                for (int pd = 0; pd < d; pd++) {

                    int ptilltm1 = dp[t - 1][pd];
                    int ptth = arr[d] - arr[pd];
                    if (ptilltm1 + ptth > max) {
                        max = ptilltm1 + ptth;
                    }

                }

                dp[t][d] = max;

            }
        }
    }

}
