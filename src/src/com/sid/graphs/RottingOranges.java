package src.com.sid.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 **/
public class RottingOranges {

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int total = 0, rotten = 0, size = 0, time = 0;
        Queue<Pair> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) total++;
                if (grid[i][j] == 2) q.offer(new Pair(i, j));
            }
        }
        if (total == 0) return time;
        while (!q.isEmpty()) {
            size = q.size();
            rotten += size;
            if (rotten == total)
                return time;

            time++;
            for (int i = 0; i < size; i++) {
                Pair t = q.poll();

                if (t.x + 1 < r && grid[t.x + 1][t.y] == 1) {
                    grid[t.x + 1][t.y] = 2;
                    q.add(new Pair(t.x + 1, t.y));
                }
                if (t.x - 1 >= 0 && grid[t.x - 1][t.y] == 1) {
                    grid[t.x - 1][t.y] = 2;
                    q.add(new Pair(t.x - 1, t.y));
                }
                if (t.y + 1 < c && grid[t.x][t.y + 1] == 1) {
                    grid[t.x][t.y + 1] = 2;
                    q.add(new Pair(t.x, t.y + 1));
                }
                if (t.y - 1 >= 0 && grid[t.x][t.y - 1] == 1) {
                    grid[t.x][t.y - 1] = 2;
                    q.add(new Pair(t.x, t.y - 1));
                }

            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid =
                {
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                };
        System.out.println(new RottingOranges().orangesRotting(grid));
    }

}
