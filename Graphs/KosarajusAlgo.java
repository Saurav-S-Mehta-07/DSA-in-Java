//Strongly connected components -> (Kosaraju's Algorithm)

import java.util.*;

public class KosarajusAlgo {

    public static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        int V = graph.length;
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static ArrayList<Edge>[] getTranspose(ArrayList<Edge>[] graph) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[graph.length];
        for (int i = 0; i < graph.length; i++) {
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int v = 0; v < graph[i].size(); v++) {
                Edge e = graph[i].get(v);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        return transpose;
    }


    public static void topSort(ArrayList<Edge>[] graph, Stack<Integer> s, boolean[] visited, int src) {
        visited[src] = true;
        for (int v = 0; v < graph[src].size(); v++) {
            int neigh = graph[src].get(v).dest;
            if (!visited[neigh])
                topSort(graph, s, visited, neigh);
        }
        s.push(src);
    }

    public static void Kosaraju(ArrayList<Edge>[] graph) {

        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[graph.length];

        //(a)-> topological sort 
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i])
                topSort(graph, s, visited, i);
        }

        //(b)->transpose
        ArrayList<Edge>[] transpose = getTranspose(graph);
        Arrays.fill(visited, false);

        //(c)-> dfs
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visited[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose, visited, curr);
                System.out.println();
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int src) {
        visited[src] = true;
        System.out.print(src + " ");
        for (int v = 0; v < graph[src].size(); v++) {
            int neigh = graph[src].get(v).dest;
            if (!visited[neigh])
                dfs(graph, visited, neigh);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println("Strongly Connected Components:");
        Kosaraju(graph);
    }
} 