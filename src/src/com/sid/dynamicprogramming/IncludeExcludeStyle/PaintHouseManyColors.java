package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-many-colors-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
 * 2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
 * 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
 * <p>
 * Sample Input
 * 4 3
 * 1 5 7
 * 5 8 4
 * 3 2 9
 * 1 2 4
 * Sample Output
 * 8
 **/
public class PaintHouseManyColors {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[][] arr = new int[n][c];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = in.nextInt();
        }

        int[][] dp = new int[n][c];
        new PaintHouseManyColors().solveUsingNCube(dp[n - 1], c, arr, dp);
        new PaintHouseManyColors().solveUsingNSquare(c, arr, dp);

    }

    private void solveUsingNSquare(int c, int[][] arr, int[][] dp) {
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for (int j = 0; j < c; j++) {

            dp[0][j] = arr[0][j];

            if (arr[0][j] <= least) {
                sleast = least;
                least = arr[0][j];

            } else if (arr[0][j] <= sleast) {
                sleast = arr[0][j];
            }
        }


        for (int i = 1; i < arr.length; i++) {

            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;

            for (int j = 0; j < arr[0].length; j++) {

                if (least == dp[i - 1][j]) {
                    dp[i][j] = arr[i][j] + sleast;
                } else {
                    dp[i][j] = arr[i][j] + least;
                }

                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];

                } else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }

            }
            least = nleast;
            sleast = nsleast;

        }

        System.out.println(least);
    }

    private void solveUsingNCube(int[] ints, int c, int[][] arr, int[][] dp) {
        for (int j = 0; j < c; j++)
            dp[0][j] = arr[0][j];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < dp[0].length; k++) {
                    if (j != k) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < dp[0].length; k++) {
            min = Math.min(min, ints[k]);
        }
        System.out.println(min);
    }
}
