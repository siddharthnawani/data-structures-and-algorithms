package src.com.sid.dynamicprogramming.level2.subsequenceProblem;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/msis-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of elements.
 * 2. You are given n numbers, representing the contents of array of length n.
 * 3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
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
 * 255
 **/
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int maxsofar = Integer.MIN_VALUE;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            /**
             * Here Integer is taken as there could be negative numbers as well
             **/
            Integer max = null;

            for (int j = 0; j < i; j++) {

                if (arr[i] >= arr[j]) {
                    if (max == null) {
                        max = dp[j];
                    } else if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            if (max == null)
                dp[i] = arr[i];
            else
                dp[i] = max + arr[i];

            if (dp[i] > maxsofar)
                maxsofar = dp[i];
        }

        System.out.println(maxsofar);


    }
}
