package src.com.sid.recursionanddynamicprogramming;

import java.util.HashMap;

/***
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * ***/
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        return minPathSumByRecursion(0,0,grid);
    }

    private int minPathSumByRecursion(int si, int sj, int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;

        if(si==r-1 && sj==c-1) return grid[si][sj];
        if(si>=r || sj>=c) return Integer.MAX_VALUE;

        int op1=minPathSumByRecursion(si+1,sj,grid);
        int op2=minPathSumByRecursion(si,sj+1,grid);

        return grid[si][sj]+Math.min(op1,op2);
    }

    private int minPathSumByMemoization(int si, int sj, int[][] grid, HashMap<String,Integer> hm) {
        int r=grid.length;
        int c=grid[0].length;

        if(si==r-1 && sj==c-1) return grid[si][sj];
        if(si>=r || sj>=c) return Integer.MAX_VALUE;

        String key=si+"#"+sj;
        if(hm.containsKey(key))
            return hm.get(key);

        int op1=minPathSumByRecursion(si+1,sj,grid);
        int op2=minPathSumByRecursion(si,sj+1,grid);

        hm.put(key,grid[si][sj]+Math.min(op1,op2));
        return grid[si][sj]+Math.min(op1,op2);
    }


    private int minPathSumByTabulation(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int r=grid.length;
        int c=grid[0].length;
        int[][] result=new int[r][c];

        for(int i=r-1;i>=0;i--){
            for (int j=c-1;j>=0;j--){

                if(i==r-1 && j==c-1) // for bottom last
                    result[i][j]=grid[i][j];
                else if(i==r-1 || j==c-1)  // for last row and column
                    result[i][j]= (i==r-1) ? grid[i][j]+result[i][j+1] : grid[i][j]+result[i+1][j];
                else
                    result[i][j]= Math.min(result[i][j+1],result[i+1][j])+grid[i][j];
            }
        }

        return result[0][0];

    }

    public static void main(String[] args) {
       int[][] path= {
                     {1, 3, 1},
                      {1, 5, 1},
                      {4, 2, 1}
                     };
        System.out.println(new MinimumPathSum().minPathSum(path));
        System.out.println(new MinimumPathSum().minPathSumByMemoization(0,0,path,new HashMap<String,Integer>()));
        System.out.println(new MinimumPathSum().minPathSumByTabulation(path));
    }
}
