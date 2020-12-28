package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-distinct-islands/
 * <p>
 * 694. Number of Distinct Islands
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 * <p>
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 * <p>
 * Ref: https://leetcode.com/problems/number-of-distinct-islands/discuss/108475/Java-very-Elegant-and-concise-DFS-Solution(Beats-100)
 ***/
public class NumberofDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0) return 0;
        Set<String> paths = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                StringBuilder path = new StringBuilder();
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, path, "o");//origin start the direction of path
                    paths.add(path.toString());
                }
            }
        }

        return paths.size();
    }

    private void dfs(int[][] grid, int r, int c, StringBuilder path, String dir) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1)
            return;
        grid[r][c] = 0;
        path.append(dir);

        dfs(grid, r + 1, c, path, "u");
        dfs(grid, r - 1, c, path, "d");
        dfs(grid, r, c - 1, path, "l");
        dfs(grid, r, c + 1, path, "r");

        path.append("b");//backtracking -- this is very important to distincguish diff paths
    }
}
