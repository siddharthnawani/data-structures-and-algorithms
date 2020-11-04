package src.com.sid.algorithms.graphs.TopologicalSorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/topological-sorting/
 * <p>
 * Algorithm to find Topological Sorting:
 * <p>
 * We recommend to first see the implementation of DFS. We can modify DFS to find Topological Sorting of a graph. In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices. In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of the stack. Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack.
 **/
public class TopologicalSortUsingDFS {
    static class Graph {

        int V;
        private ArrayList<ArrayList<Integer>> adj;

        Graph(int v) {
            V = v;
            adj = new ArrayList<ArrayList<Integer>>(v);
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<Integer>());
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        // The function to do Topological Sort.
        // It uses recursive topologicalSortUtil()
        void topologicalSort() {

            Stack<Integer> st = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                visited[i] = false;
            }

            for (int i = 0; i < V; i++) {
                if (visited[i] == false) {
                    topologicalSortUtil(i, visited, st);
                }
            }

            // Print contents of stack
            while (st.size() > 0)
                System.out.print(st.pop() + " ");

        }

        private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> st) {
            visited[v] = true;
            Integer i;


            // Recur for all the vertices adjacent
            // to thisvertex
            for (int neighbor : adj.get(v)) {
                if (visited[neighbor] == false) {
                    topologicalSortUtil(neighbor, visited, st);
                }
            }
            // Push current vertex to stack
            // which stores result
            st.push(v);
        }

    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }
}
