package src.com.sid.dynamicprogramming.buyAndSellStocks;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ota-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are required to print the maximum profit you can make if you are allowed a single transaction.
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
 * 17
 */
public class BuyAndSellStocksOneTransactionAllowed {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++)
            prices[i] = in.nextInt();

        int lsf = Integer.MAX_VALUE;
        int profitIfSoldToday = 0;
        int op = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf)
                lsf = prices[i];
            profitIfSoldToday = prices[i] - lsf;

            if (profitIfSoldToday > op)
                op = profitIfSoldToday;
        }

        System.out.println(op);

    }
}
