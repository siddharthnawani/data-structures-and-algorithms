package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 * 200. Number of Islands
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
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
 ***/
public class NumberofIslands {
    //using DFS
    public int numIslands_dfs(char[][] grid) {
        if (grid.length == 0) return 0;

        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    ++res;
                    dfs(grid, i, j);
                }

            }
        }

        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1')
            return;
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    //bfs
    public int numIslands_bfs(char[][] grid) {
        if (grid.length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    ++res;
                    int code = i * c + j;
                    q.add(code);//you can store a pair class as well
                    grid[i][j] = '0';//mark it as visited
                    while (!q.isEmpty()) {
                        code = q.poll();
                        int row = code / c; // i*c/c + j/c --> i+0.somthing --> (int) i
                        int col = code % c; // i*c %c + j%c --> i*0 +j --> j

                        //explore the neightbours
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '0';
                            q.add((row - 1) * c + col);
                        }
                        if (row + 1 < r && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '0';
                            q.add((row + 1) * c + col);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '0';
                            q.add(row * c + (col - 1));
                        }
                        if (col + 1 < c && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '0';
                            q.add(row * c + (col + 1));
                        }


                    }

                }
            }
        }

        return res;
    }

    class UnionFind {

        int count;//# of connected components
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {

            count = 0;
            int r = grid.length;
            int c = grid[0].length;
            parent = new int[r * c];
            rank = new int[r * c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == '1') {
                        ++count;
                        parent[i * c + j] = i * c + j;//just a unique number for every i,j
                    }
                    rank[i * c + j] = 0;
                }
            }

        }

        //recursive
        public int find(int i) {//path compression
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        //iterative
        public int find_iterative(int i) {//path compression
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return parent[i];
        }

        public void union(int x, int y) {//union by rank
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                if (rank[p_x] > rank[p_y])
                    parent[p_y] = p_x;
                else if (rank[p_x] < rank[p_y])
                    parent[p_x] = p_y;
                else {
                    parent[p_y] = p_x;
                    rank[p_x] += 1;
                }
                count--;
            }
        }

    }

    //union find
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1')
                        uf.union(i * c + j, (i - 1) * c + j);
                    if (i + 1 < r && grid[i + 1][j] == '1')
                        uf.union(i * c + j, (i + 1) * c + j);
                    if (j - 1 >= 0 && grid[i][j - 1] == '1')
                        uf.union(i * c + j, i * c + (j - 1));
                    if (j + 1 < c && grid[i][j + 1] == '1')
                        uf.union(i * c + j, i * c + (j + 1));

                }
            }
        }


        return uf.count;

    }
}
