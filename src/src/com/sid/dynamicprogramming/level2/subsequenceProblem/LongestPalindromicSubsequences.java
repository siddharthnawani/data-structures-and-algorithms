package src.com.sid.dynamicprogramming.level2.subsequenceProblem;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lps-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string str.
 * 2. You are required to print the length of longest palindromic subsequence of string str.
 * <p>
 * Sample Input
 * abcgackbc
 * Sample Output
 * 5
 **/
public class LongestPalindromicSubsequences {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length();

        /**
         *As done in the previous question as well, the longest Palindromic
         * Subsequence can be derived from
         *
         * LPS (c1+m+c2) =
         *
         * if(c1==c2)
         *   LPS(m) + 2;
         *
         * if c1 !=c2
         *   Max (LPS(c1m),LPS(mc2) )
         **/

        int[][] dp = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                } else {
                    if (str.charAt(i) == str.charAt(j))
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    else
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
