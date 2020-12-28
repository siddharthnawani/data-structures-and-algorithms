package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 * 261. Graph Valid Tree
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 *
 * Here we have applied the approach where for a graph to bea a tree it should have n-1 edges exactly and it should be fully connected.
 *
 **/
public class GraphValidTree {

    //there are many approaches fro these; highly recommend to go through the soltion section.But we will use bfs. this is basically an udirected graph

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> adjacencyList = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        // Make the adjacency list.
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        dfs(0, adjacencyList, seen);
        return seen.size() == n;

    }

    private void dfs(int node, List<List<Integer>> adjacencyList, Set<Integer> seen) {
        if (seen.contains(node)) return;
        seen.add(node);
        for (int neighbor : adjacencyList.get(node)) {
            if (neighbor == node) continue;
            dfs(neighbor, adjacencyList, seen);
        }
    }
}
