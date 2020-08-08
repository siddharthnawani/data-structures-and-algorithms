package src.com.sid.recursionanddynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * <p>
 * int val[] = new int[] { 60, 100, 120 };
 * int wt[] = new int[] { 10, 20, 30 };
 * int W = 50;
 * <p>
 * Answer : 220
 * <p>
 * <p>
 * //Amazing article on knapsck DP
 * https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf
 **/

public class KnapsackProblem {

    private int knapsackByRecursion(int[] weights, int[] values, int maxweight) {

        return knapsackByRecursion(weights, values, maxweight, 0);
    }

    private int knapsackByRecursion(int[] weights, int[] values, int maxweight, int i) {
        if (i == weights.length || maxweight == 0)
            return 0;
        if (weights[i] > maxweight) //skip if the current weight cannot be accommodated
            return knapsackByRecursion(weights, values, maxweight, i + 1);
        else {
            int op1 = values[i] + knapsackByRecursion(weights, values, maxweight - weights[i], i + 1);
            int op2 = knapsackByRecursion(weights, values, maxweight, i + 1);

            return Math.max(op1, op2);
        }
    }

    private int knapsackByMemoization(int[] weights, int[] values, int maxweight) {
        Map<String, Integer> mhm = new HashMap<>();
        return knapsackByMemoization(weights, values, maxweight, 0, mhm);
    }

    private int knapsackByMemoization(int[] weights, int[] values, int maxweight, int i, Map<String, Integer> mhm) {
        if (i == weights.length || maxweight == 0)
            return 0;

        String key = maxweight + "#" + i;
        if (mhm.containsKey(key))
            return mhm.get(key);
        if (weights[i] > maxweight)
            return knapsackByMemoization(weights, values, maxweight, i + 1, mhm);
        else {
            int op1 = values[i] + knapsackByMemoization(weights, values, maxweight - weights[i], i + 1, mhm);
            int op2 = knapsackByMemoization(weights, values, maxweight, i + 1, mhm);

            mhm.put(key, Math.max(op1, op2));
            return Math.max(op1, op2);
        }
    }

    private int knapsackByTabulation(int[] weights, int[] values, int maxweight) {

        int r = weights.length + 1;
        int c = maxweight + 1;
        int[][] dp = new int[r][c];

        for (int item = 0; item < r; item++) {
            for (int capacity = 0; capacity < c; capacity++) {
                if (item == 0 || capacity == 0) //base case when either knapsack capacity is 0 or No item is selected.
                    dp[item][capacity] = 0;
                else {
                    int maxValWithoutCurr = dp[item - 1][capacity]; //This is guaranteed to exist
                    int maxValWithCurr = 0; // We initialize this value to 0
                    int weightOfCurr = weights[item - 1]; // We use item -1 to account for the extra row at the top

                    if (capacity >= weightOfCurr) {
                        maxValWithCurr = values[item - 1]; // If so, maxValWithCurr is at least the value of the current item
                        int remainingCapacity = capacity - weightOfCurr;
                        maxValWithCurr += dp[item - 1][remainingCapacity]; //Add the maximum value obtainable with the remaining capacity
                    }

                    dp[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); //Pick the larger of the two

                }

            }
        }

        return dp[r - 1][c - 1];

    }

    public static void main(String[] args) {

        int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int maxweight = 50;

        System.out.println(new KnapsackProblem().knapsackByRecursion(weights, values, maxweight));
        System.out.println(new KnapsackProblem().knapsackByMemoization(weights, values, maxweight));
        System.out.println(new KnapsackProblem().knapsackByTabulation(weights, values, maxweight));
    }
}
