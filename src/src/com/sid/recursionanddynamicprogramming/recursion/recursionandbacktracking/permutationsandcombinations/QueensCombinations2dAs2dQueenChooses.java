package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-combinations-2das2d-official/ojquestion#
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
public class QueensCombinations2dAs2dQueenChooses {

    private void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j) {

        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess[0].length; col++) {
                    if (chess[row][col] == false) {
                        System.out.print("-\t");
                    } else
                        System.out.print("q\t");
                }
                System.out.println();

            }
            System.out.println();
            return;
        }


        //two loops
        //one for remaining column of the row where the previous queen was sitting
        for (int col = j + 1; col < chess[0].length; col++) {
            if (chess[i][col] == false) {
                chess[i][col] = true;
                queensCombinations(qpsf + 1, tq, chess, i, col);
                chess[i][col] = false;
            }
        }

        //second for rows ahead of the row where previous queen was sitting
        for (int row = i + 1; row < chess.length; row++) {
            for (int col = 0; col < chess[0].length; col++) {
                if (chess[row][col] == false) {
                    chess[row][col] = true;
                    queensCombinations(qpsf + 1, tq, chess, row, col);
                    chess[row][col] = false;
                }
            }
        }


    }

    public static void main(String[] args) throws Exception {
        int n = 2;
        boolean[][] chess = new boolean[n][n];

        new QueensCombinations2dAs2dQueenChooses().queensCombinations(0, n, chess, 0, -1);
    }
}
