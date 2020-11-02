package src.com.sid.algorithms.graphs.StronglyConnectedComponents;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * You tube link : https://www.youtube.com/watch?v=ZeDNSeilf-Y
 * Geeks link: https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
 * <p>
 * // Java program to find strongly connected
 * // components in a given directed graph
 * // using Tarjan's algorithm (single DFS)
 * Algorithm :
 * <p>
 * Tarjan Algorithm is based on following facts:
 * 1. DFS search produces a DFS tree/forest
 * 2. Strongly Connected Components form subtrees of the DFS tree.
 * 3. If we can find the head of such subtrees, we can print/store all the nodes in that subtree (including head) and that will be one SCC.
 * 4. There is no back edge from one SCC to another (There can be cross edges, but cross edges will not be used while processing the graph).
 * <p>
 * <p>
 * Case1 (Tree Edge): If node v is not visited already, then after DFS of v is complete, then minimum of low[u] and low[v] will be updated to low[u].
 * low[u] = min(low[u], low[v]);
 * Case 2 (Back Edge): When child v is already visited, then minimum of low[u] and Disc[v] will be updated to low[u].
 * low[u] = min(low[u], disc[v]);
 * <p>
 * Time Complexity:
 * The time complexity of Tarjan’s Algorithm and Kosaraju’s Algorithm will be O(V + E), where V represents the set of vertices and E represents the set of edges of the graph. Tarjan’s algorithm has much lower constant factors w.r.t Kosaraju’s algorithm. In Kosaraju’s algorithm, the traversal of the graph is done at least 2 times, so the constant factor can be of double time. We can print the SCC in progress with Kosaraju’s algorithm as we perform the second DFS. While performing Tarjan’s Algorithm, it requires extra time to print the SCC after finding the head of the SCCs sub-tree.
 * <p>
 * Summary:
 * Both the methods have the same linear time complexity, but the techniques or the procedure for the SCC computations are fairly different. Tarjan’s method solely depends on the record of nodes in a DFS to partition the graph whereas Kosaraju’s method performs the two DFS (or 3 DFS if we want to leave the original graph unchanged) on the graph and is quite similar to the method for finding the topological sorting of a graph.
 **/

public class TarjanAlgorithm {

    // This class represents a directed graph
    // using adjacency list representation
    static class Graph {
        //No of vertices
        private int V;
        //Adjacency Lists
        private LinkedList<Integer> adj[];
        private int Time;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
            Time = 0;
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void SCC() {
            // Mark all the vertices as not visited
            // and Initialize parent and visited,
            // and ap(articulation point) arrays
            int disc[] = new int[V];
            int low[] = new int[V];

            for (int i = 0; i < V; i++) {
                disc[i] = -1;
                low[i] = -1;
            }

            boolean stackMember[] = new boolean[V];
            Stack<Integer> st = new Stack<>();

            // Call the recursive helper function
            // to find articulation points
            // in DFS tree rooted with vertex 'i'
            for (int i = 0; i < V; i++) {
                if (disc[i] == -1) {
                    SCCUtil(i, low, disc, stackMember, st);
                }
            }


        }

        // A recursive function that finds and prints strongly
        // connected components using DFS traversal
        // u --> The vertex to be visited next
        // disc[] --> Stores discovery times of visited vertices
        // low[] -- >> earliest visited vertex (the vertex with
        //             minimum discovery time) that can be reached
        //             from subtree rooted with current vertex
        // st -- >> To store all the connected ancestors (could be part
        //         of SCC)
        // stackMember[] --> bit/index array for faster check
        //                   whether a node is in stack
        private void SCCUtil(int u, int[] low, int[] disc, boolean[] stackMember, Stack<Integer> st) {

            disc[u] = Time;
            low[u] = Time;
            Time++;

            st.push(u);
            stackMember[u] = true;

            int neighbour;
            Iterator<Integer> i = adj[u].iterator();

            while (i.hasNext()) {
                neighbour = i.next();

                if (disc[neighbour] == -1) {

                    SCCUtil(neighbour, low, disc, stackMember, st);

                    //when backtracking
                    // Check if the subtree rooted with v
                    // has a connection to one of the
                    // ancestors of u
                    // Case 1 (per above discussion on
                    // Disc and Low value)
                    low[u] = Math.min(low[u], low[neighbour]);

                }
                //Otherwise check if it this neighbour is part of our current stack traversal; bcoz in that cae this could be a BACK EDGE RATHER THAN A CROSS EDGE

                else if (stackMember[neighbour] == true) {
                    // Update low value of 'u' only if 'v' is
                    // still in stack (i.e. it's a back edge,
                    // not cross edge).
                    // Case 2 (per above discussion on Disc
                    // and Low value)
                    low[u] = Math.min(low[u], disc[neighbour]);
                }

            }

            // head node found, pop the stack and print an SCC
            // To store stack extracted vertices
            int w = -1;

            if (low[u] == disc[u]) {

                //Empty the stack till you find this head element again
                //this will be a speific SCC
                while (w != u) {
                    w = st.pop();
                    System.out.print(w + " ");
                    stackMember[w] = false;
                }
                System.out.println();

            }


        }

    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph g1 = new Graph(5);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println("SSC in first graph ");
        g1.SCC();

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        System.out.println("\nSSC in second graph ");
        g2.SCC();

        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        System.out.println("\nSSC in third graph ");
        g3.SCC();

        Graph g4 = new Graph(11);
        g4.addEdge(0, 1);
        g4.addEdge(0, 3);
        g4.addEdge(1, 2);
        g4.addEdge(1, 4);
        g4.addEdge(2, 0);
        g4.addEdge(2, 6);
        g4.addEdge(3, 2);
        g4.addEdge(4, 5);
        g4.addEdge(4, 6);
        g4.addEdge(5, 6);
        g4.addEdge(5, 7);
        g4.addEdge(5, 8);
        g4.addEdge(5, 9);
        g4.addEdge(6, 4);
        g4.addEdge(7, 9);
        g4.addEdge(8, 9);
        g4.addEdge(9, 8);
        System.out.println("\nSSC in fourth graph ");
        g4.SCC();

        Graph g5 = new Graph(5);
        g5.addEdge(0, 1);
        g5.addEdge(1, 2);
        g5.addEdge(2, 3);
        g5.addEdge(2, 4);
        g5.addEdge(3, 0);
        g5.addEdge(4, 2);
        System.out.println("\nSSC in fifth graph ");
        g5.SCC();

    }

}
