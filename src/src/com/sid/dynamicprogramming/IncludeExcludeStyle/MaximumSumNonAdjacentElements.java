package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/maximum-sum-non-adjacent-elements-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of elements.
 * 2. You are given n numbers, representing n elements.
 * 3. You are required to find the maximum sum of a subsequence with no adjacent elements.
 * <p>
 * Sample Input
 * 6
 * 5
 * 10
 * 10
 * 100
 * 5
 * 6
 * Sample Output
 * 116
 **/
public class MaximumSumNonAdjacentElements {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        int exc = 0;
        int inc = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int nexc = Math.max(exc, inc);
            int ninc = exc + arr[i];

            exc = nexc;
            inc = ninc;
        }
        System.out.println(Math.max(exc, inc));
    }
}
