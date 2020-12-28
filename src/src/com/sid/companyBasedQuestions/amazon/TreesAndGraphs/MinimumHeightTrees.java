package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 * 310. Minimum Height Trees
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 * <p>
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 * <p>
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 * <p>
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 ***/
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        //build th adjacency list
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new HashSet<>());

        for (int edge[] : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        //Get the first layer of leaves
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1)
                leaves.add(i);
        }

        //start trimming
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                Integer neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove(leaf);
                if (adjList.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }

        return leaves;

    }
}
