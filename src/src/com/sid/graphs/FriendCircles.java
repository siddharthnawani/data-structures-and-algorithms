package src.com.sid.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. Friend Circles
 * <p>
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 */
public class FriendCircles {

    /**
     * Using BFS
     * */
    public int findCircleNum(int[][] M) {

        int ans = BFS(M);
        return ans;

    }

    private int BFS(int[][] adj_mat) {
        boolean[] visited = new boolean[adj_mat.length];
        int ans = 0;
        for (int i = 0; i < adj_mat.length; i++) {
            if (visited[i] == false) {
                bfsHelper(adj_mat, i, visited);
                ans++;
            }
        }
        return ans;
    }

    private void bfsHelper(int[][] adj_mat, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
            Integer v = q.poll();
            for (int j = 0; j < adj_mat.length; j++) {
                if (adj_mat[v][j] == 1 && visited[j] == false) {
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }

    /**
     * Using DFS
     * */
    private int DFS(int[][] adj_mat)
    {
        boolean[] visited=new boolean[adj_mat.length];
        int ans=0;
        for(int i=0;i<adj_mat.length;i++)
        {
            if(visited[i]==false){
                dfsHelper(adj_mat,i,visited);
                ans++;
            }
        }
        return ans;
    }

    private void dfsHelper(int[][] adj_mat,int sv,boolean[] visited) {
        int r=adj_mat.length;
        int c=adj_mat[0].length;
        visited[sv]=true;
        for(int i=0;i<r;i++){
            if(adj_mat[sv][i]==1 && !visited[i]){
                dfsHelper(adj_mat,i,visited);
            }
        }
    }
    /**
     * Using Union Find
     * */
    private int count=0;
    private int[] parent,rank;
    class UnionFind{

         UnionFind(int n){
            count=n;
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++)
                parent[i]=i;
        }

        public int find(int n){
            while(n!=parent[n]){
                parent[n]=parent[parent[n]];
                n=parent[n];
            }
            return n;
        }

        public void union(int a,int b){
            int roota=find(a);
            int rootb=find(b);

            if(roota == rootb) return;

            if(rank[roota] > rank[rootb]){
                parent[rootb]=roota;
            }
            else{
                parent[roota]=rootb;
                if(rank[roota] == rank[rootb])
                    rank[rootb]++;
            }

            count--;
        }

        public int count(){
            return count;
        }

    }//end of union class

    public int findCircleNumUsingUnionFind(int[][] M) {
        UnionFind uf=new UnionFind(M.length);
        for(int i=0;i<M.length-1;i++){
            for(int j=i+1;j<M[0].length;j++){
                if(M[i][j]==1) uf.union(i,j);
            }
        }
        return count;

    }
    public static void main(String[] args) {
        int[][] adj_mat = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Solution Using BFS "+new FriendCircles().BFS(adj_mat));
        System.out.println("Solution Using DFS "+new FriendCircles().DFS(adj_mat));
        System.out.println("Solution Using Union Find "+new FriendCircles().findCircleNumUsingUnionFind(adj_mat));
    }
}
