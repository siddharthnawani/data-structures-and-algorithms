package src.com.sid.graphs;

import java.util.*;

/****
 *
 *Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0]and thus will not appear together in edges.
 *
 * Ref :
 * https://zhuhan0.blogspot.com/2017/07/leetcode-261-graph-valid-tree.html
 * https://www.programcreek.com/2014/05/graph-valid-tree-java/
 *
 * ***/
public class GraphValidTree {

    /**
     * DFS Solutions
     **/
    //Time Complexity O(V+E)
    public boolean validTreeUsingDFS(int n, int[][] edges) {
        //Make an adjacency list out of it
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (!hasCycle(0, -1, visited, map))
            return true;

        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;

    }

    private boolean hasCycle(int curr, int parent, boolean[] visited, Map<Integer, List<Integer>> adj_list) {
        visited[curr] = true;

        for (int n : adj_list.get(curr)) {
            if (visited[n] && parent != n)
                return true;
            else if (!visited[n])
                return hasCycle(n, curr, visited, adj_list);
        }
        return false;
    }

    /***
     * BFS Solution
     *
     * ***/
    public boolean validTreeUsingBFS(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int[] edge : edges) {
            int src = edge[0];
            int des = edge[1];
            list.get(src).add(des);
            list.get(des).add(src);
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int head = q.poll();
            if (visited.contains(head))
                return false;
            visited.add(head);
            for (int v : list.get(head)) {
                if (!visited.contains(v))
                    q.add(v);
            }
        }

        return visited.size() == n;

    }

    /**
     * BFS Solution 2
     * <p>
     * If a graph is valid binary tree, it must follow the two conditions:
     * 1. num of edges = num of nodes - 1
     * 2. There is only 1 Connected Component
     **/
    public boolean validTreeUsingBFS2(int n, int[][] edges) {
        // write your code here
        if (n == 0) {
            return edges == null || edges.length == 0;
        }

        if (edges.length != n - 1) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add nodes to the adjList
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        // start bfs from each node, if it's not visited
        bfs(adjList, 0, visited);

        return visited.size() == n;
    }

    private void bfs(List<List<Integer>> adjList, int root, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.get(node)) {
                if (visited.contains(neighbor)) {
                    continue;
                }

                queue.offer(neighbor);
                visited.add(neighbor);
            }
        }
    }

    /**
     * Using Union & Find
     * <p>
     * If a graph is valid binary tree, it must follow the two conditions:
     * 1. num of edges = num of nodes - 1
     * 2. There is only 1 Connected Component
     **/

    public boolean validTreeUsingUnionFind(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n]; //union by size

        //Everyone is their own parent
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            //checking 2nd condition
            if (!union(edge[0], edge[1], parent, size))
                return false;
        }
        //checking 1nd condition num of edges = num of nodes - 1
        return edges.length == n - 1;
    }

    private boolean union(int src, int des, int[] parent, int[] size) {
        int src_parent = find(src, parent);
        int des_parent = find(des, parent);

        if (src_parent == des_parent)
            return false;
        if (size[src_parent] < size[des_parent]) {
            parent[src_parent] = des_parent;
            size[des_parent]++;
        } else {
            parent[des_parent] = src_parent;
            size[src_parent]++;
        }
        return true;
    }

    private int find(int v, int[] parent) {
        if (parent[v] == v)
            return v;
        return find(parent[v], parent);
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[4][2];
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{0, 2};
        edges[2] = new int[]{0, 3};
        edges[3] = new int[]{1, 4};

        System.out.println("Using DFS " + new GraphValidTree().validTreeUsingDFS(n, edges));
        System.out.println("Using BFS " + new GraphValidTree().validTreeUsingBFS(n, edges));
        System.out.println("Using BFS 2 " + new GraphValidTree().validTreeUsingBFS2(n, edges));
        System.out.println("Using Union Find " + new GraphValidTree().validTreeUsingUnionFind(n, edges));
        System.out.println("Test case 2 ");
        n = 5;
        edges = new int[5][2];
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{1, 2};
        edges[2] = new int[]{2, 3};
        edges[3] = new int[]{1, 3};
        edges[4] = new int[]{1, 4};

        System.out.println("Using DFS " + new GraphValidTree().validTreeUsingDFS(n, edges));
        System.out.println("Using BFS " + new GraphValidTree().validTreeUsingBFS(n, edges));
        System.out.println("Using BFS 2 " + new GraphValidTree().validTreeUsingBFS2(n, edges));
        System.out.println("Using Union Find " + new GraphValidTree().validTreeUsingUnionFind(n, edges));
    }
}
