package src.com.sid.graphs;

import java.util.Arrays;

/***
 *
 * I/p:
 * 0 --[10]--- 1
 * | \         |
 * |  \        |
 * [6] \       [15]
 * |    [5]    |
 * |       \   |
 * 2 --[4]-- 3
 *
 * O/p :
 *
 * 2 -> 3 -> 4
 * 0 -> 3 -> 5
 * 0 -> 1 -> 10
 *
 * ***/
public class KruskalAlgorithmForMST {
    static class Edge implements Comparable<Edge> {
        int src = 0;
        int des = 0;
        int weight = 0;

        Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    public static void main(String[] args) {
        int v = 4;
        int e = 5;
        Edge[] inp = new Edge[e];
        //initialize input array
        inp[0] = new Edge(0, 1, 10);
        inp[1] = new Edge(0, 2, 6);
        inp[2] = new Edge(0, 3, 5);
        inp[3] = new Edge(2, 3, 4);
        inp[4] = new Edge(1, 3, 15);

        new KruskalAlgorithmForMST().kruskal(inp, v, e);

    }

    private void kruskal(Edge[] inp, int v, int e) {
        //Sort the array acc to the weights
        Arrays.sort(inp);
        int k = 0;
        Edge[] op = new Edge[v - 1];
        int[] parent = new int[e];

        for (int i = 0; i < e; i++)
            parent[i] = i;

        for (int i = 0; i < e; i++) {
            if (k == v - 1)
                break;
            Edge currEdge = inp[i];
            int src_parent = find(currEdge.src, parent);
            int des_parent = find(currEdge.des, parent);

            if (src_parent != des_parent) {
                op[k] = currEdge;
                parent[src_parent] = des_parent;
                k++;
            }
        }

        for (int i = 0; i < v - 1; i++)
            System.out.println(op[i].src + " -> " + op[i].des + " -> " + op[i].weight);

    }

    private int find(int v, int[] parent) {
        if (parent[v] == v)
            return v;
        return find(parent[v], parent);
    }
}
