package src.com.sid.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteBetweenTwoNodesInDirectedGraph {

    static class Graph{
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int V){
            this.V=V;
            adj=new LinkedList[V];
            for(int i=0;i<V;i++){
                adj[i]=new LinkedList<>();
            }

        }

        private void addEdge(int s,int e){
            adj[s].add(e);
        }

        Boolean isReachable2(int s,int e)
        {
            boolean[] visited=new boolean[V];
            Queue<Integer> queue=new LinkedList<>();

            queue.add(s);
            visited[s]=true;

            while(!queue.isEmpty())
            {
                int elem=queue.poll();

                for(Integer v:adj[elem]){
                    if(e ==v){
                        return true;
                    }
                    if(!visited[v]){
                        visited[v]=true;
                        queue.add(v);
                    }


                }
            }
            return Boolean.FALSE;
        }
    }

    public static void main(String[] args) {

        Graph g=new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1;
        int v = 3;
        if (g.isReachable2(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;

        u = 3;
        v = 1;
        if (g.isReachable2(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;


    }

}
