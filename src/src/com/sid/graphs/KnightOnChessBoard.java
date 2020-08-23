package src.com.sid.graphs;

import java.util.LinkedList;
import java.util.Queue;

/***
 * https://www.interviewbit.com/problems/knight-on-chess-board/
 *
 * Given any source point, (C, D) and destination point, (E, F) on a chess board, we need to find whether Knight can move to the destination or not.
 * The above figure details the movements for a knight ( 8 possibilities ).
 *
 * If yes, then what would be the minimum number of steps for the knight to move to the said point.
 * If knight can not move from the source point to the destination point, then return -1.
 *
 * Note: A knight cannot go out of the board.
 *
 *
 *
 * Input Format:
 *
 * The first argument of input contains an integer A.
 * The second argument of input contains an integer B.
 *     => The chessboard is of size A x B.
 * The third argument of input contains an integer C.
 * The fourth argument of input contains an integer D.
 *     => The Knight is initially at position (C, D).
 * The fifth argument of input contains an integer E.
 * The sixth argument of input contains an integer F.
 *     => The Knight wants to reach position (E, F).
 *     Output Format:
 *
 * If it is possible to reach the destination point, return the minimum number of moves.
 * Else return -1.
 * Constraints:
 *
 * 1 <= A, B <= 500
 * Example
 *
 * Input 1:
 *     A = 8
 *     B = 8
 *     C = 1
 *     D = 1
 *     E = 8
 *     F = 8
 *
 * Output 1:
 *     6
 *
 * Explanation 1:
 *     The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 *     The minimum number of moves required for this is 6.
 *
 *
 * **/
public class KnightOnChessBoard {

    class Coordinate {
        int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
        int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
        boolean[][] visited = new boolean[N + 1][M + 1];
        Queue<Coordinate> q = new LinkedList<>();
        int moveCount = 0;
        q.add(new Coordinate(x1, y1));
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Coordinate currPos = q.poll();
                if (currPos.x == x2 && currPos.y == y2)
                    return moveCount;
                for (int i = 0; i < 8; i++) {
                    if (isValid(currPos.x + dx[i], currPos.y + dy[i], N, M) &&
                            !visited[currPos.x + dx[i]][currPos.y + dy[i]]) {
                        q.add(new Coordinate(currPos.x + dx[i], currPos.y + dy[i]));
                        visited[currPos.x + dx[i]][currPos.y + dy[i]] = true;
                    }
                }
            }
            moveCount++;
        }
        return -1;

    }

    private boolean isValid(int x, int y, int N, int M) {
        if (x <= 0 || y <= 0 || x > N || y > M)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int N = 8, M = 8, x1 = 1, y1 = 1, x2 = 8, y2 = 8;
        System.out.println(new KnightOnChessBoard().knight(N, M, x1, y1, x2, y2));
    }
}
