package src.com.sid.dynamicprogramming.buyAndSellStocks;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ita-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
 * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
 * <p>
 * Sample Input
 * 9
 * 11
 * 6
 * 7
 * 19
 * 4
 * 1
 * 6
 * 18
 * 4
 * Sample Output
 * 30
 **/
public class BuyAndSellStocksInfiniteTransactionsAllowed {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        /**
         *The idea is to keep on maintining the buy sell index
         * and make a buy-Sell transaction before every dip in the
         * market
         **/
        int b = 0, s = 0, profit = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                s++;
            } else {
                profit += arr[s] - arr[b];
                s = b = i;
            }
        }

        profit += arr[s] - arr[b];

        System.out.println(profit);

    }
}
