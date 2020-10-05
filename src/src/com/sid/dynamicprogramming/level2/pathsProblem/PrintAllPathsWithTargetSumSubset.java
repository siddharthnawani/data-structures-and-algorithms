package src.com.sid.dynamicprogramming.level2.pathsProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/print-all-paths-with-target-sum-subset-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of elements.
 * 2. You are given n numbers.
 * 3. You are given a number "tar".
 * 4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
 * 5. Also, you have to print the indices of elements that should be selected to achieve the given target.
 * 6. You have to print all such configurations.
 * <p>
 * Sample Input
 * 5
 * 4
 * 2
 * 7
 * 1
 * 3
 * 10
 * Sample Output
 * true
 * 2 4
 * 1 2 3
 * 0 1 3 4
 */
public class PrintAllPathsWithTargetSumSubset {
    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[arr.length + 1][tar + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        if (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]]) {
                            dp[i][j] = true;
                        }
                    }
                }

            }
        }

        System.out.println(dp[arr.length][tar]);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(arr.length, tar, ""));

        while (!q.isEmpty()) {
            Pair rem = q.removeFirst();

            if (rem.i == 0 || rem.j == 0) {
                System.out.println(rem.psf);
            } else {
                //we should not go out of the array
                if (rem.j >= arr[rem.i - 1]) {
                    boolean inc = dp[rem.i - 1][rem.j - arr[rem.i - 1]];
                    if (inc) {
                        q.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], rem.i - 1 + " " + rem.psf));
                    }
                }

                boolean exc = dp[rem.i - 1][rem.j];
                if (exc) {
                    q.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }


            }
        }
    }
}
