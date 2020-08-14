package src.com.sid.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/***
 *
 * enter no of vertex
 * 7
 * enter no of edges
 * 6
 * 0 1
 * 1 2
 * 2 3
 * 3 4
 * 4 0
 * 5 6
 * [0]
 * [1, 4]
 * [4, 2]
 * [2, 3]
 * [3]
 * [5]
 * [6]
 *
 *
 *
 * ***/
public class BFS {

    private void printBFS(int[][] adj_mat) {
        int v = adj_mat.length;
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == false)
                printHelper(adj_mat, i, visited);
        }

    }

    private void printHelper(int[][] adj_mat, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
            System.out.println(q);
            Integer e = q.poll();
            for (int i = 0; i < adj_mat.length; i++) {
                if (adj_mat[e][i]==1 && !visited[i]) {
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of vertex");
        int v = sc.nextInt();
        System.out.println("enter no of edges");
        int e = sc.nextInt();
        int adj_mat[][] = new int[v][v];
        for (int i = 0; i < e; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            adj_mat[sv][ev] = 1;
            adj_mat[ev][sv] = 1;
        }
        new BFS().printBFS(adj_mat);

    }
}
