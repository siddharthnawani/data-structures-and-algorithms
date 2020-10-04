package src.com.sid.dynamicprogramming.level2.pathsProblem;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-jumps-re-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number N representing number of elements.
 * 2. You are given N space separated numbers (ELE : elements).
 * 3. Your task is to find & print
 * 3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
 * 3.2) all configurations of "MINIMUM JUMPS".
 * <p>
 * Sample Input
 * 10
 * 3
 * 3
 * 0
 * 2
 * 1
 * 2
 * 4
 * 2
 * 0
 * 0
 * Sample Output
 * 4
 * 0 -> 3 -> 5 -> 6 -> 9 .
 * 0 -> 3 -> 5 -> 7 -> 9 .
 **/
public class PrintAllPathsWithMinimumJumps {

    static class Pair {
        int i;
        int s;
        int j;
        String psf;

        Pair(int i, int s, int j, String psf) {
            this.i = i;
            this.s = s;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void Solution(int arr[]) {

        int n = arr.length;
        Integer[] dp = new Integer[n];

        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {

            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < n; j++) {

                if (dp[i + j] != null && dp[i + j] < min) {
                    min = dp[i + j];
                }

            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }

        System.out.println(dp[0]);

        //Traverse path using BFS
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, arr[0], dp[0], 0 + ""));

        while (!q.isEmpty()) {

            Pair rem = q.removeFirst();

            if (rem.j == 0) {
                System.out.println(rem.psf + " .");
            }

            for (int j = 1; j <= rem.s && rem.i + j < dp.length; j++) {

                int ci = rem.i + j;

                if (dp[ci] != null && dp[ci] == rem.j - 1) {
                    q.add(new Pair(ci, arr[ci], dp[ci], rem.psf + " -> " + ci));
                }

            }

        }


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
