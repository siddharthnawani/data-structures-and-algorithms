package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/nqueens-branch-and-bound-official/ojquestion
 * <p>
 * Question
 * 1. You are given a number n, the size of a chess board.
 * 2. You are required to place n number of queens in the n * n cells of board such that no queen can
 * kill another.
 * Note - Queens kill at distance in all 8 directions
 * 3. Complete the body of printNQueens function - without changing signature - to calculate and
 * print all safe configurations of n-queens
 * <p>
 * <p>
 * Sample Input
 * 4
 * Sample Output
 * 0-1, 1-3, 2-0, 3-2, .
 * 0-2, 1-0, 2-3, 3-1, .
 **/
public class NQueensBranchAndBound {

    private void printPath(boolean[][] board, boolean[] cols, boolean diag[], boolean rdiag[],
                           String psf, int r) {

        if (r == board.length) {
            System.out.println(psf + ".");
            return;
        }
        for (int col = 0; col < board[0].length; col++) {

            if (isthisAValidPlaceForQueen(board, cols, diag, rdiag, r, col)) {
                board[r][col] = true;
                cols[col] = true;
                diag[r + col] = true;
                rdiag[r - col + board.length - 1] = true;

                printPath(board, cols, diag, rdiag, psf + r + "-" + col + ",", r + 1);

                board[r][col] = false;
                cols[col] = false;
                diag[r + col] = false;
                rdiag[r - col + board.length - 1] = false;
            }


        }

    }

    private boolean isthisAValidPlaceForQueen(boolean[][] board, boolean[] col, boolean[] diag, boolean[] rdiag, int r, int c) {

        if (col[c] == true)
            return false;
        if (diag[r + c])
            return false;
        if (rdiag[r - c + board.length - 1])
            return false;

        return true;
    }

    public static void main(String[] args) {
        int N = 4;
        boolean[][] board = new boolean[N][N];
        boolean[] cols = new boolean[N];
        boolean[] diag = new boolean[2 * N - 1];
        boolean[] rdiag = new boolean[2 * N - 1];

        new NQueensBranchAndBound().printPath(board, cols, diag, rdiag, "", 0);

    }
}
