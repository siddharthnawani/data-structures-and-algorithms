package src.com.sid.dynamicprogramming.buyAndSellStocks;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-tta-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
 * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
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
 */
public class BuyAndSellStocksTwoTransactionsAllowed {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }


        /**
         *The idea is to keep 2 arrays
         *
         * dpmaxleft - array where i th element will denote max profit
         * upto i when the element is sold today
         *
         * dpmaxright - max profit on the right, when the share is
         * bought today
         *
         * then we will simply see for which i the sum of dpmaxleft[i]
         * and dpmaxright[i] is the most
         *
         **/


        //fill left array
        int minsofar = arr[0];
        int[] dpmaxleft = new int[n];

        for (int i = 1; i < n; i++) {

            if (arr[i] < minsofar)
                minsofar = arr[i];

            int profit = arr[i] - minsofar;

            if (profit > arr[i - 1])
                dpmaxleft[i] = profit;
            else
                dpmaxleft[i] = dpmaxleft[i - 1];
        }


        //fill right array
        int maxsofar = arr[n - 1];
        int[] maxdpright = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxsofar)
                maxsofar = arr[i];

            int profit = maxsofar - arr[i];

            if (profit > maxdpright[i + 1])
                maxdpright[i] = profit;
            else
                maxdpright[i] = maxdpright[i + 1];
        }

        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (dpmaxleft[i] + maxdpright[i] > maxProfit)
                maxProfit = dpmaxleft[i] + maxdpright[i];
        }

        System.out.println(maxProfit);
    }

}

