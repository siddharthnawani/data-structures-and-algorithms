package src.com.sid.graphs;

/**
 * 200. Number of Islands
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 **/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    BFS(grid, i, j);
                }
            }
        }
        return count;

    }

    private void BFS(char[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;
        if (i >= 0 && j >= 0 && i < r && j < c && grid[i][j] == '1') {
            grid[i][j] = '0';
            BFS(grid, i + 1, j);
            BFS(grid, i - 1, j);
            BFS(grid, i, j + 1);
            BFS(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
