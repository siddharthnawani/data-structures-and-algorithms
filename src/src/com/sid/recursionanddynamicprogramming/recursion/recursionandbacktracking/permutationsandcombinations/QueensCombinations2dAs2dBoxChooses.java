package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-combinations-2das2d-box-chooses-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the size of a n * n chess board.
 * 2. You are required to calculate and print the combinations in which n queens can be placed on the
 * n * n chess-board.
 * <p>
 * Sample Input
 * 2
 * Sample Output
 * qq
 * --
 * <p>
 * q-
 * q-
 * <p>
 * q-
 * -q
 * <p>
 * -q
 * q-
 * <p>
 * -q
 * -q
 * <p>
 * --
 * qq
 */
public class QueensCombinations2dAs2dBoxChooses {

    private void queensCombinations(int qpsf, int tq, int row, int col, String asf) {

        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }

        int nr = 0;
        int nc = 0;

        String yasf = "";
        String nasf = "";

        if (col == tq - 1) {
            nr = row + 1;
            nc = 0;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        } else {
            nr = row;
            nc = col + 1;
            yasf = asf + "q";
            nasf = asf + "-";
        }

        //Like other combination questions we have 2 probability
        //place queen in box or not
        queensCombinations(qpsf + 1, tq, nr, nc, yasf);
        queensCombinations(qpsf, tq, nr, nc, nasf);


    }

    public static void main(String[] args) throws Exception {
        int n = 2;

        new QueensCombinations2dAs2dBoxChooses().queensCombinations(0, n, 0, 0, "");
    }
}
