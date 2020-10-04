package src.com.sid.dynamicprogramming.level2.pathsProblem;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lis-re-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number N representing number of elements.
 * 2. You are given N space separated numbers (ELE : elements).
 * 3. Your task is to find & print
 * 3.1) Length of "Longest Increasing Subsequence"(LIS).
 * 3.2) All "Longest Increasing Subsequence(s)"(LIS).
 * <p>
 * Sample Input
 * 10
 * 10 22 9 33 21 50 41 60 80 1
 * Sample Output
 * 6
 * 10 -> 22 -> 33 -> 41 -> 60 -> 80
 * 10 -> 22 -> 33 -> 50 -> 60 -> 80
 **/
public class PrintAllLongestIncreasingSubsequences {
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        int omax = 0;
        int omi = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                //We are not considering strictly increasing
                if (arr[j] <= arr[i] && dp[j] > max) {
                    max = dp[j];
                }

            }
            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
                omi = i;
            }
        }

        System.out.println(omax);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        //q.add(new Pair(omax,omi,arr[omi],arr[omi]+""));

        for (int i = 0; i < dp.length; i++) {
            if (omax == dp[i]) {
                q.add(new Pair(omax, i, arr[i], arr[i] + ""));
            }
        }

        while (!q.isEmpty()) {
            Pair rem = q.removeFirst();

            if (rem.l == 1) {
                System.out.println(rem.psf);
            }
            /**
             *Traverse and check whihc array elements can be included in
             * queue; we can travel either from starting to current element
             * or from current elelment to starting
             *
             **/

            for (int j = rem.i - 1; j >= 0; j--) {
                if (dp[j] == rem.l - 1 && arr[j] <= rem.v) {
                    q.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }

        }

    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
