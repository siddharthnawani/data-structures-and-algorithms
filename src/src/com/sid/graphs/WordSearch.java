package src.com.sid.graphs;

/**
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * Constraints:
 *
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * **/
public class WordSearch {
    public boolean exist(char[][] board, String word)
    {
        int r=board.length;
        int c=board[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==word.charAt(0) && dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int i,int j ,int pos, String word){
        if(pos==word.length())
            return true;
        int r=board.length;
        int c=board[0].length;

        if(i <0|| j<0|| i>=r ||  j>=c || board[i][j] !=word.charAt(pos))
            return false;
        char temp=board[i][j];
        board[i][j]='*';
        boolean found=dfs(board,i+1,j,pos+1,word)||
                dfs(board,i-1,j,pos+1,word)||
                dfs(board,i,j+1,pos+1,word)||
                dfs(board,i,j-1,pos+1,word);
        board[i][j]=temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word="ABCCED";
        System.out.println(new WordSearch().exist(board,word));
    }
}
