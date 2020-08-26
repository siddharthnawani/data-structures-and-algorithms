package src.com.sid.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. Is Graph Bipartite?
 * Given an undirected graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 * <p>
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 ***/
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        //have a bfs and keep a colourd array to track
        //while doing dfs try to color the whole graph
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 1 || colors[i] == -1)
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            colors[i] = 1;

            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int next : graph[curr]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[curr];
                        q.add(next);
                    } else if (colors[next] == colors[curr])
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(new IsGraphBipartite().isBipartite(graph));
    }
}
