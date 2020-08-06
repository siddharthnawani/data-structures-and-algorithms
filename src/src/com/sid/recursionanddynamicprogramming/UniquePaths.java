package src.com.sid.recursionanddynamicprogramming;

/**
 *
 *62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 * **/

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    int getWaysByTabulation(int si, int sj, int ei, int ej) {
        int[][] dp = new int[ei][ej];

        for (int i = ei - 1; i >= 0; i--) {
            for (int j = ej - 1; j >= 0; j--) {

                if (i == ei - 1 || j == ej - 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    int getWaysByRecursion(int si, int sj, int ei, int ej) {
        if (si == ei && sj == ej)
            return 1;
        if (si > ei || sj > ej) return 0;
        int op1 = getWaysByRecursion(si + 1, sj, ei, ej);
        int op2 = getWaysByRecursion(si, sj + 1, ei, ej);
        return op1 + op2;
    }

    int getWaysByMemoization(int si, int sj, int ei, int ej, Map<String, Integer> hm) {
        if (si == ei && sj == ej) return 1;
        if (si > ei || sj > ej) return 0;

        String key = si + "#" + sj;
        if (hm.containsKey(key))
            return hm.get(key);

        int op1 = getWaysByMemoization(si + 1, sj, ei, ej, hm);
        int op2 = getWaysByMemoization(si, sj + 1, ei, ej, hm);
        hm.put(key, op1 + op2);

        return op1 + op2;

    }

    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.println(new UniquePaths().getWaysByRecursion(0, 0, m - 1, n - 1));
        System.out.println(new UniquePaths().getWaysByMemoization(0, 0, m - 1, n - 1, new HashMap<>()));
        System.out.println(new UniquePaths().getWaysByTabulation(0, 0, m, n));
    }


}
