package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/nqueens-combinations-2das1d-queen-chooses-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the size of a n * n chess board.
 * 2. You are required to calculate and print the combinations in which n queens can be placed on the
 * n * n chess-board.
 * 3. No queen shall be able to kill another.
 * <p>
 * Sample Input
 * 4
 * Sample Output
 * -	q	-	-
 * -	-	-	q
 * q	-	-	-
 * -	-	q	-
 * <p>
 * -	-	q	-
 * q	-	-	-
 * -	-	-	q
 * -	q	-	-
 */
public class NqueensCombinations2dAs1dQueenChooses {

    private boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // check in 4 direction

        //vertically up
        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j])
                return false;
        }

        //horizontally downwards
        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j])
                return false;
        }

        //left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j])
                return false;
        }

        //right diagonal
        for (int i = row, j = col; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j])
                return false;
        }

        return true;
    }

    private void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int n = 4;
        boolean[][] chess = new boolean[n][n];

        new NqueensCombinations2dAs1dQueenChooses().nqueens(0, n, chess, -1);
    }
}
