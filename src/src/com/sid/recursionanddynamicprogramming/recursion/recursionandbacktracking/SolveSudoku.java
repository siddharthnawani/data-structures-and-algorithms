package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/solve-sudoku-official/ojquestion
 * <p>
 * Question
 * 1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
 * 2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
 * Rule 1 -> Digits from 1-9 must occur exactly once in each row.
 * Rule 2 -> Digits from 1-9 must occur exactly once in each column.
 * Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.
 * <p>
 * Assumption -> The given Sudoku puzzle will have a single unique solution.
 * <p>
 * 3 0 6 5 0 8 4 0 0
 * 5 2 0 0 0 0 0 0 0
 * 0 8 7 0 0 0 0 3 1
 * 0 0 3 0 1 0 0 8 0
 * 9 0 0 8 6 3 0 0 5
 * 0 5 0 0 9 0 6 0 0
 * 1 3 0 0 0 0 2 5 0
 * 0 0 0 0 0 0 0 7 4
 * 0 0 5 2 0 6 3 0 0
 * Sample Output
 * 3 1 6 5 7 8 4 9 2
 * 5 2 9 1 3 4 7 6 8
 * 4 8 7 6 2 9 5 3 1
 * 2 6 3 4 1 5 9 8 7
 * 9 7 4 8 6 3 1 2 5
 * 8 5 1 7 9 2 6 4 3
 * 1 3 8 9 4 7 2 5 6
 * 6 9 2 3 5 1 8 7 4
 * 7 4 5 2 8 6 3 1 9
 */
public class SolveSudoku {


    private void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void solveSudoku(int[][] board, int i, int j) {

        if (i == board.length) {
            display(board);
            return;
        }

        int ni = 0;
        int nj = 0;
        //we are at the end of a column
        if (j == board[0].length - 1) {
            nj = 0;
            ni = i + 1;
        } else {
            nj = j + 1;
            ni = i;
        }
        if (board[i][j] != 0) {//if this place is already filled proceed further
            solveSudoku(board, ni, nj);
        } else {//else solve for all probable options
            for (int val = 1; val <= 9; val++) {
                if (isValidValue(board, i, j, val)) {
                    board[i][j] = val;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }

            }
        }


    }

    private boolean isValidValue(int[][] board, int i, int j, int val) {
        //check in row
        for (int row = 0; row < board.length; row++) {
            if (board[row][j] == val)
                return false;
        }
        //check in column
        for (int col = 0; col < board[0].length; col++) {
            if (board[i][col] == val)
                return false;
        }
        //check in 3 X 3 matrix
        int smi = (i / 3) * 3;
        int smj = (j / 3) * 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[smi + row][smj + col] == val)
                    return false;
            }
        }
        return true;

    }

    public static void main(String[] args) throws Exception {
        int[][] arr = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        new SolveSudoku().solveSudoku(arr, 0, 0);
    }
}
