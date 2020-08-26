package src.com.sid.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 886. Possible Bipartition
 * <p>
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * <p>
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * <p>
 * Return true if and only if it is possible to split everyone into two groups in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 * <p>
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 * <p>
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 ***/
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        //Make an adjacency list out of this
        List<Integer>[] graph = new List[N + 1];
        int[] color = new int[N + 1];


        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        //fill your adjacency list
        for (int[] v : dislikes) {
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }

        for (int i = 1; i <= N; i++) {

            if (color[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int neighbor : graph[curr]) {

                        if (color[neighbor] == color[curr])
                            return false;
                        if (color[neighbor] == 0) {
                            q.add(neighbor);
                            color[neighbor] = -color[curr];
                        }

                    }
                }

            }

        }
        return true;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] dislikes = {
                {1, 2},
                {1, 3},
                {2, 4}
        };
        System.out.println(new PossibleBipartition().possibleBipartition(N, dislikes));
    }


}
