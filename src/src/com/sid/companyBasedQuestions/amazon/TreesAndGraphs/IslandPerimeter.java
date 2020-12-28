package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

/**
 * https://leetcode.com/problems/island-perimeter/
 * 463. Island Perimeter
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 **/
public class IslandPerimeter {
    int count = 0;

    //recursive
    public int islandPerimeter_dfs(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return count;
                }

            }
        }

        return -1;
    }

    private void dfs(int[][] grid, int r, int c) {
        //encounter a boundary increment the counter and return
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            count++;
            return;
        }
        if (grid[r][c] == -1) return;//already visited this land
        grid[r][c] = -1;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    //iterative
    public int islandPerimeter(int[][] grid) {

        //traverse row wise
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4; //we are consdering all the 4 sides

                    //check for adjacent land and remove the shared boundaries
                    //check for previous boundary
                    if (j - 1 >= 0 && grid[i][j - 1] == 1)
                        count -= 2; //-1 for previous and -1 for current land

                    //check for upper boundary
                    if (i - 1 >= 0 && grid[i - 1][j] == 1)
                        count -= 2; //-1 for previous and -1 for current land

                }


            }
        }


        return count;
    }
}
