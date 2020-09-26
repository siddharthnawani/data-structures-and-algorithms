package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling1-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
 * 2. You've an infinite supply of 2 * 1 tiles.
 * 3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 * <p>
 * Sample Input
 * 8
 * Sample Output
 * 34
 **/
public class TilingWith2X1Tiles {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        /**
         *The idea is to break the problem into smaller pieces
         *
         * the n size can be places in two ways either
         * horizontally or vertically;
         * solving further you will know that
         * f(n) = f(n-1)+f(n-1)
         *
         **/
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        System.out.println(dp[n]);

    }
}
