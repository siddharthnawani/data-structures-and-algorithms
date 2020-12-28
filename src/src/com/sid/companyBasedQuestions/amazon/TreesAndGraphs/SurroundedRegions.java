package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * **/
public class SurroundedRegions {
    private int row=0;
    private int col=0;

    public void solve(char[][] board) {
        if(board.length==0) return;

        row=board.length;
        col=board[0].length;
        //only chek border entris
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(i==0 || i==row-1 || j==0 || j==col-1){
                    //dfs(board,i,j);
                    bfs(board,i,j);
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='E')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }


    }

    private void dfs(char[][] board,int r,int c){
        if(r <0 || r >=row || c <0 || c>=col || board[r][c]!='O')
            return;
        board[r][c]='E';
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }

    private void bfs(char[][] board,int r,int c){
        if(board[r][c]!='O')
            return;
        Queue<Integer> q=new LinkedList<>();
        int code=r*col+c;
        q.add(code);
        board[r][c]='E';//mark it as visited

        while(!q.isEmpty()){
            code=q.poll();
            int _row=code/col;
            int _col=code%col;

            if(_row-1 >=0 && board[_row-1][_col]=='O'){
                board[_row-1][_col]='E';
                q.add((_row-1)*col+_col);
            }
            if(_row+1 <row && board[_row+1][_col]=='O'){
                board[_row+1][_col]='E';
                q.add((_row+1)*col+_col);
            }
            if(_col-1 >=0 && board[_row][_col-1]=='O'){
                board[_row][_col-1]='E';
                q.add(_row*col+(_col-1));
            }
            if(_col+1 <col && board[_row][_col+1]=='O'){
                board[_row][_col+1]='E';
                q.add(_row*col+(_col+1));
            }


        }


    }
}
