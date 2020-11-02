package src.com.sid.algorithms.graphs.StronglyConnectedComponents;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * You Tube Link : https://www.youtube.com/watch?v=Rs6DXyWpWrI&t=23s
 * Geeks Link : https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
 * <p>
 * Following is Kosaraju’s DFS based simple algorithm that does two DFS traversals of graph:
 * 1) Initialize all vertices as not visited.
 * <p>
 * 2) Do a DFS traversal of graph starting from any arbitrary vertex v. If DFS traversal doesn’t visit all vertices, then return false.
 * <p>
 * 3) Reverse all arcs (or find transpose or reverse of graph)
 * <p>
 * 4) Mark all vertices as not-visited in reversed graph.
 * <p>
 * 5) Do a DFS traversal of reversed graph starting from same vertex v (Same as step 2). If DFS traversal doesn’t visit all vertices, then return false. Otherwise return true.
 ***/
public class KosarajuAlgorithm {

    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void printSCCs() {
            //To store all the traversed nodes
            Stack<Integer> st = new Stack<>();
            // Step 1: Mark all the vertices as not visited
            // (For first DFS)
            Boolean[] visited = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Fill vertices in stack according to their finishing times
            for (int i = 0; i < V; i++) {
                if (visited[i] == false) {
                    fillStackInOrder(i, visited, st);
                }
            }

            // Create a reversed graph
            Graph gr = getTranspose();

            // Mark all the vertices as not
            // visited (For second DFS)
            for (int i = 0; i < V; i++)
                visited[i] = false;

            while (!st.isEmpty()) {
                int v = st.pop();

                if (visited[v] == false) {
                    gr.DFSPrintUtil(v, visited);
                    System.out.println();
                }
            }


        }

        // Recursive function to print DFS starting from v
        private void DFSPrintUtil(int v, Boolean[] visited) {

            visited[v] = true;
            System.out.print(v + " ");
            Iterator<Integer> it = adj[v].iterator();
            int n;
            while (it.hasNext()) {
                n = it.next();
                if (visited[n] == false) {
                    DFSPrintUtil(n, visited);
                }
            }


        }

        // Function that fills stack with vertices in increasing order of finishing times
        private void fillStackInOrder(int v, Boolean[] visited, Stack<Integer> st) {

            visited[v] = true;
            Iterator<Integer> it = adj[v].iterator();
            int n;
            while (it.hasNext()) {
                n = it.next();
                if (visited[n] == false) {
                    fillStackInOrder(n, visited, st);
                }
            }
            st.push(v);
        }

        Boolean isSC() {
            // Step 1: Mark all the vertices as not visited
            // (For first DFS)
            Boolean[] visited = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Step 2: Do DFS traversal starting from first vertex.
            DFSUtil(0, visited);

            // If DFS traversal doesn't visit all vertices, then
            // return false.
            for (int i = 0; i < V; i++) {
                if (visited[i] == false)
                    return false;
            }

            // Step 3: Create a reversed graph
            Graph gh = getTranspose();

            // Step 4: Mark all the vertices as not visited (For
            // second DFS)
            for (int i = 0; i < V; i++)
                visited[i] = false;


            // Step 5: Do DFS for reversed graph starting from
            // first vertex. Staring Vertex must be same starting
            // point of first DFS
            gh.DFSUtil(0, visited);

            // If all vertices are not visited in second DFS, then
            // return false
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    return false;
            return true;

        }

        // Function that returns transpose of this graph
        private Graph getTranspose() {
            Graph g = new Graph(V);

            for (int v = 0; v < V; v++) {
                Iterator<Integer> it = adj[v].iterator();
                while (it.hasNext()) {
                    g.adj[it.next()].add(v);
                }
            }
            return g;
        }

        // A recursive function to print DFS starting from v
        private void DFSUtil(int v, Boolean[] visited) {
            // Mark the current node as visited
            visited[v] = true;
            int n;

            Iterator<Integer> it = adj[v].iterator();

            while (it.hasNext()) {
                n = it.next();

                if (visited[n] == false) {
                    DFSUtil(n, visited);
                }
            }


        }

    }

    public static void main(String[] args) {


        // Given Graph
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        // Function Call to find the SCC using Kosaraju's Algorithm
        g.printSCCs();


        // Create graphs given in the above diagrams
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        if (g1.isSC())
            System.out.println("Yes");
        else
            System.out.println("No");

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        if (g2.isSC())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
