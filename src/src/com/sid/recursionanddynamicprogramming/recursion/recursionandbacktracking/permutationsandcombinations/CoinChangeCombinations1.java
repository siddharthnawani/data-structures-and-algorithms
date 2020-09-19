package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/coin-change-combinations-1-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the count of coins.
 * 2. You are given n numbers, representing the denominations of n coins.
 * 3. You are given a number "amt".
 * 4. You are required to calculate and print the combinations of the n coins (non-duplicate) using
 * which the amount "amt" can be paid.
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
 * 2-3-7-.
 * 5-7-.
 */
public class CoinChangeCombinations1 {
    private void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {

        if (i == coins.length) {

            if (amtsf == tamt)
                System.out.println(asf + ".");

            return;
        }

        //either include or exclude the coin
        coinChange(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        coinChange(i + 1, coins, amtsf, tamt, asf);
    }

    public static void main(String[] args) throws Exception {

        int n = 5;
        int[] coins = {2,
                3,
                5,
                6,
                7};

        int amt = 12;

        new CoinChangeCombinations1().coinChange(0, coins, 0, amt, "");
    }
}
