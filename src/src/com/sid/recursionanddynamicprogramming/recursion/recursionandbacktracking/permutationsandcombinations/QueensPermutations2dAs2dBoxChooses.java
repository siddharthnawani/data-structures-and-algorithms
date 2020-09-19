package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-permutations-2das2d-box-chooses-official/ojquestion#
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
 * <p>
 * q1	-
 * q2	-
 * <p>
 * <p>
 * q1	-
 * -	q2
 * <p>
 * <p>
 * q2	q1
 * -	-
 * <p>
 * <p>
 * q2	-
 * q1	-
 * <p>
 * <p>
 * q2	-
 * -	q1
 * <p>
 * <p>
 * -	q1
 * q2	-
 * <p>
 * <p>
 * -	q1
 * -	q2
 * <p>
 * <p>
 * -	q2
 * q1	-
 * <p>
 * <p>
 * -	q2
 * -	q1
 * <p>
 * <p>
 * -	-
 * q1	q2
 * <p>
 * <p>
 * -	-
 * q2	q1
 */
public class QueensPermutations2dAs2dBoxChooses {

    private void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
                System.out.println();
            }
            return;
        }


        //Level : boxes, Options : Queens
        int nr = 0;
        int nc = 0;
        char sep = '\0';
        if (col == tq - 1) {
            nr = row + 1;
            nc = 0;
            sep = '\n';
        } else {
            nr = row;
            nc = col + 1;
            sep = '\t';

        }

        //either place a queen on a box
        for (int i = 0; i < queens.length; i++) {
            if (queens[i] == false) {
                queens[i] = true;
                queensPermutations(qpsf + 1, tq, nr, nc, asf + "q" + (i + 1) + sep, queens);
                queens[i] = false;
            }
        }

        //let the box be empty
        queensPermutations(qpsf, tq, nr, nc, asf + "-" + sep, queens);


    }

    public static void main(String[] args) throws Exception {

        int n = 2;
        boolean[] queens = new boolean[n];

        new QueensPermutations2dAs2dBoxChooses().queensPermutations(0, n, 0, 0, "", queens);
    }
}
