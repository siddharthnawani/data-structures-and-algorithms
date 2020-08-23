package src.com.sid.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1557. Minimum Number of Vertices to Reach All Nodes
 * <p>
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
 * <p>
 * Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
 * <p>
 * Notice that you can return the vertices in any order.
 * Example 1:
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * Output: [0,3]
 * Explanation: It's not possible to reach all the nodes from a single vertex. From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output [0,3].
 * <p>
 * Example 2:
 * <p>
 * Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
 * Output: [0,2,3]
 * Explanation: Notice that vertices 0, 3 and 2 are not reachable from any other node, so we must include them. Also any of these vertices can reach nodes 1 and 4.
 * <p>
 * <p>
 * Complexity
 * Time O(E)
 * Space O(N)
 **/
public class MinimumNumberOfVerticesToReachAllNodes {

    /**
     * Just adding one more point, before solving such problem, we should keep in mind what kind of graph it is,       * since the graph is DAG( directed a-cyclic graph), each node could not be re visited, so we have to count all     * nodes with in-deg=0, that will be our answer.
     */


    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //try to find the indegree of all the edges
        int inDegree[] = new int[n];
        List<Integer> res = new ArrayList<>();
        for (List<Integer> e : edges) {
            inDegree[e.get(1)]++;
        }
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0)
                res.add(i);
        return res;
    }

    //Adding just to show how to make adjacency list from this
    public List<Integer> findSmallestSetOfVerticesAfterMakingAdjacencyList(int n, List<List<Integer>> edges) {
        //This is an array of arraylist
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        int[] inDegree = new int[n];
        for (List<Integer> e : edges) {
            g[e.get(0)].add(e.get(1));
            inDegree[e.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0)
                res.add(i);
        return res;

    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));

        System.out.println(new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(n, edges));
        System.out.println(new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVerticesAfterMakingAdjacencyList(n, edges));
    }

}
