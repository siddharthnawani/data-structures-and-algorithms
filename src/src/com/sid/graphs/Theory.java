package src.com.sid.graphs;

public class Theory {

    /**
     *
     * 1. Generally used to depict use cases in which different components are there; They may or may not be
     *    connected.
     * 2. Tree is also a special type og graph with no cycle. Plus we can go from any nod eto other node.
     * 3. Different compoenent are called vertex and they have edge b/w them.
     * 4. Degree of a vertex is no of edges passing through the vertex.
     * 5. Adjacent vertex have a edge b/w them.
     * 6. Path : Collection of edges b/w vertex.
     * 7. Connected Components : vertex which have path b/w them
     * 8. min no of edges to make a graph of n vertex connected is n-1;
     * 9. Implementation ways :
     *      9.1 Edge list implementation where every edge pair is siored in a list. Time to check if there is an edge b/w two
     *      components is n^2
     *      9.2 Adjacency List : Array/list of vertex where each vertex contains a list of connected nodes. Time to check
     *      Ex: List<Integer>[] g = new ArrayList[n]; // This is an array of List
     *      if there is an edge b/w 2 vertex is n. O(1) to reach a vertex and O(n) to traverse the lsit attached to it.
     *      Its space complexity is better than that of Adjacency matrix.
     *      9.3 Adjacency matrix : 2D array representing vertex with V(i,j) is 1 , if there an egde between vertex i and
     *      j. Time to check edge b/w any component is O(1); but space complexity is n^2.
     *      9.4 Incidence Matrix : optimization of Adjacency matrix for space i.e for sparse graphs. Row and columns are
     *      Edges and vertices, rest is same as Adjacency matrix.
     * 10. DFS : Time compleity O(V+E) -> goes to vertex and then traverse back through the edges;
     *           Space Complexity O(V) -> all the vertex are stored in the stack. Possible in case of vertical graph.
     * 11. BFS : Time Complexity O(V+E) ; -> goes to vertex while pushing in the queue and once while popping it out.
     *           Space Complexity O(V) -> worst case when all are immediate child of root.
     *
     * ***/
}
