package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/nknights-combinations-2das1d-knight-chooses-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the size of a n * n chess board.
 * 2. You are required to calculate and print the combinations in which n knights can be placed on the
 * n * n chess-board.
 * 3. No knight shall be able to kill another.
 * <p>
 * Sample Input
 * 2
 * Sample Output
 * k	k
 * -	-
 * <p>
 * k	-
 * k	-
 * <p>
 * k	-
 * -	k
 * <p>
 * -	k
 * k	-
 * <p>
 * -	k
 * -	k
 * <p>
 * -	-
 * k	k
 */
public class NknightsCombinations2dAs1dKnightChooses {

    private boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        if (i - 1 >= 0 && j - 2 >= 0 && chess[i - 1][j - 2]) {
            return false;
        }

        if (i - 2 >= 0 && j - 1 >= 0 && chess[i - 2][j - 1]) {
            return false;
        }

        if (i - 2 >= 0 && j + 1 < chess.length && chess[i - 2][j + 1]) {
            return false;
        }

        if (i - 1 >= 0 && j + 2 < chess.length && chess[i - 1][j + 2]) {
            return false;
        }

        return true;
    }

    private void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 2;
        boolean[][] chess = new boolean[n][n];

        new NknightsCombinations2dAs1dKnightChooses().nknights(0, n, chess, -1);
    }
}
