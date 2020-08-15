package src.com.sid.graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

    private boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] helper = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (DFS(adj, i, visited, helper))
                    return true;
            }
        }
        return false;

    }

    private boolean DFS(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, boolean[] helper) {
        visited[src] = true;
        helper[src] = true;

        ArrayList<Integer> neighbours = adj.get(src);
        for (int v : neighbours) {
            if (helper[v])
                return true;
            else if (visited[v] == false) {
                if (DFS(adj, v, visited, helper))
                    return true;
            }

        }
        helper[src] = false;
        return false;
    }
}
