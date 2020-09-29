package src.com.sid.dynamicprogramming.buyAndSellStocks;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-transaction-fee-ita-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are give a number fee, representing the transaction fee for every transaction.
 * 4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
 * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 * <p>
 * Sample Input
 * 12
 * 10
 * 15
 * 17
 * 20
 * 16
 * 18
 * 22
 * 20
 * 22
 * 20
 * 23
 * 25
 * 3
 * Sample Output
 * 13
 **/
public class BuyAnSellStocksWithTransactionFeeInfiniteTransactionsAllowed {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        int fee = in.nextInt();
        int obsp = -arr[0], ossp = 0;

        for (int i = 1; i < n; i++) {

            int nbsp = 0;
            int nssp = 0;

            if (ossp - arr[i] > obsp)
                nbsp = ossp - arr[i];
            else
                nbsp = obsp;

            if (obsp + arr[i] - fee > ossp)
                nssp = obsp + arr[i] - fee;
            else
                nssp = ossp;

            obsp = nbsp;
            ossp = nssp;

        }

        System.out.println(ossp);
    }
}
