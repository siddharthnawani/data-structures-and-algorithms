package src.com.sid.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/walls-and-gates/
 * 286. Walls and Gates
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * Example:
 * <p>
 * Given the 2D grid:
 * <p>
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D grid should be:
 * <p>
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 **/
public class WallsandGates {
    //using bfs
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {//gate is found
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];
            for (int[] direction : dirs) {
                int _r = direction[0] + r;
                int _c = direction[1] + c;

                if (_r < 0 || _c < 0 || _r >= row || _c >= col || rooms[_r][_c] != Integer.MAX_VALUE)
                    continue;
                rooms[_r][_c] = rooms[r][c] + 1;
                q.add(new int[]{_r, _c});
            }
        }

    }
}
