package Graphs;

import java.util.*;

public class UnionFindCycle {
    static class Graph {
        int V;
        ArrayList<Edge> edges;

        Graph(int V) {
            this.V = V;
            edges = new ArrayList<>();
        }

        void addEdge(int u, int v) {
            edges.add(new Edge(u, v));
        }

        static class Edge {
            int src, dest;
            Edge(int s, int d) {
                src = s;
                dest = d;
            }
        }

        // Find with path compression
        int find(int[] parent, int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent, parent[i]);
        }

        // Union by setting parent
        void union(int[] parent, int x, int y) {
            int xset = find(parent, x);
            int yset = find(parent, y);
            parent[xset] = yset;
        }

        boolean isCycle() {
            int[] parent = new int[V];
            for (int i = 0; i < V; i++)
                parent[i] = i;

            for (Edge e : edges) {
                int x = find(parent, e.src);
                int y = find(parent, e.dest);

                if (x == y)
                    return true;  // Cycle found

                union(parent, x, y);
            }

            return false; // No cycle
        }
    }

    public static void main(String[] args) {
        // Example Graph
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 2);

        if (g.isCycle())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
