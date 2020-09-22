package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/min-cost-maze-traversal-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of rows.
 * 2. You are given a number m, representing the number of columns.
 * 3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
 * 4. You are standing in top-left cell and are required to move to bottom-right cell.
 * 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
 * 6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-
 * right cell).
 * 7. You are required to traverse through the matrix and print the cost of path which is least costly.
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
 * 23
 */
public class MinCostInMazeTraversal {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();

        int arr[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int dp[][] = new int[r][c];

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {

                if (i == r - 1 && j == c - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == r - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (j == c - 1) {
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }

            }
        }

        System.out.println(dp[0][0]);
    }
}
