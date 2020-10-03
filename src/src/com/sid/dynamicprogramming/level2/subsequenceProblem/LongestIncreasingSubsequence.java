package src.com.sid.dynamicprogramming.level2.subsequenceProblem;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lis-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of elements.
 * 2. You are given n numbers, representing the contents of array of length n.
 * 3. You are required to print the length of longest increasing subsequence of array.
 * <p>
 * Sample Input
 * 10
 * 10
 * 22
 * 9
 * 33
 * 21
 * 50
 * 41
 * 60
 * 80
 * 1
 * Sample Output
 * 6
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] dp = new int[n];

        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                }
            }

            dp[i] = max + 1;

            if (dp[i] > maxSoFar) {
                maxSoFar = dp[i];
            }
        }

        System.out.println(maxSoFar);

    }
}
