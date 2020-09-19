package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-permutations-2das2d-queen-chooses-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the size of a n * n chess board.
 * 2. You are required to calculate and print the permutations in which n queens can be placed on the
 * n * n chess-board.
 * <p>
 * Sample Input
 * 2
 * Sample Output
 * q1	q2
 * -	-
 * <p>
 * q1	-
 * q2	-
 * <p>
 * q1	-
 * -	q2
 * <p>
 * q2	q1
 * -	-
 * <p>
 * -	q1
 * q2	-
 * <p>
 * -	q1
 * -	q2
 * <p>
 * q2	-
 * q1	-
 * <p>
 * -	q2
 * q1	-
 * <p>
 * -	-
 * q1	q2
 * <p>
 * q2	-
 * -	q1
 * <p>
 * -	q2
 * -	q1
 * <p>
 * -	-
 * q2	q1
 */
public class QueensPermutations2dAs2dQueenChooses {

    private void queensPermutations(int qpsf, int tq, int[][] chess) {

        if (qpsf == tq) {

            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if (chess[i][j] == 0) {
                        System.out.print("-\t");
                    } else
                        System.out.print("q" + chess[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println();
            return;

        }

        //Place distinct queen at every possible box and recursivly try to place other queens
        // Levels : queens Options : chess board

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if (chess[i][j] == 0) {
                    chess[i][j] = qpsf + 1;
                    queensPermutations(qpsf + 1, tq, chess);
                    chess[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        int n = 2;
        int[][] chess = new int[n][n];

        new QueensPermutations2dAs2dQueenChooses().queensPermutations(0, n, chess);
    }
}
