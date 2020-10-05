package src.com.sid.dynamicprogramming.level2.pathsProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/zero-one-knapsack-re-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of items.
 * 2. You are given n numbers, representing the values of n items.
 * 3. You are given n numbers, representing the weights of n items.
 * 3. You are given a number "cap", which is the capacity of a bag you've.
 * 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
 * 5. Also, you have to print the indices of items that should be selected to make maximum profit.
 * 6. You have to print all such configurations.
 * <p>
 * Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
 * <p>
 * Sample Input
 * 5
 * 15 14 10 45 30
 * 2 5 1 3 4
 * 7
 * Sample Output
 * 75
 * 3 4
 */
public class PrintAllResultsIn01Knapsack {

    static class Pair {
        int i;
        int j;
        String psf;

        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j >= wts[i - 1]) {
                    if (dp[i - 1][j - wts[i - 1]] + values[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j - wts[i - 1]] + values[i - 1];
                    }
                }
            }
        }

        System.out.println(dp[n][cap]);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n, cap, ""));

        while (!q.isEmpty()) {
            Pair rem = q.removeFirst();

            if (rem.i == 0 || rem.j == 0) {
                System.out.println(rem.psf);
            } else {
                if (rem.j >= wts[rem.i - 1]) {
                    int inc = dp[rem.i - 1][rem.j - wts[rem.i - 1]] + values[rem.i - 1];
                    if (inc == dp[rem.i][rem.j]) {
                        q.add(new Pair(rem.i - 1, rem.j - wts[rem.i - 1], rem.i - 1 + " " + rem.psf));
                    }
                }

                int exc = dp[rem.i - 1][rem.j];
                if (exc == dp[rem.i][rem.j]) {
                    q.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
            }


        }


    }
}
