package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/coin-change-combinations-2-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of coins.
 * 2. You are given n numbers, representing the denominations of n coins.
 * 3. You are given a number "amt".
 * 4. You are required to calculate and print the combinations of the n coins (same coin can be used
 * again any number of times) using which the amount "amt" can be paid.
 * <p>
 * Sample Input
 * 5
 * 2
 * 3
 * 5
 * 6
 * 7
 * 12
 * Sample Output
 * 2-2-2-2-2-2-.
 * 2-2-2-3-3-.
 * 2-2-2-6-.
 * 2-2-3-5-.
 * 2-3-7-.
 * 2-5-5-.
 * 3-3-3-3-.
 * 3-3-6-.
 * 5-7-.
 * 6-6-.
 */
public class CoinChangeCombinations2 {

    private void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {

        if (i == coins.length) {
            if (amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }

        //check how many max number of times a particular coin can be used
        for (int j = (tamt - amtsf) / coins[i]; j >= 1; j--) {
            String part = "";
            for (int k = 0; k < j; k++)
                part += coins[i] + "-";

            coinChange(i + 1, coins, amtsf + coins[i] * j, tamt, asf + part);

        }

        //coin can be excluded as well
        coinChange(i + 1, coins, amtsf, tamt, asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        new CoinChangeCombinations2().coinChange(0, coins, 0, amt, "");
    }
}
