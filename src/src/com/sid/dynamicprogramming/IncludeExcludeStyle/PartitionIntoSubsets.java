package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/partition-into-subsets-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of elements.
 * 2. You are given a number k, representing the number of subsets.
 * 3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
 * E.g.
 * For n = 4 and k = 3 total ways is 6
 * 12-3-4
 * 1-23-4
 * 13-2-4
 * 14-2-3
 * 1-24-3
 * 1-2-34
 * <p>
 * Sample Input
 * 4
 * 3
 * Sample Output
 * 6
 */
public class PartitionIntoSubsets {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //players
        int k = in.nextInt(); //teams

        /**
         *The idea is to calculate the solution for smalle subproblems and
         * come up with a formaula for dp.
         *
         * the last element has 2 choices :
         * it can ask the previous elements to make k teams and then
         * he can attach itself with all the teams.
         *  so total cobination : f(n-1,k) *k
         * because it can go with every team.
         *
         * it can ask previous elements to make k-1 team and then
         * make a separate tea for itself.
         *
         * so total cobination : f(n-1,k-1)
         *
         **/
        if (n == 0 || k == 0 || n < k) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[k + 1][n + 1];

        /**
         * 1st row and 1st col will be 0 i.e. : n==0 || k==0 dp = 0
         *
         * n < k dp is 0; if the no of person is less than team size
         *
         * n==k dp =1;
         *
         * else
         *
         * formula : f(n,k) = f(n-1,k) *K + f(n-1, k-1) ;
         *
         **/

        for (int t = 1; t <= k; t++) {
            for (int p = 1; p <= n; p++) {
                if (p < t)
                    dp[t][p] = 0;
                else if (p == t)
                    dp[t][p] = 1;
                else
                    dp[t][p] = dp[t][p - 1] * t + dp[t - 1][p - 1];


            }
        }

        System.out.println(dp[k][n]);
    }
}
