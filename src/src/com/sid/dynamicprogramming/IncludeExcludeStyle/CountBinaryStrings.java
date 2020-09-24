package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-binary-strings-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n.
 * 2. You are required to print the number of binary strings of length n with no consecutive 0's.
 * <p>
 * Sample Input
 * 6
 * Sample Output
 * 21
 **/
public class CountBinaryStrings {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        /**
         *Here the idea is to create an array such that at each point we
         * calculate the longest string ending with 0 with dp0 and 1 with
         * dp1. Once we iterate for next element we know that for building
         * dp1[i] we have to add dp1[i-1] and dp0[i-1] bcoz bth of them
         * will contribute but for dp0[i] only dp1[i-1] will contribute
         * withou violating the rules
         *
         *
         **/

        //Method 1
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];

        dp0[1] = 1; // its 0
        dp1[1] = 1; // its 1

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp1[i - 1];
            dp1[i] = dp0[i - 1] + dp1[i - 1];
        }

        System.out.println(dp0[n]+dp1[n]);

        //method 2

        int old0 = 1, old1 = 1;

        for (int i = 2; i <= n; i++) {
            int new0 = old1;
            int new1 = old0 + old1;

            old0 = new0;
            old1 = new1;
        }


        System.out.println(old0 + old1);

    }
}
