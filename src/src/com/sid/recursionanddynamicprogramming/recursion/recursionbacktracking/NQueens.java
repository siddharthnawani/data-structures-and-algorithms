package src.com.sid.recursionanddynamicprogramming.recursion.recursionbacktracking;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/n-queens-official/ojquestion
 * <p>
 * Question
 * 1. You are given a number n, the size of a chess board.
 * 2. You are required to place n number of queens in the n * n cells of board such that
 * no queen can kill another.
 * Note - Queens kill at distance in all 8 directions
 * 3. Complete the body of printNQueens function - without changing signature - to calculate
 * and print all safe configurations of n-queens. Use sample input and output to get more idea.
 * <p>
 * Sample Input
 * 4
 * Sample Output
 * 0-1, 1-3, 2-0, 3-2, .
 * 0-2, 1-0, 2-3, 3-1, .
 **/
public class NQueens {

    private void printNQueens(int[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.println(qsf);
            return;
        }

        for (int col = 0; col < chess[0].length; col++) {

            if (isItASafePlaceForTheQueen(chess, row, col)) {
                //place queen and check recursively if a soln is possible from this
                chess[row][col] = 1;
                //recursively explore other options
                printNQueens(chess, qsf + row + "-" + col + ",", row + 1);
                //remove the queen on the way back
                chess[row][col] = 0;
            }
        }

    }

    private boolean isItASafePlaceForTheQueen(int[][] chess, int row, int col) {
        //check in 3 directions vertically up, diagonally on left and right

        //vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (chess[i][col] == 1)
                return false;
        }
        //diagonally left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;
        }
        //diagonally right
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int row = 0, N = 4;
        int[][] chess = new int[N][N];
        String qsf = "";
        new NQueens().printNQueens(chess, qsf, row);
    }
}
