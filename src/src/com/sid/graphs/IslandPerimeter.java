package src.com.sid.graphs;

/**
 * 463. Island Perimeter
 * <p>
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Output: 16
 ***/
public class IslandPerimeter {
    int count = 0;

    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j);
                    break; //Since it is mentioned in the quetion that there is only one
                    //island else there is no need of break
                }
            }
        }
        return count;
    }

    private void bfs(int[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;
        if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == 0) //water is there
        {
            count++;
            return;

        }
        if (grid[i][j] == -1) return;
        grid[i][j] = -1;
        bfs(grid, i + 1, j);
        bfs(grid, i - 1, j);
        bfs(grid, i, j + 1);
        bfs(grid, i, j - 1);

    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }
}
