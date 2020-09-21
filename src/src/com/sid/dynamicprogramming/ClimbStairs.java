package src.com.sid.dynamicprogramming;

import java.util.Scanner;

/**
 * Question
 * 1. You are given a number n, representing the number of stairs in a staircase.
 * 2. You are on the 0th step and are required to climb to the top.
 * 3. In one move, you are allowed to climb 1, 2 or 3 stairs.
 * 4. You are required to print the number of different paths via which you can climb to the top.
 * <p>
 * Sample Input
 * 4
 * Sample Output
 * 7
 */
public class ClimbStairs {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ClimbStairs obj = new ClimbStairs();
        System.out.println(obj.pathsMemoization(n, new int[n + 1]));
        System.out.println(obj.pathsTabulation(n));

    }

    private int pathsMemoization(int n, int[] qb) {
        if (n == 0) return 1;
        else if (n < 0) return 0;

        if (qb[n] != 0) return qb[n];

        int nm1 = pathsMemoization(n - 1, qb);
        int nm2 = pathsMemoization(n - 2, qb);
        int nm3 = pathsMemoization(n - 3, qb);

        qb[n] = nm1 + nm2 + nm3;
        return qb[n];

    }

    private int pathsTabulation(int n) {

        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1)
                dp[i] = dp[i - 1];
            else if (i == 2)
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];

    }
}
