package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.*;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 323. Number of Connected Components in an Undirected Graph
 * <p>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
    //union find
    public int countComponents_unionFind(int n, int[][] edges) {
        if (n == 0 || n == 1) return n;

        int[] roots = new int[n];
        for (int i = 0; i < n; i++)
            roots[i] = i;

        for (int[] edge : edges) {
            int rootx = find(roots, edge[0]);
            int rooty = find(roots, edge[1]);
            if (rootx != rooty) {
                roots[rooty] = rootx;
                n--;
            }
        }

        return n;

    }

    private int find(int[] roots, int x) {
        if (roots[x] != x) {
            roots[x] = find(roots, roots[roots[x]]);
        }
        return roots[x];

    }

    //dfs
    public int countComponents_dfs(int n, int[][] edges) {
        if (n == 0 || n == 1) return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfs(map, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(Map<Integer, List<Integer>> map, int e, Set<Integer> visited) {
        for (int neighbor : map.get(e)) {
            if (visited.add(neighbor))
                dfs(map, neighbor, visited);
        }

    }

    //bfs
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || n == 1) return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                bfs(map, i, visited);
                count++;
            }
        }
        return count;
    }

    private void bfs(Map<Integer, List<Integer>> map, int e, Set<Integer> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(e);

        while (!q.isEmpty()) {
            int root = q.poll();
            for (int neighbor : map.get(root)) {
                if (visited.add(neighbor)) {
                    q.add(neighbor);
                }
            }
        }

    }
}
