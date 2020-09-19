package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * Theory :
 * <p>
 * Arrays conversion :
 * <p>
 * for 4 X 4 matrix
 * 1d to 2d
 * rno= cellno / 4
 * cno=cellno % 4
 * <p>
 * 2d to 1d :
 * <p>
 * cellno(r,c) = r*4 + c
 * <p>
 * <p>
 * --------------------
 * <p>
 * Question
 * 1. You are given a number n, representing the size of a n * n chess board.
 * 2. You are required to calculate and print the combinations in which n queens can be placed on the
 * n * n chess-board.
 * <p>
 * Sample Input
 * 2
 * Sample Output
 * q	q
 * -	-
 * <p>
 * q	-
 * q	-
 * <p>
 * q	-
 * -	q
 * <p>
 * -	q
 * q	-
 * <p>
 * -	q
 * -	q
 * <p>
 * -	-
 * q	q
 */
public class QueensCombinations2dAs1dQueenChooses {

    private void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
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


        for (int cell = lcno + 1; cell < chess.length * chess.length; cell++) {
            int row = cell / chess.length;
            int col = cell % chess.length;

            chess[row][col] = true;
            queensCombinations(qpsf + 1, tq, chess, cell);
            chess[row][col] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        int n = 2;
        boolean[][] chess = new boolean[n][n];

        new QueensCombinations2dAs1dQueenChooses().queensCombinations(0, n, chess, -1);
    }
}
