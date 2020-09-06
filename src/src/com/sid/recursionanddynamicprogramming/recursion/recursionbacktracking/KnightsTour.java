package src.com.sid.recursionanddynamicprogramming.recursion.recursionbacktracking;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/knights-tour-official/ojquestion
 * <p>
 * Question
 * 1. You are given a number n, the size of a chess board.
 * 2. You are given a row and a column, as a starting point for a knight piece.
 * 3. You are required to generate the all moves of a knight starting in (row, col)
 * such that knight visits
 * all cells of the board exactly once.
 * 4. Complete the body of printKnightsTour function - without changing signature - to calculate and
 * print all configurations of the chess board representing the route
 * of knight through the chess board. Use sample input and output to get more idea.
 * <p>
 * Sample Input
 * 5
 * 2
 * 0
 * <p>
 * Sample Output
 * 25 2 13 8 23
 * 12 7 24 3 14
 * 1 18 15 22 9
 * 6 11 20 17 4
 * 19 16 5 10 21
 * ..
 * .
 * .
 * . so many rows..
 **/
public class KnightsTour {
    private void printKnightsTour(int[][] chess, int row, int col, int move) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] > 0)
            return;
        else if (move == chess.length * chess[0].length) {
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
        }

        chess[row][col] = move;
        printKnightsTour(chess, row - 2, col + 1, move + 1);
        printKnightsTour(chess, row - 1, col + 2, move + 1);
        printKnightsTour(chess, row + 1, col + 2, move + 1);
        printKnightsTour(chess, row + 2, col + 1, move + 1);
        printKnightsTour(chess, row + 2, col - 1, move + 1);
        printKnightsTour(chess, row + 1, col - 2, move + 1);
        printKnightsTour(chess, row - 1, col - 2, move + 1);
        printKnightsTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    private void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] chess = new int[N][N];
        int row = 2, col = 0, move = 1;
        new KnightsTour().printKnightsTour(chess, row, col, move);
    }
}
