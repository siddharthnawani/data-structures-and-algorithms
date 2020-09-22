package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of rows.
 * 2. You are given a number m, representing the number of columns.
 * 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
 * 4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from
 * any row in the left wall.
 * 5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
 * <p>
 * Sample Input
 * 6
 * 6
 * 0 1 4 2 8 2
 * 4 3 6 5 0 4
 * 1 2 4 1 4 6
 * 2 0 7 3 2 2
 * 3 1 5 9 2 4
 * 2 7 0 8 5 1
 * Sample Output
 * 33
 */
public class Goldmine {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        /**
         *Again proceeding with tabulation method.
         * here each element represnt max gold that can be dug going
         * forward from that pos.
         *
         * Here we will start traversing from last column onwards
         * towards the first colummn.
         */
        int[][] dp = new int[r][c];

        for (int j = c - 1; j >= 0; j--) {
            for (int i = r - 1; i >= 0; i--) {

                //last col
                if (j == c - 1) {
                    dp[i][j] = arr[i][j];
                }//last row
                else if (i == r - 1) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                }//first row
                else if (i == 0) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                }//rest
                else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1],
                            Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
                }

            }
        }

        int max = dp[0][0];
        for (int i = 1; i < r; i++)
            max = Math.max(max, dp[i][0]);

        System.out.println(max);
    }
}
