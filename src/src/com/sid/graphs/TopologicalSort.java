package src.com.sid.graphs;

import java.util.*;

/***
 *
 *https://practice.geeksforgeeks.org/problems/topological-sort/1
 *
 * Topological sort
 *
 *
 *
 * **/
public class TopologicalSort {
    private int[] topoSort(ArrayList<List<Integer>> adj, int N) {
        int[] res = new int[N];
        boolean[] visited = new boolean[N];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                topo(i, adj, visited, s);
            }
        }
        int k = 0;
        while (!s.isEmpty()) {
            res[k++] = s.pop();
            System.out.print(res[k - 1]);
        }
        return res;
    }

    private void topo(int i, ArrayList<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        for (int node : adj.get(i)) {
            if (visited[node] == false) {
                visited[node] = true;
                topo(node, adj, visited, stack);
            }
        }
        stack.push(i);
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        int N = 7;
        adj.add(Arrays.asList(1));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(4));
        adj.add(Collections.EMPTY_LIST);
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(1, 5));

        new TopologicalSort().topoSort(adj, N);
        //Expected Output : 6501234
    }
}
