package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/nqueens-permutations-2das1d-official-queen-chooses/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the size of a n * n chess board.
 * 2. You are required to calculate and print the permutations in which n queens (distinct) can be
 * placed on the n * n chess-board.
 * 3. No queen shall be able to kill another.
 * <p>
 * Sample Input
 * 4
 * Sample Output
 * -	q1	-	-
 * -	-	-	q2
 * q3	-	-	-
 * -	-	q4	-
 * <p>
 * ......
 * ....
 * ....
 */
public class NqueensPermutations2dAs1dQueenChooses {
    private boolean IsQueenSafe(int[][] chess, int row, int col) {
        // vertical
        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = col; i < chess.length; i++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        // horizontal
        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = col; j < chess.length; j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        // diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = col; i < chess.length && j < chess.length; i++, j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        // anti-diagonal
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = col; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        return true;
    }

    private void nqueens(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] > 0 ? "q" + chess[row][col] + "\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }


        //try putting each queen in every cell
        for (int cell = 0; cell < chess.length * chess.length; cell++) {
            int row = cell / chess.length;
            int col = cell % chess.length;

            if (chess[row][col] == 0 && IsQueenSafe(chess, row, col)) {
                chess[row][col] = qpsf + 1;
                nqueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;

            }
        }
    }

    public static void main(String[] args) throws Exception {

        int n = 4;
        int[][] chess = new int[n][n];

        new NqueensPermutations2dAs1dQueenChooses().nqueens(0, n, chess);
    }
}
