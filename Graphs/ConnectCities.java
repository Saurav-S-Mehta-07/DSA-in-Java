package Graphs;
import java.util.*;

public class ConnectCities {

    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            src = s; dest = d; wt = w;
        }
    }

    static class Pair {
        int node, cost;
        Pair(int n, int c) {
            node = n; cost = c;
        }
    }

    static void createGraph(int[][] cities, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[0].length; j++) {
                if (i != j && cities[i][j] != 0)
                    graph[i].add(new Edge(i, j, cities[i][j]));
            }
        }
    }

    static void minCostInConnection(ArrayList<Edge>[] graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[graph.length];
        pq.add(new Pair(0, 0));
        int minCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                minCost += curr.cost;

                for (Edge e : graph[curr.node]) {
                    if (!visited[e.dest]) pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Minimum cost to connect all cities: " + minCost);
    }

    public static void main(String[] args) {
        int[][] cities = {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(cities, graph);
        minCostInConnection(graph);
    }
}
