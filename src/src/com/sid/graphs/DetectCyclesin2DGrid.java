package src.com.sid.graphs;

/***
 * 1559. Detect Cycles in 2D Grid
 * Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
 *
 * A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.
 *
 * Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
 *
 * Return true if any cycle of the same value exists in grid, otherwise, return false.
 *
 * Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
 * Output: true
 * Explanation: There are two valid cycles shown in different colors in the image below:
 *
 * **/
public class DetectCyclesin2DGrid {
    int X;
    int[][] visited;
    char[][] grid;

    public boolean containsCycle(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        this.X = 0;// To mark the paths in visited matrix
        this.visited = new int[r][c];// Keep track of visited points
        this.grid = grid;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (visited[i][j] == 0) {
                    X++;// Increment so we don't conflict paths.
                    // isCycle will mark all reachable nodes from our current point with X
                    if (isCyclic(i, j, -1, -1, grid[i][j]))
                        return true;
                }

            }
        }
        return false;

    }

    private boolean isCyclic(int r, int c, int prevR, int prevC, char orig) {
        //If out of range or not the same char as original (meaning can't continue path), return false
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != orig)
            return false;
        // If we visited this already, that means theres a cycle.
        // We don't need to check length because we make sure we don't visit a previous one already.
        if (visited[r][c] == X)
            return true;
        visited[r][c] = X;// All paths will now have the same X value.
        // For each one, visit the next point ONLY if its not a previous point.
        return ((r + 1 != prevR && isCyclic(r + 1, c, r, c, orig)) ||
                (r - 1 != prevR && isCyclic(r - 1, c, r, c, orig)) ||
                (c - 1 != prevC && isCyclic(r, c - 1, r, c, orig)) ||
                (c + 1 != prevC && isCyclic(r, c + 1, r, c, orig))

        );

    }

    public static void main(String[] args) {
        char[][] grid = {
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        };
        System.out.println(new DetectCyclesin2DGrid().containsCycle(grid));

    }
}
