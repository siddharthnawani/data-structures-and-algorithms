package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling2-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
 * 2. You've an infinite supply of m * 1 tiles.
 * 3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 * <p>
 * Sample Input
 * 39
 * 16
 * Sample Output
 * 61
 **/
public class TilingWithMX1Tiles {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        /**
         * The idea here is same as the previous one
         * f(m,n) = f(m,n-1){placed vertically} + f(m,n-m ) {placed horizontally}
         **/

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i < m)
                dp[i] = 1;
            else if (i == m)
                dp[i] = 2;
            else
                dp[i] = dp[i - 1] + dp[i - m];
        }

        System.out.println(dp[n]);
    }
}
