package src.com.sid.dynamicprogramming.level2.pathsProblem;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/cps-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string str.
 * 2. You are required to print the count of palindromic subsequences in string str.
 * <p>
 * Sample Input
 * ccbbgd
 * Sample Output
 * 8
 **/


public class CountPalindromicSubsequences {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length();
        /**
         *The formula is :
         * PS(c1+ m + c2) =
         * if(c1==c2)
         *
         * S(c1+m) + S (mC2) +1
         *
         * if (c1 !=c2)
         *
         * S(c1+m) + PS (mC2) -S(m)
         *
         * We will fill an dp array just like LIS to find S(i)
         **/

        int[][] dp = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {

                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    /**
                     *Take the example of : ab and cc
                     *
                     * ab : a, b ==> 2
                     * cc : c , c , cc  ==>3
                     *
                     */
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                } else {

                    if (str.charAt(i) == str.charAt(j)) {
                        //prefix + suffix +1
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
                    } else {
                        //prefix + suffix - s(middle part)
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }

            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
