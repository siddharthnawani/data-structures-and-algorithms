package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/friends-pairing-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of friends.
 * 2. Each friend can stay single or pair up with any of it's friends.
 * 3. You are required to print the number of ways in which these friends can stay single or pair up.
 * E.g.
 * 1 person can stay single or pair up in 1 way.
 * 2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
 * 3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.
 * <p>
 * Sample Input
 * 4
 * Sample Output
 * 10
 */
public class FriendsPairing {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        /**
         *The idea is that 1 element has following choices:
         *
         * either it go alone and request the paring for n-1 elements {f(n-1)}
         *
         * or pair up with remaining n-1 elements and ask for the pairing
         * of n-2 remaining elements after pairing with one element{(n-1)* f(n-2)}
         *
         * f(n)= fn(n-1) + (n-1) * f(n-2);
         *
         **/
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];

        System.out.println(dp[n]);
    }
}
