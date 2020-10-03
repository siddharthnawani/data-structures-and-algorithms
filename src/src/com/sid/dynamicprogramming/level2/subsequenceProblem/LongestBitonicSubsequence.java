package src.com.sid.dynamicprogramming.level2.subsequenceProblem;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lbs-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of elements.
 * 2. You are given n numbers, representing the contents of array of length n.
 * 3. You are required to print the length of longest bitonic subsequence of array.
 * Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
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
 * 7
 **/
public class LongestBitonicSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        /**
         *The idea is to calculate the longest increasing seq and longgest
         * decreasing seq. the element which would have the max sum of these
         * two would gice us the pivot.
         *
         **/


        int[] lis = new int[n];

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {

                if (arr[i] >= arr[j] && lis[j] > max) {
                    max = lis[j];
                }

            }

            lis[i] = max + 1;
        }


        int[] lds = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;

            for (int j = n - 1; j > i; j--) {

                if (arr[i] > arr[j] && lds[j] > max) {
                    max = lds[j];
                }

            }

            lds[i] = max + 1;
        }

        int omax = 0;
        for (int i = 0; i < n; i++) {

            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
            }

        }

        System.out.println(omax);


    }
}
